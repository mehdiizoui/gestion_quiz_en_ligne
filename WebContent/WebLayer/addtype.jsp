<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.Bean.TypeqBean"%>
<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Typeq"%>



    <%	
	TypeqBean bean ;%>
	<%if(session.getAttribute("bean") == null){
		bean = new TypeqBean();
	}
	else{
		bean = (TypeqBean) session.getAttribute("bean");
	}
	%>
    
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script src="https://kit.fontawesome.com/2da0a9a74b.js" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">ADMINISTRATION</a>
  
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link " href="http://localhost:8083/gestion_quiz_enligne/questionController"><i class="fas fa-question-circle"></i> Gestion Question</a>
      <a class="nav-item nav-link active" href="http://localhost:8083/gestion_quiz_enligne/TypeControler"><i class="fas fa-align-left"></i> Gestion Type</a>
    </div>
    
  </div>
    <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
    <div class="navbar-nav">
	    <form action="/gestion_quiz_enligne/ServletAuthentification" name="omar" method="post" >
	      <button type="submit" class="btn btn-outline-danger"><i class="fas fa-sign-out-alt"></i> Se Deconnecter</button>
	     </form>
    </div>
  </div>
</nav>

<main>
		
                        <div class="row">
                        <center>
                          <div class="col-md-4">
                          <!-- Name input -->
                            <div class="form-outline"> <br>
                            <i class="fas fa-user"></i><b>&ensp;&ensp; Admin</b> 
                            </div>
                          </div>
                        </center>
                        </div>
                        
                        <hr /><br/><br/><br/><br/><br/><br/><br/>
		<div class="position-relative">
<div class="position-absolute top-0 start-50 translate-middle">
		<form method='post' action='/gestion_quiz_enligne/TypeControler'>
		<div class="row">
		 <div class="input-group">
		
		<label class="form-label" for="form8Example1"><i class="fas fa-signature" class="fal fa-map-marker-question"></i> Type </label>
		     &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp; <input type="text" id="0" name ="id" class="form-control" required/>
		      
		        </div>  
		      </div>  
		      <br/>     
               
		      <div class="row">
		 <div class="input-group">
		
		<label class="form-label" for="form8Example1"><i class="fas fa-signature" class="fal fa-map-marker-question"></i> Description </label>
		   &ensp;&ensp;   <input type="text" id="0" name ="description" class="form-control" required/>
		      
		        </div>  
		      </div>     
  <br/><br/>
      <div class="modal-footer">
                        <button type="button" class="btn btn-danger rounded-pill" data-bs-dismiss="modal"><i class="far fa-times-circle"></i> Abandoner</button>
                        <button type="submit" class="btn btn-success rounded-pill" data-confirm="modal"><i class="fas fa-check-circle"></i> Mettre</button>
                      </div>
                 
                       </form>
                 
              
        
           </div>
           </div>
          
          <br/><br/><br/><br/><br/>
          <table class="table table-dark table-hover table-bordered">
					  <thead>
					    <tr>
					      <th scope="col" style="width:22%"> Id Type </th>
					     
					      <th scope="col"> Description </th>
					      
	
					      
					    </tr>
					  </thead>
					  <tbody>
					 
	       <%
			for (Typeq T : bean.getTypes() )
			
			{
		
		%>
        

<tr>
	
  <td class="table-primary">  <%=  T.getIdTypeq()%>    </td>
  <td class="table-secondary"><%= T.getDescription() %></td>
 
 
</tr>


	<%
			}
		%>

					  </tbody>
					</table>
          
          
          
<%= bean.getTypes().size() %> 

</main>
</body>
</html>