<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.dao.QuestionDAO"%>
<%@page import="java.util.List"%>

<%@page import="org.apache.geronimo.mail.util.QuotedPrintableEncoderStream"%>
<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.dao.QuestionDAO"%>
<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.dao.TypeDao"%>
<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.Bean.questionBean"%>
<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Question"%>
<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Typeq"%>
<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.controller.questionController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  
    
<%	
	questionBean bean ;%>
	<%if(session.getAttribute("bean") == null){
		bean = new questionBean();
	}
	else{
		bean = (questionBean) session.getAttribute("bean");
	}
	%>



<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add_Question</title>


<script type="text/javascript">
	function  select() {
		document.omar.submit();
	}
</script>

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
      <a class="nav-item nav-link active" href="http://localhost:8083/gestion_quiz_enligne/questionController"><i class="fas fa-question-circle"></i> Gestion Question</a>
      <a class="nav-item nav-link " href="http://localhost:8083/gestion_quiz_enligne/TypeControler"> <i class="fas fa-align-left"></i> Gestion Type</a>
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

<!-- Modal -->


    
		<div class="modal fade" id="add" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" margin-right="1rem" >
  <div class="modal-dialog">
  
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"  octicon "checklist", :height = 16 ><i class="far fa-list-alt"></i>&ensp;<u>N</u>ouvelle Question </h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
       	
		<form name="mehdi" action ="/gestion_quiz_enligne/questionController" method="Post">
		
		<div class="row">
		<center>
		  <div class="col-md-4">
		  <!-- Name input -->
		    <div class="form-outline"> 
		    <i class="fas fa-user"></i><b>&ensp;&ensp; Admin</b> 
		    </div>
		  </div>
		</center>
		</div>
		
		<hr />
		

		
		
		<div class="row">
		 <div class="input-group">


		 
                            <label class="label"><i class="fas fa-signature" class="fal fa-map-marker-question"></i>Type Question&ensp;&ensp;</label>
                            <div class="rs-select2 js-select-simple select--no-search">
                            
                               <select name="type">
                                  <option name="type" disabled="disabled" selected="selected">Choose option</option>
                                 <%
									for (Typeq t :  bean.getTypes())
									
									{
								
								%>
                                  
                                    <option value="<%= t.getIdTypeq() %>" > <%= t.getDescription() %> </option>
                                <%
									}
								%>
								
                                </select>
                                
                                <div class="select-dropdown"></div>
                            </div>
                        </div>
                        <br/> <br/>
		  <div class="col">
		    <!-- Name input -->
		    <div class="form-outline">
		    <div class="col">
		    <label class="form-label" for="form8Example1"><i class="fas fa-signature" class="fal fa-map-marker-question"></i> Question </label>
		      <input type="text" id="0" name ="question" class="form-control" required/>
		      
		      </div>  
		      </div>
		      <div class="col">
		      <label class="form-label" for="form8Example1"><i class="fas fa-signature"></i> Choix 1  </label>
		      <input type="text" id="1" name ="choix1" class="form-control" required/>
		      </div>  
		      <div class="col">
		       <label class="form-label" for="form8Example1"><i class="fas fa-signature"></i> Choix 2  </label>	     
		      <input type="text" id="2" name ="choix2" class="form-control" required/>		     
		      </div>  
		      <div class="col">
		      <label class="form-label" for="form8Example1"><i class="fas fa-signature"></i> Choix 3  </label>
		      <input type="text" id="3" name ="choix3" class="form-control" required/>		           
		      </div>  
		      <div class="col">
		       <label class="form-label" for="form8Example1"><i class="fas fa-signature"></i> Choix 4  </label>
		      <input type="text" id="4" name ="choix4" class="form-control" required/>    
			  </div>  
		      <div class="col">
		    <!--    <input type="text" id="5" name ="Correcte" class="form-control" /> -->
		     <label class="form-label" for="form8Example1"><i class="fas fa-signature"></i> Les Choix Correctes &ensp; <i class="fas fa-check-circle"></i> </label> <br/>
		       <label>  Choix 1 </label><input name="Ch1" class="form-check-input" type="checkbox" value=1 id="flexCheckDefault" >&ensp;&ensp;
		    <label>  Choix 2 </label> <input name="Ch2" class="form-check-input" type="checkbox" value=2 id="flexCheckDefault">&ensp;&ensp;
		     <label>  Choix 3 </label><input name="Ch3" class="form-check-input" type="checkbox" value=3 id="flexCheckDefault">&ensp;&ensp;
		     <label>  Choix 4 </label><input name="Ch4" class="form-check-input" type="checkbox" value=4 id="flexCheckDefault">
		     
		      </div>  
		    </div>   		     
		     
		
		  
		</div>
		
		<hr />
	
		
		<div class="row">
		  <div class="col">
		   
		  </div>
		</div>
		
		
		
		
        	
        	
        	</div>
     
      <div class="modal-footer">
        <button type="button" class="btn btn-danger rounded-pill" data-bs-dismiss="modal"><i class="far fa-times-circle"></i> Abandoner</button>
        <button type="submit" class="btn btn-success rounded-pill" data-confirm="modal"><i class="fas fa-check-circle"></i> Mettre</button>
      </div>
 
       </form>
  </div>
 
</div>
 
</div>
 

<br>


	<div class="container">
		<div class="jumbotron">
			<div class="card">
			  <div class="card-header text-white text-center" style="background-color: #25383C;">
			  		<h3><u>A</u>dd Question</h3>
			  </div>
			  <div class="card-body">
			    
			    
			    <%-- Triee par Type
			    <form action="">
			    <br/> <select name="Typeq" id="Typeq" onchange="select();" class="form-select form-select-lg mb-3" required="required">
					
										
										<%
											for (Typeq t :  bean.getTypes())
											
											{
										
										%>
										
											<option value="<%= t.getIdTypeq()%>"> <%= t.getDescription() %> </option>
										<%
											}
										%>
										
									</select> --%>
					
			    	<div class="row" style="float: right;">
				    	<div class="col-md-12 ">
				    		<button class="btn btn-success rounded-pill" data-bs-toggle="modal" data-bs-target="#add"><i class="fas fa-plus-circle"></i> Nouvelle Question</button><br>
				    	</div>
				    	
				    </div>
			    	<br>
			    	<h5 class="card-title"><i class="fas fa-chevron-down"></i> Vos Questions : </h5> 
				    <table class="table table-dark table-hover table-bordered">
					  <thead>
					    <tr>
					      <th scope="col" style="width:50%"> Question</th>
					      <th scope="col"> Choix 1 </th>
					      <th scope="col"> Choix 2 </th>
					      <th scope="col"> Choix 3</th>
					      <th scope="col"> Choix 4 </th>
					      <th scope="col">Choix Correctes</th>
					      <th scope="col"> Type Question </th>
	
					      
					    </tr>
					  </thead>
					  <tbody>
					 
	       <%
			for (Question Q : bean.getListeQuiz() )
			
			{
		
		%>
        

<tr>
	
  <td class="table-primary">  <%=  Q.getQuestion()%>    </td>
  <td class="table-secondary"><%= Q.getChoix1() %></td>
  <td class="table-success"><%= Q.getChoix2() %></td>
  <td class="table-danger"><%= Q.getChoix3() %></td>
  <td class="table-warning"><%= Q.getChoix4() %></td>
  <td class="table-info"><%= Q.getCorrecte() %></td>
 
  <td class="table-light"><%=Q.getTypeqBean().getDescription() %></td>
 
</tr>


	<%
			}
		%>

					  </tbody>
					</table>
				<%= bean.getListeQuiz().size() %> 
			  </div>
			</div>
		</div>
	</div>
	</main>

</body>
</html>