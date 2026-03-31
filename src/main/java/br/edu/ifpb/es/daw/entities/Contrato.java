package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Contrato entre um aluno e a academia.
 *
 * É o único ponto de associação entre um aluno e uma unidade física —
 * o aluno não tem unidade fixa no cadastro, a unidade fica aqui.
 *
 * Relacionamentos (aluno, unidade, plano) são armazenados apenas como
 * IDs inteiros nesta fase. O mapeamento @ManyToOne será feito depois,
 * conforme orientação do professor.
 *
 * - status String: "ativo" ou "cancelado" — boolean não representaria
 *   os dois estados nomeados do minimundo.
 * - dataTermino: calculada automaticamente com base na duração do plano
 *   (lógica de negócio, não responsabilidade da entidade em si).
 */
@Entity
@Table(name = "contrato")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * ID do aluno vinculado a este contrato.
     * Relacionamento será mapeado com @ManyToOne em etapa futura.
     */
    @Column(nullable = false)
    private int alunoId;

    /**
     * ID da unidade de origem deste contrato.
     * Relacionamento será mapeado com @ManyToOne em etapa futura.
     */
    @Column(nullable = false)
    private int unidadeId;

    /**
     * ID do plano escolhido neste contrato.
     * Relacionamento será mapeado com @ManyToOne em etapa futura.
     */
    @Column(nullable = false)
    private int planoId;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = false)
    private LocalDate dataTermino;

    /**
     * "ativo" ou "cancelado".
     * Cancelar um contrato inativa automaticamente o aluno.
     */
    @Column(nullable = false, length = 10)
    private String status;

    // --- Getters e Setters ---

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getAlunoId() { return alunoId; }
    public void setAlunoId(int alunoId) { this.alunoId = alunoId; }

    public int getUnidadeId() { return unidadeId; }
    public void setUnidadeId(int unidadeId) { this.unidadeId = unidadeId; }

    public int getPlanoId() { return planoId; }
    public void setPlanoId(int planoId) { this.planoId = planoId; }

    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }

    public LocalDate getDataTermino() { return dataTermino; }
    public void setDataTermino(LocalDate dataTermino) { this.dataTermino = dataTermino; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // --- equals, hashCode e toString ---

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contrato contrato = (Contrato) o;
        return id == contrato.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "id=" + id +
                ", alunoId=" + alunoId +
                ", unidadeId=" + unidadeId +
                ", planoId=" + planoId +
                ", dataInicio=" + dataInicio +
                ", dataTermino=" + dataTermino +
                ", status='" + status + '\'' +
                '}';
    }
}
