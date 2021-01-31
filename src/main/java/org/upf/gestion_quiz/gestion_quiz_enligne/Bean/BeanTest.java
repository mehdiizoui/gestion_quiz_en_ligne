package org.upf.gestion_quiz.gestion_quiz_enligne.Bean;

import java.util.ArrayList;
import java.util.List;

import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Testq;
import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Typeq;

public class BeanTest {
	
	List<Typeq> types = new ArrayList<Typeq>();
	List<Testq> tests = new ArrayList<Testq>();
	
	public List<Testq> getTests() {
		return tests;
	}

	public void setTests(List<Testq> tests) {
		this.tests = tests;
	}

	public BeanTest() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Typeq> getTypes() {
		return types;
	}

	public void setTypes(List<Typeq> types) {
		this.types = types;
	}

}
