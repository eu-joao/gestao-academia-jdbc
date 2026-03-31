package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.ContratoDAO;
import br.edu.ifpb.es.daw.dao.impl.ContratoDAOImpl;
import br.edu.ifpb.es.daw.entities.Contrato;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainContratoDeleteAll {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            ContratoDAO dao = new ContratoDAOImpl(emf);

            List<Contrato> contratos = dao.getAll();
            for (Contrato contrato : contratos) {
                dao.delete(contrato.getId());
                System.out.println("Deletado: " + contrato);
            }
            System.out.println("Todos os contratos deletados.");
        }
    }
}