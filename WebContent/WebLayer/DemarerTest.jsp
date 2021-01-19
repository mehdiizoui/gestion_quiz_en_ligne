<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Candidat"%>
<%@page import="java.util.List"%>

<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.dao.TestDAO"%>
<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.Bean.BeanTest"%>
<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Testq"%>
<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Typeq"%>
<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.controller.ServletTest"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<%	
	BeanTest bean ;
	if(session.getAttribute("beanTest") == null){
		bean = new BeanTest();
	}
	else{
		bean = (BeanTest) session.getAttribute("beanTest");
	}
%>
<%
	Candidat c =(Candidat)session.getAttribute("session");
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title><%=c.getEmailC() %></title>

    <!-- Icons font CSS-->
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/main.css" rel="stylesheet" media="all">
</head>

<body>
    <div class="page-wrapper bg-blue p-t-130 p-b-100 font-poppins">
        <div class="wrapper wrapper--w680">
            <div class="card card-4">
                <div class="card-body">
                    <h2 class="title">Choisir Le Test A Passer</h2>
                    <form method="POST" action="/gestion_quiz_enligne/TestController">
                        <div class="input-group">
                            <label class="label">Subject</label>
                            <div class="rs-select2 js-select-simple select--no-search">
                            
                                <select name="subject">
                                    <option disabled="disabled" selected="selected">Choisir Type</option>
                                    <%
									for (Typeq t :  bean.getTypes())
									
									{
								
								    %>
                                  
                                    <option value="Subject1" > <%= t.getDescription() %> </option>
                                    <%
									}
                                    %>
                                    
                                </select>
                                
                                <div class="select-dropdown"></div>
                            </div>
                        </div>
                        <div class="p-t-15">
                            <button class="btn btn--radius-2 btn--blue" type="submit">Choisir</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="vendor/select2/select2.min.js"></script>
    <script src="vendor/datepicker/moment.min.js"></script>
    <script src="vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="js/global.js"></script>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->