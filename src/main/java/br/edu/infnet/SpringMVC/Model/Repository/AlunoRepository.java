package br.edu.infnet.SpringMVC.Model.Repository;

import br.edu.infnet.SpringMVC.Model.Domain.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;


public class AlunoRepository {
    
    public EntityManager getEM(){
    
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Spring-MVCPU");
        return factory.createEntityManager();
    }
    
    public List<Student> consultarAlunos(){
    
        List<Student> lista = null;
        
        EntityManager em = getEM();
        CriteriaQuery criteria = em.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Student.class));
        lista = em.createQuery(criteria).getResultList();
        
        return lista;
        
    }
    
    public void incluirAluno(Student aluno){
    
        EntityManager em = getEM();
        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();
        em.close();
    }
    
    public Student consultarAluno(int id){
    
        EntityManager em = getEM();
        Student aluno = em.find(Student.class, id);
        return aluno;
    }
    
    public void alterarAluno(Student aluno){
       EntityManager em = getEM();
       em.getTransaction().begin();
       em.merge(aluno);
       em.getTransaction().commit();
       em.close();
        
    }
    
    public void excluirAluno(int id){
    
         EntityManager em = getEM();
         Student aluno = em.find(Student.class, id);
         em.getTransaction().begin();
         em.remove(aluno);
         em.getTransaction().commit();
         em.close();
         
    }
    
    
    
}
