package org.upf.gestion_quiz.gestion_quiz_enligne.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Candidat;
import org.upf.gestion_quiz.gestion_quiz_enligne.dao.CompteDAO;

/**
 * Servlet implementation class ServletAuthentification
 */
@WebServlet("/ServletAuthentification")
public class ServletAuthentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CompteDAO dao = new CompteDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAuthentification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String Page = (String) session.getAttribute("Page");
		System.out.println("Ani hnaya");
		
			
		
			if(Page.equals("Authentification")) {
				response.sendRedirect(request.getContextPath() + "/WebLayer/Authentification.jsp");
			}
			if(Page.equals("Restauration")) {
				response.sendRedirect(request.getContextPath() + "/WebLayer/MotsdePasseOublie.jsp");
			}
			if(Page.equals("Inscription")) {
				response.sendRedirect(request.getContextPath() + "/WebLayer/Inscription.jsp");
			}
			if(Page.equals("Accueil")) {
				response.sendRedirect(request.getContextPath() + "/ServletTest");
			}
			if(Page.equals("Admin")) {
				response.sendRedirect(request.getContextPath() + "/questionController");
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String page = (String) session.getAttribute("Page");
		
		if(session.getAttribute("session")!=null) {
			session.setAttribute("session", null);
			response.sendRedirect(request.getContextPath() + "/WebLayer/Authentification.jsp");
			
		}
		else {
			
		
		if(page.equals("Authentification")) {
			String email= request.getParameter("login");
			String password = request.getParameter("password");
			if(dao.SeConnecter(email, password)) {
				System.out.println("Succes");
				session.setAttribute("Page", "Accueil");
				if(email.equals("admin@gmail.com")) {
					session.setAttribute("Page", "Admin");
				}
				//hnaya !!
				session.setAttribute("session", dao.getCandidatbyEmail(email));
				session.setAttribute("er", "");
			}
			else {
				System.out.println("Error");
				session.setAttribute("Page", "Authentification");
				session.setAttribute("er", "er");
			}
			response.sendRedirect(request.getContextPath() + "/ServletAuthentification");
		}
		if(page.equals("Restauration")) {
			String email= request.getParameter("login");
			if(dao.restaureCode(email)) {
				session.setAttribute("erres", "su");
				session.setAttribute("er", "");
				session.setAttribute("Page", "Restauration");
				response.sendRedirect(request.getContextPath() + "/ServletAuthentification");
			}
			else {
				session.setAttribute("erres", "er");
				session.setAttribute("Page", "Restauration");
				response.sendRedirect(request.getContextPath() + "/ServletAuthentification");
			}
		}
		if(page.equals("Inscription")) {
			//
				Random rnd = new Random();
			    int number = rnd.nextInt(999999);
			//
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email= request.getParameter("login");
			String pass = nom+""+String.format("%06d", number);
			if(dao.Ajouter(new Candidat(email, nom, pass, prenom))) {
				session.setAttribute("erins", "su");
				session.setAttribute("Page", "Inscription");
				response.sendRedirect(request.getContextPath() + "/ServletAuthentification");
			}
			else {
				session.setAttribute("erins", "er");
				session.setAttribute("Page", "Inscription");
				response.sendRedirect(request.getContextPath() + "/ServletAuthentification");
			}
			//session.setAttribute("Page", "Inscription");
			//response.sendRedirect(request.getContextPath() + "/ServletAuthentification");
		}
		}
		
	}

}
