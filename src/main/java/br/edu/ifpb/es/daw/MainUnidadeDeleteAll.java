package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.UnidadeDAO;
import br.edu.ifpb.es.daw.dao.impl.UnidadeDAOImpl;
import br.edu.ifpb.es.daw.entities.Unidade;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainUnidadeDeleteAll {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            UnidadeDAO dao = new UnidadeDAOImpl(emf);

            List<Unidade> unidades = dao.getAll();
            for (Unidade unidade : unidades) {
                dao.delete(unidade.getId());
                System.out.println("Deletado: " + unidade);
            }
            System.out.println("Todas as unidades deletadas.");
        }
    }
}