package org.upf.gestion_quiz.gestion_quiz_enligne.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Testq;
import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Typeq;
import org.upf.gestion_quiz.gestion_quiz_enligne.interf.IntGlobale;

public class TestDAO implements IntGlobale<Testq>  {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion_quiz_enligne");
	EntityManager em 		 = emf.createEntityManager();
	EntityTransaction tx     = em.getTransaction();

	@Override
	public boolean Ajouter(Testq obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Testq FindById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Testq> FindAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Typeq> getAllType(){
		
		Query query = em.createQuery("SELECT t FROM Typeq t");
		List<Typeq> types = query.getResultList();
		
		return types;
	}

}
