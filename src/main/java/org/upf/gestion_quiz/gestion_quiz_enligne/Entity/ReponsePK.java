package org.upf.gestion_quiz.gestion_quiz_enligne.Entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the reponse database table.
 * 
 */
@Embeddable
public class ReponsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_test", insertable=false, updatable=false)
	private int idTest;

	@Column(name="id_question", insertable=false, updatable=false)
	private int idQuestion;

	public ReponsePK() {
	}
	
	
	public ReponsePK(int idTest, int idQuestion) {
		super();
		this.idTest = idTest;
		this.idQuestion = idQuestion;
	}


	public int getIdTest() {
		return this.idTest;
	}
	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}
	public int getIdQuestion() {
		return this.idQuestion;
	}
	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ReponsePK)) {
			return false;
		}
		ReponsePK castOther = (ReponsePK)other;
		return 
			(this.idTest == castOther.idTest)
			&& (this.idQuestion == castOther.idQuestion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idTest;
		hash = hash * prime + this.idQuestion;
		
		return hash;
	}
}