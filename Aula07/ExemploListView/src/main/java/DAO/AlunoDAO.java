package DAO;

import Model.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    
    public List<Aluno> carregarDados() {
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("Isabella Moraes"));
        alunos.add(new Aluno("Marina Pereira"));
        alunos.add(new Aluno("Bruno Costa"));
        alunos.add(new Aluno("Felipe Alves"));

        return alunos;
    }
}
