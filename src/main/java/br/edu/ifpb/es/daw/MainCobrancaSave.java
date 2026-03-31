package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.CobrancaDAO;
import br.edu.ifpb.es.daw.dao.impl.CobrancaDAOImpl;
import br.edu.ifpb.es.daw.entities.Cobranca;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MainCobrancaSave {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            CobrancaDAO dao = new CobrancaDAOImpl(emf);

            Cobranca cobranca = new Cobranca();
            cobranca.setStatus(true);
            cobranca.setValor(BigDecimal.valueOf(100.50));
            cobranca.setDataVencimento(LocalDate.now().plusDays(30));
            cobranca.setDataPagamento(LocalDate.now());
            cobranca.setFormaPagamento("Cartão de Crédito");

            dao.save(cobranca);
            System.out.println("Cobranca salva: " + cobranca);
        }
    }
}