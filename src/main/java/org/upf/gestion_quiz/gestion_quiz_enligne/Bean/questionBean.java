package org.upf.gestion_quiz.gestion_quiz_enligne.Bean;

import java.util.ArrayList;
import java.util.List;

import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Question;
import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Typeq;

public class questionBean {
		int idQ= 0;
		Question Q = new Question();
		
		List<Typeq> types = new ArrayList<Typeq>();
	


		public int getIdQ() {
			return idQ;
		}


		public void setIdQ(int idQ) {
			this.idQ = idQ;
		}


		

		public Question getQ() {
			return Q;
		}


		public void setQ(Question q) {
			Q = q;
		}


		List<Question> Questions = new ArrayList<Question>();
		
		public List<Question> getListeQuiz() {
			return Questions;
		}
		
		
		public void setListeQuiz(List<Question> listeQ) {
			this.Questions = listeQ;
		}
		
		public List<Typeq> getTypes() {
			return types;
		}

		public void setTypes(List<Typeq> types) {
			this.types = types;
		}

		

}
