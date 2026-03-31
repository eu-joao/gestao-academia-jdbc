package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AlunoDAO;
import br.edu.ifpb.es.daw.dao.impl.AlunoDAOImpl;
import br.edu.ifpb.es.daw.entities.Aluno;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class MainAlunoSave {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            AlunoDAO dao = new AlunoDAOImpl(emf);

            Aluno aluno = new Aluno();
            aluno.setNome("João Silva");
            aluno.setCpf((int) System.nanoTime()); // unique
            aluno.setTelefone((int) System.nanoTime()); // unique
            aluno.setEmail(System.nanoTime() + "@example.com"); // unique
            aluno.setStatus(true);

            dao.save(aluno);
            System.out.println("Aluno salvo: " + aluno);
        }
    }
}
