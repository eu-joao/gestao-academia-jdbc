package br.edu.ifpb.es.daw.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "plano")
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false)
    String tipo;

    @Column(nullable = false, precision = 10, scale = 2)
    BigDecimal valor;

    @Column(nullable = false)
    int duracao;

    @Column
    int percentualDesconto;

    @Column(nullable = false)
    String descricao;

    public int getId(){return this.id;}
    public String getTipo(){return this.tipo;}
    public BigDecimal getValor(){return this.valor;}
    public int getDuracao(){return this.duracao;}
    public int getPercentualDesconto(){return this.percentualDesconto;}
    public String getDescricao(){return this.descricao;}

    public void setId(int id){this.id = id;}
    public void setTipo(String tipo){this.tipo = tipo;}
    public void setValor(BigDecimal valor){this.valor = valor;}
    public void setDuracao(int duracao){this.duracao = duracao;}
    public void setPercentualDesconto(int percentualDesconto){this.percentualDesconto = percentualDesconto;}
    public void setDescricao(String descricao){this.descricao = descricao;}




    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Plano plano = (Plano) obj;
        return id == plano.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "Plano{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", valor=" + valor +
                ", duracao=" + duracao +
                ", percentualDesconto=" + percentualDesconto +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
