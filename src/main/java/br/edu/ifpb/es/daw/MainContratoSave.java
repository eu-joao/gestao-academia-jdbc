package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.ContratoDAO;
import br.edu.ifpb.es.daw.dao.impl.ContratoDAOImpl;
import br.edu.ifpb.es.daw.entities.Contrato;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class MainContratoSave {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            ContratoDAO dao = new ContratoDAOImpl(emf);

            Contrato contrato = new Contrato();
            contrato.setStatus(true);
            contrato.setDataInicio(LocalDate.now());
            contrato.setDataTermino(LocalDate.now().plusYears(1));

            dao.save(contrato);
            System.out.println("Contrato salvo: " + contrato);
        }
    }
}