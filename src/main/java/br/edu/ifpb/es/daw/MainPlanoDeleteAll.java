package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PlanoDAO;
import br.edu.ifpb.es.daw.dao.impl.PlanoDAOImpl;
import br.edu.ifpb.es.daw.entities.Plano;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainPlanoDeleteAll {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            PlanoDAO dao = new PlanoDAOImpl(emf);

            List<Plano> planos = dao.getAll();
            for (Plano plano : planos) {
                dao.delete(plano.getId());
                System.out.println("Deletado: " + plano);
            }
            System.out.println("Todos os planos deletados.");
        }
    }
}