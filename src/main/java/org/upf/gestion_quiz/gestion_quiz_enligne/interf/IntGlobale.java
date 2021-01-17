package org.upf.gestion_quiz.gestion_quiz_enligne.interf;

import java.util.ArrayList;
import java.util.List;

public interface IntGlobale<T> {
	public boolean Ajouter(T obj);
	public T FindById(int id);
	public List<T> FindAll();
}
