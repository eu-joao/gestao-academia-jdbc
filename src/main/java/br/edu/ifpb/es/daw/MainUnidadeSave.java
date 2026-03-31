package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.UnidadeDAO;
import br.edu.ifpb.es.daw.dao.impl.UnidadeDAOImpl;
import br.edu.ifpb.es.daw.entities.Unidade;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainUnidadeSave {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            UnidadeDAO dao = new UnidadeDAOImpl(emf);

            Unidade unidade = new Unidade();
            unidade.setNome("Unidade Central");
            unidade.setEndereco("Rua Principal, 123");
            unidade.setCnpj((int) System.nanoTime()); // unique
            unidade.setTelefone((int) System.nanoTime()); // unique

            dao.save(unidade);
            System.out.println("Unidade salva: " + unidade);
        }
    }
}