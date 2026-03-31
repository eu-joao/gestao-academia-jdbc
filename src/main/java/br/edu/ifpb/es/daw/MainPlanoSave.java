package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PlanoDAO;
import br.edu.ifpb.es.daw.dao.impl.PlanoDAOImpl;
import br.edu.ifpb.es.daw.entities.Plano;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class MainPlanoSave {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            PlanoDAO dao = new PlanoDAOImpl(emf);

            Plano plano = new Plano();
            plano.setTipo("Mensal");
            plano.setValor(BigDecimal.valueOf(50.0));
            plano.setDuracao(30);
            plano.setPercentualDesconto(10);
            plano.setDescricao("Plano mensal com desconto");

            dao.save(plano);
            System.out.println("Plano salvo: " + plano);
        }
    }
}