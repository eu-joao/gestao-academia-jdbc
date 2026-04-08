package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.impl.CobrancaDAOImpl;
import br.edu.ifpb.es.daw.entities.Cobranca;
import br.edu.ifpb.es.daw.util.EMFUtil;
import jakarta.persistence.EntityManagerFactory;
import java.math.BigDecimal;
import java.time.LocalDate;

public class MainCobrancaSave {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = EMFUtil.build()) {

            CobrancaDAOImpl dao = new CobrancaDAOImpl(emf);

            Cobranca cobranca = new Cobranca();
            // ID fictício — FK será mapeada em etapa futura
            cobranca.setContratoId(1);
            cobranca.setDataVencimento(LocalDate.now().plusDays(30));
            cobranca.setValor(new BigDecimal("99.90"));
            // dataPagamento null: ainda não foi paga
            cobranca.setDataPagamento(null);
            cobranca.setFormaPagamento(null);
            cobranca.setStatus("pendente");

            dao.save(cobranca);

            System.out.println("Cobrança salva: " + cobranca);
        }
    }
}
