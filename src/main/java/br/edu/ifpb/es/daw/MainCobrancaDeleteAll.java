package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.CobrancaDAO;
import br.edu.ifpb.es.daw.dao.impl.CobrancaDAOImpl;
import br.edu.ifpb.es.daw.entities.Cobranca;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainCobrancaDeleteAll {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            CobrancaDAO dao = new CobrancaDAOImpl(emf);

            List<Cobranca> cobrancas = dao.getAll();
            for (Cobranca cobranca : cobrancas) {
                dao.delete(cobranca.getId());
                System.out.println("Deletado: " + cobranca);
            }
            System.out.println("Todas as cobrancas deletadas.");
        }
    }
}