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
    private Integer id;

    /**
     * ID do aluno vinculado a este contrato.
     * Relacionamento será mapeado com @ManyToOne em etapa futura.
     */
    @Column(nullable = false)
    private Integer alunoId;

    /**
     * ID da unidade de origem deste contrato.
     * Relacionamento será mapeado com @ManyToOne em etapa futura.
     */
    @Column(nullable = false)
    private Integer unidadeId;

    /**
     * ID do plano escolhido neste contrato.
     * Relacionamento será mapeado com @ManyToOne em etapa futura.
     */
    @Column(nullable = false)
    private Integer planoId;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = false)
    private LocalDate dataTermino;

    /**
     * ATIVO ou CANCELADO.
     * Cancelar um contrato inativa automaticamente o aluno.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private StatusContrato status;

    // --- Getters e Setters ---

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getAlunoId() { return alunoId; }
    public void setAlunoId(Integer alunoId) { this.alunoId = alunoId; }

    public Integer getUnidadeId() { return unidadeId; }
    public void setUnidadeId(Integer unidadeId) { this.unidadeId = unidadeId; }

    public Integer getPlanoId() { return planoId; }
    public void setPlanoId(Integer planoId) { this.planoId = planoId; }

    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }

    public LocalDate getDataTermino() { return dataTermino; }
    public void setDataTermino(LocalDate dataTermino) { this.dataTermino = dataTermino; }

    public StatusContrato getStatus() { return status; }
    public void setStatus(StatusContrato status) { this.status = status; }

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
                ", status=" + status +
                '}';
    }
}
