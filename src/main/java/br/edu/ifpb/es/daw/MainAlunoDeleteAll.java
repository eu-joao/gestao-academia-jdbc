package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AlunoDAO;
import br.edu.ifpb.es.daw.dao.impl.AlunoDAOImpl;
import br.edu.ifpb.es.daw.entities.Aluno;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainAlunoDeleteAll {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            AlunoDAO dao = new AlunoDAOImpl(emf);

            List<Aluno> alunos = dao.getAll();
            for (Aluno aluno : alunos) {
                dao.delete(aluno.getId());
                System.out.println("Deletado: " + aluno);
            }
            System.out.println("Todos os alunos deletados.");
        }
    }
}