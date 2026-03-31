package br.edu.ifpb.es.daw.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cobranca")
public class Cobranca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    @Column(nullable = false)
    boolean status;

    @Column(nullable = false, precision = 10, scale = 2)
    BigDecimal valor;

    @Column(nullable = false)
    LocalDate dataVencimento;

    @Column(nullable = false)
    LocalDate dataPagamento;

    @Column(nullable = false)
    String formaPagamento;

    public int getId(){return this.id;}
    public boolean getStatus(){return this.status;}
    public BigDecimal getValor(){return this.valor;}
    public LocalDate getDataVencimento(){return this.dataVencimento;}
    public LocalDate getDataPagamento(){return this.dataPagamento;}
    public String getFormaPagamento(){return this.formaPagamento;}

    public void setId(int id){this.id = id;}
    public void setStatus(boolean status){this.status = status;}
    public void setValor(BigDecimal valor){this.valor = valor;}
    public void setDataVencimento(LocalDate dataVencimento){this.dataVencimento = dataVencimento;}
    public void setDataPagamento(LocalDate dataPagamento){this.dataPagamento = dataPagamento;}
    public void setFormaPagamento(String formaPagamento){this.formaPagamento = formaPagamento;}
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cobranca cobranca = (Cobranca) obj;
        return id == cobranca.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "Cobranca{" +
                "id=" + id +
                ", status=" + status +
                ", valor=" + valor +
                ", dataVencimento=" + dataVencimento +
                ", dataPagamento=" + dataPagamento +
                ", formaPagamento='" + formaPagamento + '\'' +
                '}';
    }
}
