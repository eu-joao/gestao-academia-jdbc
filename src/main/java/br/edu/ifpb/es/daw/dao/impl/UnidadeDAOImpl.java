package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.UnidadeDAO;
import br.edu.ifpb.es.daw.entities.Unidade;
import jakarta.persistence.EntityManagerFactory;

public class UnidadeDAOImpl extends AbstractDAOImpl<Unidade, Integer> implements UnidadeDAO {

    public UnidadeDAOImpl(EntityManagerFactory emf) {
        super(Unidade.class, emf);
    }
}