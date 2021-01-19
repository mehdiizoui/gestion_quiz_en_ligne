package org.upf.gestion_quiz.gestion_quiz_enligne.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Candidat;
import org.upf.gestion_quiz.gestion_quiz_enligne.interf.IntGlobale;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class CompteDAO implements IntGlobale<Candidat>{
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion_quiz_enligne");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();

	@Override
	public boolean Ajouter(Candidat obj) {
		boolean res = false;
		List<Candidat> lst = FindAll();
		for (Candidat candidat : lst) {
			if((candidat.getNom().equals(obj.getNom())&&candidat.getPrenom().equals(obj.getPrenom()))||candidat.getEmailC().equals(obj.getEmailC())) {
				res = true;
			}
		}
		if(res == true) {
			res = false;
		}
		else {
			tx.begin();
			try {
				em.persist(obj);
				tx.commit();
				res = true;
				String message = "<!DOCTYPE html>\r\n"
						+ "<html lang=\"en\">\r\n"
						+ "<head>\r\n"
						+ "    <meta charset=\"UTF-8\">\r\n"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
						+ "    <title>Document</title>\r\n"
						+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1\" crossorigin=\"anonymous\">\r\n"
						+ "    <script src=\"https://kit.fontawesome.com/2da0a9a74b.js\" crossorigin=\"anonymous\"></script>\r\n"
						+ "    <style>\r\n"
						+ "        .card {\r\n"
						+ "            margin: 0 auto; /* Added */\r\n"
						+ "            float: none; /* Added */\r\n"
						+ "            margin-bottom: 10px; /* Added */\r\n"
						+ "        }\r\n"
						+ "    </style>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "    <br>\r\n"
						+ "    	<div class=\"container\">\r\n"
						+ "		<div class=\"jumbotron \">\r\n"
						+ "			<div class=\"card\">\r\n"
						+ "			  <div class=\"card-header text-warning text-center\" style=\"background-color: #68A7FD;\">\r\n"
						+ "			  		<h3><u>M</u>ail de Verification</h3>\r\n"
						+ "              </div>\r\n"
						+ "              <br>\r\n"
						+ "			  <div class=\"card\" style=\"width: 18rem;\">\r\n"
						+ "                <img src=\"https://dynamic.brandcrowd.com/preview/logodraft/a90f24f6-4f36-4633-9a17-9b34c90dbb28/image/large.png\" class=\"card-img-top\" alt=\"...\">\r\n"
						+ "                <div class=\"card-body\">\r\n"
						+ "                  <h5 class=\"card-title\">Bienvenue "+obj.getNom()+" "+obj.getPrenom()+"</h5>\r\n"
						+ "                  <p class=\"card-text\">Nous sommes heureux de vous compter parmi nos etudiants.<br>Vos Informations Sont : <br>Login : <b>"+obj.getEmailC()+"</b> <br>Password: <b>"+obj.getPasswordC()+"</b></p>\r\n"
						+ "                  \r\n"
						+ "                </div>\r\n"
						+ "              </div>\r\n"
						+ "              <br>\r\n"
						+ "			</div>\r\n"
						+ "		</div>\r\n"
						+ "	</div>\r\n"
						+ "</body>\r\n"
						+ "</html>";
				alertByEmail(message, obj.getEmailC(), "Verfication de Votre Nouveau Compte");
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return res;
	}

	@Override
	public Candidat FindById(int id) {
		// TODO Auto-generated method stub
		Candidat c = em.find(Candidat.class, id);
		return null;
	}

	@Override
	public List<Candidat> FindAll() {
		Query query = em.createQuery("SELECT c FROM Candidat c");
		List<Candidat> lst = query.getResultList();
		return lst;
	}
	
	public boolean SeConnecter(String Email,String Password) {
		boolean res = false;
		List<Candidat> lst = FindAll();
		for (Candidat candidat : lst) {
			if(candidat.getEmailC().equals(Email)&&candidat.getPasswordC().equals(Password))
			{
				res = true;
			}
		}
		return res;
	}
	
	public Candidat getCandidatbyEmail(String Email) {
		Candidat c ;
		Query query = em.createQuery("SELECT c FROM Candidat c where c.emailC = :femail");
		query.setParameter("femail", Email);
		query.setMaxResults(1);
		List<Candidat> lst =  (List<Candidat>) query.getResultList();
		c = lst.get(0);
		return c;
	}
	
	public boolean restaureCode(String Email) {
		boolean res = false;
		List<Candidat> lst = FindAll();
		for (Candidat candidat : lst) {
			if(candidat.getEmailC().equals(Email)){
				res = true;
				Candidat c = FindById(candidat.getId_Candidat());
				 String message ="<!DOCTYPE html>\r\n"
			        		+ "<html lang=\"en\">\r\n"
			        		+ "<head>\r\n"
			        		+ "    <meta charset=\"UTF-8\">\r\n"
			        		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
			        		+ "    <title>Document</title>\r\n"
			        		+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1\" crossorigin=\"anonymous\">\r\n"
			        		+ "    <script src=\"https://kit.fontawesome.com/2da0a9a74b.js\" crossorigin=\"anonymous\"></script>\r\n"
			        		+ "    <style>\r\n"
			        		+ "        .card {\r\n"
			        		+ "            margin: 0 auto; /* Added */\r\n"
			        		+ "            float: none; /* Added */\r\n"
			        		+ "            margin-bottom: 10px; /* Added */\r\n"
			        		+ "        }\r\n"
			        		+ "    </style>\r\n"
			        		+ "</head>\r\n"
			        		+ "<body>\r\n"
			        		+ "    <br>\r\n"
			        		+ "    	<div class=\"container\">\r\n"
			        		+ "		<div class=\"jumbotron \">\r\n"
			        		+ "			<div class=\"card\">\r\n"
			        		+ "			  <div class=\"card-header text-warning text-center\" style=\"background-color: #68A7FD;\">\r\n"
			        		+ "			  		<h3><u>M</u>ail de Verification</h3>\r\n"
			        		+ "              </div>\r\n"
			        		+ "              <br>\r\n"
			        		+ "			  <div class=\"card\" style=\"width: 18rem;\">\r\n"
			        		+ "                <img src=\"https://dynamic.brandcrowd.com/preview/logodraft/a90f24f6-4f36-4633-9a17-9b34c90dbb28/image/large.png\" class=\"card-img-top\" alt=\"...\">\r\n"
			        		+ "                <div class=\"card-body\">\r\n"
			        		+ "                  <h5 class=\"card-title\">Restauration du Compte</h5>\r\n"
			        		+ "                  <p class=\"card-text\">Nous sommes heureux de Restaurer Votre Compte.<br>Vos Informations Sont : <br>Login : <b>"+candidat.getEmailC()+"</b> <br>Password : <b>"+candidat.getPasswordC()+"</b></p>\r\n"
			        		+ "                  \r\n"
			        		+ "                </div>\r\n"
			        		+ "              </div>\r\n"
			        		+ "              <br>\r\n"
			        		+ "			</div>\r\n"
			        		+ "		</div>\r\n"
			        		+ "	</div>\r\n"
			        		+ "</body>\r\n"
			        		+ "</html>";
				 alertByEmail(message, candidat.getEmailC(), "Restauration du Compte");
			}
		}
		return res;
	}
	
	public String  alertByEmail(String emailMessage,String to,String sujet){
        try{
                     
            final String fromEmail = "mail.transfer.ginfo4@gmail.com";
            final String password = "1996_1996"; //fromEmail password 
            final String toEmail = to;
            System.out.println("Email configuration code start");
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host set by default this
            props.put("mail.smtp.port", "587"); //TLS Port you can use 465 insted of 587
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
            //create Authenticator object to pass in Session.getInstance argument
            Authenticator auth = new Authenticator() 
            {
            
                protected PasswordAuthentication getPasswordAuthentication() 
                {
                        return new PasswordAuthentication(fromEmail, password);
                }
            };
                        Session session = Session.getInstance(props, auth);
            
                        MimeMessage message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(fromEmail));
                        message.addRecipient(Message.RecipientType.TO, new 
                                                              InternetAddress(toEmail));
                        message.setSubject(sujet);
                        message.setContent(emailMessage,"text/html");
                        //message.setText(emailMessage);//here you can write a msg what you want to send... just remove String parameter in alertByEmail method oherwise call parameter
                        System.out.println("text:"+emailMessage);
                        Transport.send(message);//here mail sending process start.
                        System.out.println("Mail Sent Successfully");
        }
        catch(Exception ex)
        {
                        System.out.println("Mail fail");
                        System.out.println(ex);
        }
        return emailMessage;
        
        }
}
