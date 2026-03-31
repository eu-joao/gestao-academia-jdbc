package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "unidade")
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false)
    String nome;

    @Column
    String endereco;

    @Column(nullable = false)
    int cnpj;
    
    @Column
    int telefone;

    public int getId(){return this.id;}
    public String getNome(){return this.nome;}
    public String getEndereco(){return this.endereco;}
    public int getCnpj(){return this.cnpj;}
    public int getTelefone(){return this.telefone;}

    public void setId(int id){this.id = id;}
    public void setNome(String nome){this.nome= nome;}
    public void setEndereco(String endereco){ this.endereco = endereco;}
    public void setCnpj(int cnpj){this.cnpj = cnpj;}
    public void setTelefone(int telefone){this.telefone= telefone;}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Unidade unidade = (Unidade) obj;
        return id == unidade.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "Unidade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cnpj=" + cnpj +
                ", telefone=" + telefone +
                '}';
    }
}
