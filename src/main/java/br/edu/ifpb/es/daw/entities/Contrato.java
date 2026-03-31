package br.edu.ifpb.es.daw.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType ;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contrato")
public class Contrato {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false)
    boolean status;

    @Column(nullable = false)
    LocalDate dataInicio;

    @Column(nullable = false)
    LocalDate dataTermino;

    public int getId(){return this.id;}
    public boolean getStatus(){return this.status;}
    public LocalDate getDataInicio(){return this.dataInicio;}
    public LocalDate getDataTermino(){return this.dataTermino;}

    public void setId(int id){this.id= id;}
    public void setStatus(boolean status){this.status = status;}
    public void setDataInicio(LocalDate dataInicio){this.dataInicio = dataInicio;}
    public void setDataTermino(LocalDate dataTermino){this.dataTermino = dataTermino;}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contrato contrato = (Contrato) obj;
        return id == contrato.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "id=" + id +
                ", status=" + status +
                ", dataInicio=" + dataInicio +
                ", dataTermino=" + dataTermino +
                '}';
    }
}
