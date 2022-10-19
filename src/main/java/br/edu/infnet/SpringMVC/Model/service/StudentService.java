package br.edu.infnet.SpringMVC.Model.service;

import br.edu.infnet.SpringMVC.Model.Domain.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> alunos = new ArrayList();
    
    public StudentService() {
        alunos.add(new Student(0, "Bernardo", "21929292929"));
        alunos.add(new Student(1, "Breno", "21944292929"));
        alunos.add(new Student(2, "Raquel", "21929293329"));
        alunos.add(new Student(3, "Renatoo", "21929292229"));
    }
    
    public List<Student> consultarAlunos() {
        return alunos;
    }
    
    public Student consultarAluno(int id) {
        
        for (Student aluno : alunos) {
            if (aluno.getId() == id) {
                return aluno;
            }
        }
        return null;
    }
    
    public void incluirAluno(Student aluno) {
        
        aluno.setId(alunos.size());
        alunos.add(aluno);
    }
    
    public void alterarAluno(Student aluno) {
        
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getId() == aluno.getId()) {
                alunos.set(i, aluno);
            }
        }
    }
    
    public void excluirAluno(int id) {
        
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getId() == id) {
                alunos.remove(i);
            }
        }
    }
    
    public List<Student> procurarAlunos (String keyword){
    
        List<Student> lista  = new ArrayList<>();
        
        for (Student aluno : alunos){
        
            if(aluno.getNome().contains(keyword)){lista.add(aluno);}
        }
        return lista;
    }
    
}
