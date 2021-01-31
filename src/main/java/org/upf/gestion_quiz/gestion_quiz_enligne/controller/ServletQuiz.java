package org.upf.gestion_quiz.gestion_quiz_enligne.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.upf.gestion_quiz.gestion_quiz_enligne.Bean.BeanQuestion;
import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Candidat;
import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Question;
import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Reponse;
import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.ReponsePK;
import org.upf.gestion_quiz.gestion_quiz_enligne.dao.QuestionDAO;
import org.upf.gestion_quiz.gestion_quiz_enligne.dao.ReponseDAO;
import org.upf.gestion_quiz.gestion_quiz_enligne.dao.TestDAO;

/**
 * Servlet implementation class ServletQuiz
 */
@WebServlet("/ServletQuiz")
public class ServletQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TestDAO tesda = new TestDAO();
	ReponseDAO repdao = new ReponseDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletQuiz() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BeanQuestion bean = new BeanQuestion();
		HttpSession session = request.getSession();
		String type = session.getAttribute("genre").toString();
		Candidat ce =(Candidat) session.getAttribute("session");
		
		System.out.println(type);
		QuestionDAO daoq = new QuestionDAO();
		List<Question> lst = daoq.FindAllWithType(type);
		
		int idtest = tesda.getIDtest(ce.getId_Candidat(), type);
		session.setAttribute("id_test", idtest);
		
		
		List<Question> lst10 =  getrandlist(lst);
		System.out.println("lst10 Taille : "+lst10.size());
		System.out.println(lst10);
		for (Question question : lst10) {
			//Reponse rs = new Reponse(new ReponsePK(idtest, question.getId_Question()), question.getCorrecte(), (byte)0, new Question());
		//	repdao.Ajouter(new Reponse(new ReponsePK(idtest, question.getId_Question()), question.getCorrecte(), (byte)0, question));
			//repdao.Ajouter(new Reponse(question.getCorrecte(), (byte)0, tesda.FindById(idtest), question));
			repdao.Ajouter_Reponse_Manuelle(idtest, question.getId_Question(), question.getCorrecte());
			System.out.println("Ajouter Avec Succes");
		}
		
		
		
		//System.out.println(idtest);
		
		bean.setLst10(lst10);
		session.setAttribute("lst10", bean);
		
		System.out.println(lst10.size());
		
		
		response.sendRedirect(request.getContextPath() + "/WebLayer/testQuiz.jsp");
		
	}
	
	public List<Question> getrandlist(List<Question> lstcomplet){
		Random rand = new Random();
		List<Question> lst10 = new ArrayList<Question>();
		lst10.clear();
		for(int i = 0 ; i <11;i++) {
			int n = rand.nextInt(lstcomplet.size());
			if(lst10.contains(lstcomplet.get(n))) {
				do {
					n = rand.nextInt(lstcomplet.size());
				} while (lst10.contains(lstcomplet.get(n))==true);
			}
			else {
				lst10.add(lstcomplet.get(n));
			}
			
		}
		if(lst10.size()<=10) {
			lst10.clear();
			for(int i = 0 ; i <11;i++) {
				int n = rand.nextInt(lstcomplet.size());
				if(lst10.contains(lstcomplet.get(n))) {
					do {
						n = rand.nextInt(lstcomplet.size());
					} while (lst10.contains(lstcomplet.get(n))==true);
				}
				else {
					lst10.add(lstcomplet.get(n));
				}
				
			}
		}
		System.out.println("Taille : "+lst10.size());
		return lst10;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Hnaya !!
		//doGet(request, response);
		String[] selectedReponse = request.getParameterValues("selected");
		System.out.println("==============================");
		/*for (String string : selectedReponse) {
			System.out.println(string);
		}*/
		
		BeanQuestion bean = new BeanQuestion();
		HttpSession session = request.getSession();
		int id_test = 0;
		bean = (BeanQuestion) session.getAttribute("lst10");
		id_test = (int) session.getAttribute("id_test");
		
		for(int i = 0 ; i<selectedReponse.length;i++) {
			if(selectedReponse[i]!=null) {
				String[] rp = selectedReponse[i].split("-");
				repdao.Modifier_Reponse_Manuelle(Integer.parseInt(rp[1]), id_test,Integer.parseInt(rp[0]));
				System.out.println("ID Question : "+rp[0]);
				System.out.println("Choix : "+rp[1]);
			}
		}
		
		repdao.Verification_Reponse(id_test);
		
		
		
		
		response.sendRedirect(request.getContextPath() + "/WebLayer/ResultatQuiz.jsp");
	}

}
