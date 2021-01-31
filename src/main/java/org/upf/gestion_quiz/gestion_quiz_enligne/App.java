package org.upf.gestion_quiz.gestion_quiz_enligne;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Candidat;
import org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Reponse;
import org.upf.gestion_quiz.gestion_quiz_enligne.dao.CompteDAO;
import org.upf.gestion_quiz.gestion_quiz_enligne.dao.QuestionDAO;
import org.upf.gestion_quiz.gestion_quiz_enligne.dao.ReponseDAO;
import org.upf.gestion_quiz.gestion_quiz_enligne.dao.TestDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParseException
    {
    	CompteDAO dao = new CompteDAO();
    	
        System.out.println(dao.Ajouter(new Candidat("attarikyoussef8@gmail.com", "Attarik", "Youssef98", "Youssef")));
        //dao.EnvoyerMail("attarikyoussef8@gmail.com", "demande", "salut");
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
        		+ "                  <h5 class=\"card-title\">Bienvenue Attarik Youssef</h5>\r\n"
        		+ "                  <p class=\"card-text\">Nous sommes heureux de vous compter parmi nos etudiants.<br>Vos Informations Sont : <br>Login : <b>attarikyoussef8@gmail.com</b> <br>Password : <b>Youssef98</b></p>\r\n"
        		+ "                  \r\n"
        		+ "                </div>\r\n"
        		+ "              </div>\r\n"
        		+ "              <br>\r\n"
        		+ "			</div>\r\n"
        		+ "		</div>\r\n"
        		+ "	</div>\r\n"
        		+ "</body>\r\n"
        		+ "</html>";
        //dao.alertByEmail(message,"attarikyoussef8@gmail.com","Demande");
        //System.out.println(dao.getCandidatbyEmail("attarikyoussef8@gmail.com"));
        //QuestionDAO daoq = new QuestionDAO();
        //System.out.println(daoq.FindAllWithType("INFORMATIQUE"));
        //TestDAO daots = new TestDAO();
        //System.out.println(daots.getIDtest(1, "INFORMATIQUE"));
        //System.out.println(daots.FindById(17));
        //ReponseDAO rps = new ReponseDAO();
        //rps.Ajouter_Reponse_Manuelle(28, 16, 12);
        
        
    }
}
