package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;
import java.util.Objects;

/**
 * Aluno cadastrado na rede de academias.
 *
 * - CPF é String: tem zeros à esquerda e pode ter formatação (000.000.000-00)
 * - Telefone é String: mesmo motivo do CPF
 * - status boolean: ativo (true) ou inativo (false)
 *   O aluno é inativado automaticamente quando seu contrato é cancelado.
 */
@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(unique = true, length = 20)
    private String telefone;

    @Column(nullable = false, unique = true)
    private String email;

    /**
     * true = ativo, false = inativo.
     * Inativado automaticamente ao cancelar contrato.
     */
    @Column(nullable = false)
    private boolean status;

    // --- Getters e Setters ---

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

    // --- equals, hashCode e toString ---

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return id == aluno.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }
}
