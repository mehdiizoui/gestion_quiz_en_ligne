package org.upf.gestion_quiz.gestion_quiz_enligne.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.upf.gestion_quiz.gestion_quiz_enligne.Bean.BeanTest;
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
		
		// TODO Auto-generated method stub
		BeanTest beanTest = new BeanTest() ;
		TestDAO  testDAO  = new TestDAO() ;
		
		beanTest.setTypes(testDAO.getAllType());
		
		HttpSession session = request.getSession();
		session.setAttribute("beanTest",beanTest);
		
		response.sendRedirect(request.getContextPath() + "/WebLayer/DemarerTest.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
