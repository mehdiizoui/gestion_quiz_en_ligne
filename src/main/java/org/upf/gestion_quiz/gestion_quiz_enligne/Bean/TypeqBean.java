package org.upf.gestion_quiz.gestion_quiz_enligne.Bean;


import java.util.ArrayList;
import java.util.List;

import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Typeq;

public class TypeqBean {
	String IdTypeq ;
	Typeq type = new Typeq();
	List<Typeq> types = new ArrayList<Typeq>();
	
	
	public String getIdTypeq() {
		return IdTypeq;
	}
	public void setIdTypeq(String idTypeq) {
		IdTypeq = idTypeq;
	}
	public Typeq getType() {
		return type;
	}
	public void setType(Typeq type) {
		this.type = type;
	}
	
	
	

	public List <Typeq> getTypes() {
		return types;
	}

	public void setTypes(List<Typeq> types) {
		this.types = types;
	}	
	
	
	
	
	
	
	
	
	
	
	
	

}
