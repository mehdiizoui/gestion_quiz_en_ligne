package org.upf.gestion_quiz.gestion_quiz_enligne.Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reponse database table.
 * 
 */
@Entity
@NamedQuery(name="Reponse.findAll", query="SELECT r FROM Reponse r")
public class Reponse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReponsePK id;

	private int choixQ;

	private int reponseC;

	private byte valide;

	//bi-directional many-to-one association to Testq
	@ManyToOne
	@JoinColumn(name="id_test")
	private Testq testq;

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="id_question")
	private Question question;

	public Reponse() {
	}
	
	

	



	







	public Reponse(int reponseC, byte valide, Testq testq, Question question) {
		super();
		this.reponseC = reponseC;
		this.valide = valide;
		this.testq = testq;
		this.question = question;
	}















	public ReponsePK getId() {
		return this.id;
	}

	public void setId(ReponsePK id) {
		this.id = id;
	}

	public int getChoixQ() {
		return this.choixQ;
	}

	public void setChoixQ(int choixQ) {
		this.choixQ = choixQ;
	}

	public int getReponseC() {
		return this.reponseC;
	}

	public void setReponseC(int reponseC) {
		this.reponseC = reponseC;
	}

	public byte getValide() {
		return this.valide;
	}

	public void setValide(byte valide) {
		this.valide = valide;
	}

	public Testq getTestq() {
		return this.testq;
	}

	public void setTestq(Testq testq) {
		this.testq = testq;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}