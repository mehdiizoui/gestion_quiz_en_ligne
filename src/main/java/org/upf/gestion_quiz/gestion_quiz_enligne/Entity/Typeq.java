package org.upf.gestion_quiz.gestion_quiz_enligne.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typeq database table.
 * 
 */
@Entity
@NamedQuery(name="Typeq.findAll", query="SELECT t FROM Typeq t")
public class Typeq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_typeq")
	private String idTypeq;

	private String description;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="typeqBean")
	private List<Question> questions;

	//bi-directional many-to-one association to Testq
	@OneToMany(mappedBy="typeq")
	private List<Testq> testqs;

	public Typeq() {
	}

	public String getIdTypeq() {
		return this.idTypeq;
	}

	public void setIdTypeq(String idTypeq) {
		this.idTypeq = idTypeq;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestions().add(question);
		question.setTypeqBean(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setTypeqBean(null);

		return question;
	}

	public List<Testq> getTestqs() {
		return this.testqs;
	}

	public void setTestqs(List<Testq> testqs) {
		this.testqs = testqs;
	}

	public Testq addTestq(Testq testq) {
		getTestqs().add(testq);
		testq.setTypeq(this);

		return testq;
	}

	public Testq removeTestq(Testq testq) {
		getTestqs().remove(testq);
		testq.setTypeq(null);

		return testq;
	}

}