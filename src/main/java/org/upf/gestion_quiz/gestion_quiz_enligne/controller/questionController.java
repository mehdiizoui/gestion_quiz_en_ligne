package org.upf.gestion_quiz.gestion_quiz_enligne.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.upf.gestion_quiz.gestion_quiz_enligne.Bean.questionBean;


import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Question;
import org.upf.gestion_quiz.gestion_quiz_enligne.dao.QuestionDAO;




/**
 * Servlet implementation class questionController
 */
@WebServlet("/questionController")
public class questionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public questionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		questionBean bean =new questionBean();
		QuestionDAO dao = new QuestionDAO();
		HttpSession session = request.getSession();
		session.setAttribute("bean", bean);
		bean.setTypes(dao.getAllType());
		bean.setListeQuiz(dao.findall());
		
		
		
		
		
		
		
		
		
		String vue ="/WebLayer/Question.jsp";
		
		response.sendRedirect(request.getContextPath() + vue);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String vue = null;
		HttpSession session = request.getSession();
		
		

		
		String question=request.getParameter("question");
		questionBean bean =new questionBean();
		QuestionDAO dao = new QuestionDAO();
		boolean res = false;
		
		List<Question> lst = dao.findall();
		for (Question question2 : lst) {
			if(question2.getQuestion().equals(question)) {
				res = true;
			}
		}
		
		
	
			
	
			
			if(res==false){

				//Question Q = new Question();
				org.upf.gestion_quiz.gestion_quiz_enligne.dao.TypeDao dao2 = new org.upf.gestion_quiz.gestion_quiz_enligne.dao.TypeDao();
				
				String questione = request.getParameter("question");
				String choix1 = request.getParameter("choix1");
				String choix2 = request.getParameter("choix2");
				String choix3 = request.getParameter("choix3");
				String choix4 = request.getParameter("choix4");
				String correct ="";
				if(request.getParameter("Ch1")!=null) {
					correct+=""+request.getParameter("Ch1");
				}
				
				if(request.getParameter("Ch2")!=null) {
					correct+=""+request.getParameter("Ch2");
				}
				
				if(request.getParameter("Ch3")!=null) {
					correct+=""+request.getParameter("Ch3");
				}
				
				if(request.getParameter("Ch4")!=null) {
					correct+=""+request.getParameter("Ch4");
				
				}
				String typeq = request.getParameter("type"); 
				
				
				Question Qattarik = new Question(choix1, choix2, choix3, choix4,Integer.parseInt(correct), questione, dao2.Recherche_TypeById(typeq));
				dao.Add_Question(Qattarik);
				
				
				session = request.getSession();
				
				session.setAttribute("lst", dao.findall());
				session.setAttribute("er", "");
				vue ="/WebLayer/Question.jsp";
			}
			if(res==true) {
				
				session = request.getSession();
				session.setAttribute("er", "er");
				vue ="/WebLayer/Question.jsp";
			}
				
		//response.sendRedirect(request.getContextPath() + vue);
			doGet(request, response);
			
			
	}

}
