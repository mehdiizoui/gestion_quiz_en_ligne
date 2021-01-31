package org.upf.gestion_quiz.gestion_quiz_enligne.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the question database table.
 * 
 */
@Entity
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_Question;

	private String choix1;

	private String choix2;

	private String choix3;

	private String choix4;

	private int correcte;

	private String question;

	//bi-directional many-to-one association to Typeq
	@ManyToOne
	@JoinColumn(name="typeq")
	private Typeq typeqBean;

	//bi-directional many-to-one association to Reponse
	@OneToMany(mappedBy="question")
	private List<Reponse> reponses;

	public Question() {
	}

	
	public Question(String choix1, String choix2, String choix3, String choix4, int correcte, String question,
			Typeq typeqBean) {
		super();
		this.choix1 = choix1;
		this.choix2 = choix2;
		this.choix3 = choix3;
		this.choix4 = choix4;
		this.correcte = correcte;
		this.question = question;
		this.typeqBean = typeqBean;
	}


	public int getId_Question() {
		return this.id_Question;
	}

	public void setId_Question(int id_Question) {
		this.id_Question = id_Question;
	}

	public String getChoix1() {
		return this.choix1;
	}

	public void setChoix1(String choix1) {
		this.choix1 = choix1;
	}

	public String getChoix2() {
		return this.choix2;
	}

	public void setChoix2(String choix2) {
		this.choix2 = choix2;
	}

	public String getChoix3() {
		return this.choix3;
	}

	public void setChoix3(String choix3) {
		this.choix3 = choix3;
	}

	public String getChoix4() {
		return this.choix4;
	}

	public void setChoix4(String choix4) {
		this.choix4 = choix4;
	}

	public int getCorrecte() {
		return this.correcte;
	}

	public void setCorrecte(int correcte) {
		this.correcte = correcte;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Typeq getTypeqBean() {
		return this.typeqBean;
	}

	public void setTypeqBean(Typeq typeqBean) {
		this.typeqBean = typeqBean;
	}

	public List<Reponse> getReponses() {
		return this.reponses;
	}

	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

	public Reponse addRepons(Reponse repons) {
		getReponses().add(repons);
		repons.setQuestion(this);

		return repons;
	}

	public Reponse removeRepons(Reponse repons) {
		getReponses().remove(repons);
		repons.setQuestion(null);

		return repons;
	}

	@Override
	public String toString() {
		return "Question [id_Question=" + id_Question + ", choix1=" + choix1 + ", choix2=" + choix2 + ", choix3="
				+ choix3 + ", choix4=" + choix4 + ", correcte=" + correcte + ", question=" + question + "]";
	}
	
	

}