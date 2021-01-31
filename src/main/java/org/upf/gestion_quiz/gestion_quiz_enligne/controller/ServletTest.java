package org.upf.gestion_quiz.gestion_quiz_enligne.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.upf.gestion_quiz.gestion_quiz_enligne.Bean.BeanReponse;
import org.upf.gestion_quiz.gestion_quiz_enligne.Bean.BeanTest;
import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Candidat;
import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Reponse;
import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Testq;
import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Typeq;
import org.upf.gestion_quiz.gestion_quiz_enligne.dao.ReponseDAO;
import org.upf.gestion_quiz.gestion_quiz_enligne.dao.TestDAO;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
HttpSession session = request.getSession();
		
		//GET CURRENT CANDIDAT FROM SESSION 
		Candidat c =(Candidat) session.getAttribute("session");
		
		//TO COUNT HOW MANY TESTS 
		int cpt = 0;
		
		//BEAN TEST TO SET TYPES 
		BeanTest beanTest = new BeanTest() ;
		TestDAO  testDAO  = new TestDAO() ;
		
		//GET ALL TYPES OF TEST TO CHOOSE FROM WHEN U START A TEST
		beanTest.setTypes(testDAO.getAllType());
		
		//BEAN LIST TEST TO GET ALL THE TESTS 
		BeanTest beanListTest = new BeanTest();

		//GET THE TESTS FOR THE CURRENT USER AND COUNT HOW MANY TEST HE PASSED
		List<Testq> lst = testDAO.FindAll();
		List<Testq> listtest = new ArrayList<Testq>();
		for (Testq testq : lst) {
			if(testq.getCandidat().getId_Candidat()==c.getId_Candidat()) {
				cpt++;
				listtest.add(testq);
			}
		}
		beanListTest.setTests(listtest);
		
		//BEAN REPONSE 
		BeanReponse beanReponse = new BeanReponse();
		ReponseDAO  reponseDAO  = new ReponseDAO();
		
		//GET THE REPONSES OF CURENT CANDIDAT TESTS 
		List<Reponse> reponses = new ArrayList<Reponse>();
		for (Testq test : listtest)
		{
			reponses.addAll(reponseDAO.FindAllById(test.getIdTest()));
			
		}
		beanReponse.setReponses(reponses);
		
		
		//SET UP ALL BEANS TO THE SESSION 
		session.setAttribute("beanTest",beanTest);
		session.setAttribute("beanListTest",beanListTest);
		session.setAttribute("nbrtesteffectue",cpt);
		session.setAttribute("beanReponse",beanReponse);
		
		
		response.sendRedirect(request.getContextPath() + "/WebLayer/DemarerTest.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//TEST DAO
		TestDAO testDAO = new TestDAO();
		
		//GET TEST TYPE 
		Typeq typeTest = testDAO.findTypeById(request.getParameter("type"));
		
		//GET CANDIDAT 
		HttpSession session = request.getSession();
		Candidat c =(Candidat) session.getAttribute("session");
		
		//TEST 
		Testq test = new Testq();
		
		//SET ELEMENTS 
		test.setCandidat(c);	
		
		//SET CURRENT DATE 
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			test.setDate( new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(dtf.format(now)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.setTypeq(typeTest);
		
		//ADD TEST 
		testDAO.Ajouter(test);
		
		BeanTest beanTest = new BeanTest() ;
		beanTest.setTests(testDAO.FindAll());
		session.setAttribute("beanListTest",beanTest);
		session.setAttribute("genre",typeTest.getIdTypeq());
		//doGet(request, response);
		response.sendRedirect(request.getContextPath() + "/ServletQuiz");
		
	}

}
