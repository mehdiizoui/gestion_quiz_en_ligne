package org.upf.gestion_quiz.gestion_quiz_enligne.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the candidat database table.
 * 
 */
@Entity
@NamedQuery(name="Candidat.findAll", query="SELECT c FROM Candidat c")
public class Candidat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_Candidat;

	private String emailC;

	private String nom;

	private String passwordC;

	private String prenom;

	//bi-directional many-to-one association to Testq
	@OneToMany(mappedBy="candidat")
	private List<Testq> testqs;

	public Candidat() {
	}
	
	

	public Candidat(String emailC, String nom, String passwordC, String prenom) {
		super();
		this.emailC = emailC;
		this.nom = nom;
		this.passwordC = passwordC;
		this.prenom = prenom;
	}



	public int getId_Candidat() {
		return this.id_Candidat;
	}

	public void setId_Candidat(int id_Candidat) {
		this.id_Candidat = id_Candidat;
	}

	public String getEmailC() {
		return this.emailC;
	}

	public void setEmailC(String emailC) {
		this.emailC = emailC;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPasswordC() {
		return this.passwordC;
	}

	public void setPasswordC(String passwordC) {
		this.passwordC = passwordC;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Testq> getTestqs() {
		return this.testqs;
	}

	public void setTestqs(List<Testq> testqs) {
		this.testqs = testqs;
	}

	public Testq addTestq(Testq testq) {
		getTestqs().add(testq);
		testq.setCandidat(this);

		return testq;
	}

	public Testq removeTestq(Testq testq) {
		getTestqs().remove(testq);
		testq.setCandidat(null);

		return testq;
	}



	@Override
	public String toString() {
		return "Candidat [id_Candidat=" + id_Candidat + ", emailC=" + emailC + ", nom=" + nom + ", passwordC="
				+ passwordC + ", prenom=" + prenom + "]";
	}
	
	

}