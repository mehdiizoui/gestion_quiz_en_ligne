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
		tx.begin();
		em.persist(obj);
		tx.commit();
		
		return true;
	}

	@Override
	public Testq FindById(int id) {
		// TODO Auto-generated method stub
		//Query query = em.createQuery("SELECT t FROM Testq t WHERE t.idTest ="+id);
		//Testq test = (Testq) query.getResultList();
		
		Testq tq = em.find(Testq.class, id);
		return tq;
	}
	
	public int getIDtest(int id_candidat , String genre) {
		Query query = em.createNativeQuery("SELECT max(idTest) from testq where id_Candidat="+id_candidat+" and id_typeq = '"+genre+"'");
		int res = (int) query.getSingleResult();
		return res;
	}

	@Override
	public List<Testq> FindAll() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT t FROM Testq t");
		List<Testq> tests = query.getResultList();
		
		return tests;
	}
	
	public List<Typeq> getAllType(){
		
		Query query = em.createQuery("SELECT t FROM Typeq t");
		List<Typeq> types = query.getResultList();
		
		return types;
	}
	
	public Typeq findTypeById (String  id)
	{
		Query query = em.createQuery("SELECT t FROM Typeq t WHERE t.idTypeq ='"+id+"'");
		Typeq type = (Typeq) query.getSingleResult();
		
		return type;
	}
	
	public List<Testq> FindAllByCandidatId(int id) {
		
		Query query = em.createQuery("SELECT t FROM Testq t WHERE t.id_Candidat = "+id);
		List<Testq> tests = query.getResultList();
		
		return tests;
	}
	

	

}
