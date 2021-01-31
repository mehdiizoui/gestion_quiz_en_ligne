package org.upf.gestion_quiz.gestion_quiz_enligne.Bean;

import java.util.ArrayList;
import java.util.List;

import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Reponse;

public class BeanReponse {

	List<Reponse> reponses = new ArrayList<Reponse>();
	
	public BeanReponse() {
		// TODO Auto-generated constructor stub
	}

	public List<Reponse> getReponses() {
		return reponses;
	}

	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

	
}
