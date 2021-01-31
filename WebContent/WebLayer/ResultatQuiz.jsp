<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Candidat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<% 
	Candidat c =(Candidat) session.getAttribute("session"); 
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("'LE : 'EEEE d MMMM yyyy");  
	LocalDateTime now = LocalDateTime.now(); 
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Certificate</title>
<style type="text/css">
	           .cert {
				  border: 15px solid #0072c6;
				  border-right: 15px solid #0894fb;
				  border-left: 15px solid #0894fb;
				  width: 100%;
				  font-family: arial;
				  color: #383737;
				}
				
				.crt_title {
				  margin-top: 30px;
				  font-family: "Satisfy", cursive;
				  font-size: 40px;
				  letter-spacing: 1px;
				  color: #0060a9;
				}
				.crt_logo img {
				  width: 300px;
				  height: 190px;
				  margin: auto;
				  padding: 30px;
				}
				.colorGreen {
				  color: #27ae60;
				}
				.crt_user {
				  display: inline-block;
				  width: 80%;
				  padding: 5px 25px;
				  margin-bottom: 0px;
				  padding-bottom: 0px;
				  font-family: "Satisfy", cursive;
				  font-size: 40px;
				  border-bottom: 1px dashed #cecece;
				}
				
				.afterName {
				  font-weight: 100;
				  color: #383737;
				}
				.colorGrey {
				  color: grey;
				}
				.certSign {
				  width: 200px;
				}
				
				@media (max-width: 700px) {
				  .cert {
				    width: 100%;
				  }
				}
	
</style>

<script src="https://kit.fontawesome.com/2da0a9a74b.js" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


</head>
<body onload="window.print();">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#"><i class="fas fa-key"></i>&ensp;&ensp;<%=c.getNom()+" "+ c.getPrenom() %></a>
  
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <a class="nav-item nav-link " href="/gestion_quiz_enligne/ServletTest"> <i class="fas fa-binoculars"></i> Consulter Vos Tests</a>
  </div>
    <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
    <div class="navbar-nav">
	    <form action="/gestion_quiz_enligne/ServletAuthentification" name="omar" method="post" >
	      <button type="submit" class="btn btn-outline-danger"> <i class="fas fa-sign-out-alt"></i> Se Deconnecter</button>
	     </form>
    </div>
  </div>
</nav>

	 <link href="https://fonts.googleapis.com/css?family=Satisfy" rel="stylesheet">

    <table class="cert">
      <tr>
        <td align="center" class="crt_logo">
          <img src="https://dynamic.brandcrowd.com/preview/logodraft/a90f24f6-4f36-4633-9a17-9b34c90dbb28/image/large.png" alt="logo">
    
        </td>
      </tr>
      <tr>
        <td align="center">
          <h1 class="crt_title">Certificate De Type : <%=session.getAttribute("genre").toString() %>
            <h2>Ce certificat est présenté à </h2>
            <h1 class="colorGreen crt_user"><%= c.getNom()+" "+c.getPrenom() %></h1>
            <h3 class="afterName">Pour Réussir le test 
            </h3>
            <h3><%=dtf.format(now)%></h3>
        </td>
      </tr>
      <tr>
        <td align="center">
          <img src="https://fontmeme.com/permalink/210131/8305b8de2b60d640003ebbe1134d53d2.png" class="certSign" alt="sign">
          <h3>EL Habib Nfaoui ©2021 </h3>
          
        </td>
      </tr>
    </table>
</body>
</html>