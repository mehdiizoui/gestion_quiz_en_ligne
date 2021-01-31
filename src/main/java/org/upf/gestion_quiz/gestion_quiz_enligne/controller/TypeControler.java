package org.upf.gestion_quiz.gestion_quiz_enligne.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.upf.gestion_quiz.gestion_quiz_enligne.Bean.TypeqBean;
import org.upf.gestion_quiz.gestion_quiz_enligne.Bean.questionBean;
import org.upf.gestion_quiz.gestion_quiz_enligne.dao.TypeDao;
import org.upf.gestion_quiz.gestion_quiz_enligne.dao.QuestionDAO;
import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Typeq;

/**
 * Servlet implementation class TypeControler
 */
@WebServlet("/TypeControler")
public class TypeControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Salam");

		TypeqBean bean =new TypeqBean();
		TypeDao dao = new TypeDao();
		
		HttpSession session = request.getSession();
		session.setAttribute("bean", bean);
		bean.setTypes(dao.getAll());
		
		
		String vue = "/WebLayer/addtype.jsp";
		
		
		
		response.sendRedirect(request.getContextPath() + vue);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String vue = null;
		String id =request.getParameter("id");
		String description = request.getParameter("description");
		if (id == null) {
			
			vue = "/WebLayer/addtype.jsp";
			
			}
		else {
			if(id.equals(""))
			{
				vue = "/WebLayer/erreur.jsp";
			}
			
			else if (id != null & description!= null ) {
				TypeqBean bean = new TypeqBean();
				TypeDao dao = new TypeDao();
				Typeq t1 = new Typeq();
				t1.setIdTypeq(request.getParameter("id"));
				t1.setDescription(request.getParameter("description"));
				bean.setType(t1);
				dao.addType(bean.getType());
				
				vue = "/WebLayer/addtype.jsp";	
				//HttpSession session = request.getSession();
				//session.setAttribute("bean", bean);
			}
			else {
				
				
				TypeqBean bean = new TypeqBean();
				TypeDao dao = new TypeDao();
				Typeq t1 = new Typeq();
				t1.setIdTypeq(request.getParameter("id"));
				bean.setType(t1);
				dao.deleteType(t1.getIdTypeq());
		
				vue = "/WebLayer/deletetype.jsp";	
			}
		
		
		
		
		
		
	}
		//response.sendRedirect(request.getContextPath() + vue);
		doGet(request, response);
		}}


