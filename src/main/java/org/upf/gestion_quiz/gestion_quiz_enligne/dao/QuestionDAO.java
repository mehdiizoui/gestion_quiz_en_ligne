package org.upf.gestion_quiz.gestion_quiz_enligne.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Question;
import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Typeq;
import org.upf.gestion_quiz.gestion_quiz_enligne.interf.IntGlobale;

public class QuestionDAO implements IntGlobale<Question> {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("gestion_quiz_enligne");
	EntityManager em=emf.createEntityManager();
	EntityTransaction tx=em.getTransaction();

	@Override
	public boolean Ajouter(Question obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Question FindById(int id) {
		// TODO Auto-generated method stub
		Question c = em.find(Question.class, id);
		return c;
	}

	@Override
	public List<Question> FindAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Question> FindAllWithType(String typeq){
		Query query = em.createNativeQuery("SELECT * FROM question where typeq = '"+typeq+"'", Question.class);
		List<Question> lst = query.getResultList();
		return lst;
	}
	
	public Question Recherche_QuestionById (int id)
	{
 	
		
 	return em.find(Question.class, id);
	} 
 
	
	
 
 public void Add_Question(Question Qsn )
 {
	 
	 tx.begin();
	 em.persist(Qsn);
	 tx.commit();
	 }
 
 public void Update_Question(Question Qsn) {
	
	 tx.begin();
		em.merge(Qsn);
		tx.commit();
	 
	 }
 
 public void Delete_Question(int id ) {
	 
	 Question Q = new Question() ;
	 em.remove(Q);
	 

 }
 
 public List<Question> findall(){
	 Query query = em.createQuery("SELECT q FROM Question q");
	 List<Question> lst = query.getResultList();
	 return lst;
 }
 
 
 public List<Typeq> getAllType(){
		
		Query query = em.createQuery("SELECT t FROM Typeq t");
		List<Typeq> types = query.getResultList();
		
		return types;
	}


}
