package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.impl.AlunoDAOImpl;
import br.edu.ifpb.es.daw.entities.Aluno;
import br.edu.ifpb.es.daw.util.EMFUtil;
import jakarta.persistence.EntityManagerFactory;

public class MainAlunoSave {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = EMFUtil.build()) {

            AlunoDAOImpl dao = new AlunoDAOImpl(emf);

            Aluno aluno = new Aluno();
            aluno.setNome("João Silva");
            // CPF, telefone e email únicos a cada execução
            aluno.setCpf("" + System.nanoTime());
            aluno.setTelefone("" + System.nanoTime());
            aluno.setEmail(System.nanoTime() + "@email.com");
            aluno.setStatus(true); // ativo

            dao.save(aluno);

            System.out.println("Aluno salvo: " + aluno);
        }
    }
}
