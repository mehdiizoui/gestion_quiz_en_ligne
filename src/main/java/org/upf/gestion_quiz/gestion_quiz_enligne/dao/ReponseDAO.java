package org.upf.gestion_quiz.gestion_quiz_enligne.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Reponse;
import org.upf.gestion_quiz.gestion_quiz_enligne.interf.IntGlobale;

public class ReponseDAO implements IntGlobale<Reponse> {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion_quiz_enligne");
	EntityManager em 		 = emf.createEntityManager();
	EntityTransaction tx     = em.getTransaction();

	@Override
	public boolean Ajouter(Reponse obj) {
		// TODO Auto-generated method stub
		tx.begin();
		em.persist(obj);
		tx.commit();
		
		return false;
	}

	@Override
	public Reponse FindById(int id) {
		// TODO Auto-generated method stub
		Query query = em.createNativeQuery("SELECT id_test , id_question , choixQ , reponseC FROM reponse WHERE id_test = '"+id+"'",Reponse.class);
		Reponse reponse = (Reponse) query.getSingleResult();
		
		return reponse;
	}

	@Override
	public List<Reponse> FindAll() {
		Query query = em.createNativeQuery("SELECT id_test , id_question , choixQ , reponseC FROM reponse",Reponse.class);
		List<Reponse> lst = new ArrayList<Reponse>(query.getResultList());
		
		return lst;
	}
	
	public void Ajouter_Reponse_Manuelle(int id_test , int id_question , int reponse_correct) {
		tx.begin();
		//INSERT INTO `reponse` (`id_test`, `id_question`, `choixQ`, `reponseC`, `valide`) VALUES ('41', '1', '12', '12', '1');
		Query query = em.createNativeQuery("INSERT into reponse (id_test, id_question, choixQ, reponseC, valide) values ('"+id_test+"','"+id_question+"',0,'"+reponse_correct+"','0')");
		query.executeUpdate();
		tx.commit();
	}
	public void Modifier_Reponse_Manuelle(int choixU  , int id_test , int id_question) {
		tx.begin();
		
			Query query = em.createNativeQuery("UPDATE `reponse` SET `choixQ`= CONCAT(choixQ,"+choixU+") WHERE id_test = "+id_test+" and id_question = "+id_question+"");
			query.executeUpdate();		
		
		tx.commit();
	}
	
	public void Verification_Reponse(int id_test) {
		tx.begin();
		Query query = em.createNativeQuery("UPDATE `reponse` SET `valide`=1 WHERE reponseC = choixQ and  id_test = "+id_test+"");
		query.executeUpdate();		
	
		tx.commit();
	}
	
	public List<Reponse> FindAllById(int id) {
		
		Query query = em.createNativeQuery("SELECT id_test , id_question , choixQ , reponseC FROM reponse WHERE id_test = '"+id+"'",Reponse.class);
		List<Reponse> reponses = new ArrayList<Reponse>(query.getResultList());
		
		return reponses;
	}

}
