package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType ;


import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column( nullable = false)
    String nome;

    @Column(nullable = false)
    int cpf;

    @Column(nullable = false)
    int telefone;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    boolean status; //on = true ou off = false

    public int getId(){return this.id;}
    public String getNome(){return this.nome;}
    public int getCpf(){return this.cpf;}
    public int getTelefone(){return this.telefone;}
    public String getEmail(){return this.email;}
    public boolean getStatus(){return this.status;}

    public void setId(int id){this.id = id;}
    public void setNome(String nome){this.nome = nome;}
    public void setCpf(int cpf){this.cpf = cpf;}
    public void setTelefone(int telefone){this.telefone = telefone;}
    public void setEmail(String email){this.email = email;}
    public void setStatus(boolean status){this.status = status;}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Aluno aluno = (Aluno) obj;
        return id == aluno.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", telefone=" + telefone +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }
}
