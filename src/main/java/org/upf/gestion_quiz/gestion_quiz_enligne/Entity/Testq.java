package org.upf.gestion_quiz.gestion_quiz_enligne.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the testq database table.
 * 
 */
@Entity
@NamedQuery(name="Testq.findAll", query="SELECT t FROM Testq t")
public class Testq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTest;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	//bi-directional many-to-one association to Reponse
	@OneToMany(mappedBy="testq")
	private List<Reponse> reponses;

	//bi-directional many-to-one association to Candidat
	@ManyToOne
	@JoinColumn(name="id_Candidat")
	private Candidat candidat;

	//bi-directional many-to-one association to Typeq
	@ManyToOne
	@JoinColumn(name="id_typeq")
	private Typeq typeq;

	public Testq() {
	}

	public int getIdTest() {
		return this.idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Reponse> getReponses() {
		return this.reponses;
	}

	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

	public Reponse addRepons(Reponse repons) {
		getReponses().add(repons);
		repons.setTestq(this);

		return repons;
	}

	public Reponse removeRepons(Reponse repons) {
		getReponses().remove(repons);
		repons.setTestq(null);

		return repons;
	}

	public Candidat getCandidat() {
		return this.candidat;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}

	public Typeq getTypeq() {
		return this.typeq;
	}

	public void setTypeq(Typeq typeq) {
		this.typeq = typeq;
	}

	@Override
	public String toString() {
		return "Testq [idTest=" + idTest + ", date=" + date + ", candidat=" + candidat + ", typeq=" + typeq + "]";
	}

	
}