<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>

<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Candidat"%>
<%@page import="java.util.List"%>

<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.dao.TestDAO"%>
<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.Bean.BeanTest"%>
<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Testq"%>
<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Typeq"%>
<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Reponse"%>
<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.Bean.BeanReponse"%>
<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.controller.ServletTest"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%	
	BeanReponse beanReponse  = (BeanReponse) session.getAttribute("beanReponse");

	int cpt = (int)session.getAttribute("nbrtesteffectue");
	BeanTest bean ;
	BeanTest beanListTest;

	if (session.getAttribute("beanListTest") == null) 
	{
		beanListTest = new BeanTest();
	}
	else
	{
		beanListTest = (BeanTest) session.getAttribute("beanListTest");
	}

	if( (session.getAttribute("beanTest") == null) ){
		bean 		 = new BeanTest();
		
	}
	else{
		bean 		 = (BeanTest) session.getAttribute("beanTest");

	}
%>
<%
	Candidat c =(Candidat) session.getAttribute("session");
%>

<html>

<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Demarrer Test</title>

<script src="https://kit.fontawesome.com/2da0a9a74b.js" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<style type="text/css">

	.text-small {
		font-size: 0.9rem !important;
	}
	
	.colored-modal-body  {
		background: linear-gradient(to left, #4535da, #a8e063);
	}
	
	.cursor-pointer {
		cursor: pointer;
	}

	.correcte { 
		background : springgreen;
	}

	.incorrecte {
		background : Tomato;
	}
	
	.missed {
		background : #FFF176;
	}
	
</style>

<!-- <script>
function int Correcte(name) {
    const checkboxes = document.querySelectorAll(`input[name="${name}"]:checked`);
    int values = [];
    checkboxes.forEach((checkbox) => {
        values.push(checkbox.value);
    });
    return values;
}
        </script> -->

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#"><i class="fas fa-key"></i>&ensp;&ensp; <%=c.getNom()+" "+ c.getPrenom() %></a>
  
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    
  </div>
    <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
    <div class="navbar-nav">
	    <form action="/gestion_quiz_enligne/ServletAuthentification" name="omar" method="post" >
	      <button type="submit" class="btn btn-outline-danger"> <i class="fas fa-sign-out-alt"></i> Se Deconnecter</button>
	     </form>
    </div>
  </div>
</nav>

<!-- Modal LANCER TEST-->  
<div class="modal fade" id="add" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
	  <div class="modal-content">

			<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Lancer Test </h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>

		<div class="modal-body">
						
				<form action ="/gestion_quiz_enligne/ServletTest" method="POST">		
						<div class="row">
						<center>
						<div class="col-md-6">
						<!-- Name input -->

							<div class="form-outline"> 
							<i class="fa fa-user-circle-o"></i><b> <%= c.getNom()+" "+ c.getPrenom() %></b> 
							</div>
							
						</div>
						</center>
						</div>
						
						<hr />
						
						<div class="row">
							<label class="label">Type Test : </label>
							<h6></h6>
								<div class="form-group text-center">
													
													
													<div class="rs-select2 js-select-simple select--no-search">
													
													<select name="type" class="form-select form-select-lg mb-3" required="required">

														<option value="" name="" disabled="disabled" selected="selected">Choisir Un Type</option>
														<%
															for (Typeq t :  bean.getTypes())
															
															{
														
														%>
														
															<option value="<%= t.getIdTypeq() %>"> <%= t.getDescription() %> </option>
														<%
															}
														%>
														
													</select>
														
													</div>
									</div>	
						</div>
							
							<hr/>
					
		</div>
					
		<div class="modal-footer">
			<button type="button" class="btn btn-danger rounded-pill" data-bs-dismiss="modal"><i class="far fa-times-circle"></i> Abandoner</button>
			<button type="submit" class="btn btn-success rounded-pill" data-confirm="modal"><i class="fas fa-check-circle"></i> Lancer</button>
		</div>
				
					</form>
	  </div>
				
	</div>
 
</div>
<!-- FIN Modal -->  
 

<br>

	<div class="container">
		<div class="jumbotron">
			<div class="card">
			  <div class="card-header text-white text-center" style="background-color: #25383C;">
			  		<h3>Demarrer Test</h3>
			  </div>
			  <div class="card-body">
			    <h6 class="card-title"><i class="fa fa-user-circle-o" aria-hidden="true"></i> Nom Complet : <%= c.getNom()+" "+ c.getPrenom() %><br> <i class="fa fa-at" aria-hidden="true"></i> Email : <%= c.getEmailC() %> <br><i class="fas fa-sort-numeric-down-alt"></i> Nombre De Test : <%=cpt%></h6> 
			    	<div class="row" style="float: right;">
				    	<div class="col-md-12 ">
				    		<button class="btn btn-success rounded-pill" data-bs-toggle="modal" data-bs-target="#add"><i class="fas fa-plus-circle"></i> Lancer Test</button><br>
				    	</div>
				    </div>
			    	<br>
			    	<br>
				    <table class="table table-dark table-hover table-bordered">
					  <thead>
					    <tr>
					      <th scope="col" style="width:12%"> Type Test</th>
					      <th scope="col"> Date </th>
						  <th scope="col"> Note </th>	
						  <th scope="col"> Consulter </th>				      
					    </tr>
					  </thead>
					  <tbody>
					 
		<%
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");  
		
		for (Testq test : beanListTest.getTests() )			
		{
			Integer note_Test = 0;	
		%>
        

				<tr>
					

				<td class="table-primary">  <%= test.getTypeq().getIdTypeq() %> </td>
				<td class="table-primary">  <%= dateFormat.format(test.getDate()) %></td>
				<td class="table-primary">
				
				<!-- Modal INFORMATION TEST  -->  
				<div class="modal fade" id="info<%=test.getIdTest()%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
									<div class="modal-dialog modal-dialog-scrollable modal-xl">
									<div class="modal-content">

										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabel"> Information Test </h5>
										</div>
										
										<div class="modal-body">

													<div class="row">
														<center>
														<div class="col-md-6">
														<!-- Name input -->

															<div class="form-outline"> 
															<i class="fa fa-user-circle-o"></i><b> <%= c.getNom()+" "+ c.getPrenom()%></b> 
															</div>
															
														</div>
														</center>
													</div>
														
														<hr />
														
									<% for (Reponse reponse : beanReponse.getReponses() ) {
									
										if (test.getIdTest() == reponse.getTestq().getIdTest())
										{

										
									%>
										<section>
											<div class="container">
												<div class="row">
													<div class="col-lg-7 mx-auto">
														<div class="card shadow border-0 mb-5">
															<div class="card-body p-5">
																<% 
																	
																	Integer i_reponse_correct  = (Integer) reponse.getReponseC();
																	Integer i_choix   		   = (Integer) reponse.getChoixQ();
																	
																	String reponse_correct = i_reponse_correct.toString();
																	String choix           = i_choix.toString();
																	
																	Boolean correct = i_reponse_correct.equals(i_choix);
																	
																%>
																<h6><%= reponse.getQuestion().getQuestion() +" ?" %></h6>
																
																<h6> </h6>
																
																<div style="text-align: center;">
																
																	<%
																	if (correct)  { note_Test++; %>
																			<span style="color: springgreen"> <i class="fas fa-check-circle fa-2x"></i> </span>
																	<% } else {  %>
																			<span style="color: Tomato">  <i class="fas fa-times-circle fa-2x"></i> </span>
																	<% } %>	
																	<h6> </h6>
																
																</div>
																
																<ul class="list-group">

																	<!--QUESTON 1 -->
																	<% 
																																
																	if ( reponse_correct.contains("1") && ! (choix.contains("1")) ) { %>

																	<li class="list-group-item rounded-0 missed">
																		<div class="custom-control-label">
																			<label class="cursor-pointer font-italic d-block custom-control-label" for="customCheck1"><%= reponse.getQuestion().getChoix1() %></label>
																		</div>
																	</li>
																	
																		<% } else if (reponse_correct.contains("1") && (choix.contains("1")) ) {  %>

																		<li class="list-group-item rounded-0 correcte">
																			<div class="custom-control-label">
																				<label class="cursor-pointer font-italic d-block custom-control-label" for="customCheck1"><%= reponse.getQuestion().getChoix1() %></label>
																			</div>
																		</li>
																			

																	<% } else if ( !(reponse_correct.contains("1")) && choix.contains("1")) {  %>

																		<li class="list-group-item rounded-0 incorrecte">
																			<div class="custom-control-label">
																				<label class="cursor-pointer font-italic d-block custom-control-label" for="customCheck1"><%= reponse.getQuestion().getChoix1() %></label>
																			</div>
																		</li>
																	
																	<% } else { %>
																	
																	<li class="list-group-item rounded-0">
																			<div class="custom-control-label">
																				<label class="cursor-pointer font-italic d-block custom-control-label" for="customCheck1"><%= reponse.getQuestion().getChoix1() %></label>
																			</div>
																		</li>
																	
																	<% }  %>
																	

																	<!--QUESTON 2 -->
																	 <% if ( reponse_correct.contains("2") && !(choix.contains("2"))) { %>

																	<li class="list-group-item missed ">
																		<div class="custom-control-label">
																			<label class="cursor-pointer font-italic d-block custom-control-label" for="customCheck2"><%= reponse.getQuestion().getChoix2() %></label>
																		</div>
																	</li>
																	
																	<% } else if (reponse_correct.contains("2") && (choix.contains("2")) ) {  %>

																		<li class="list-group-item rounded-0 correcte">
																			<div class="custom-control-label">
																				<label class="cursor-pointer font-italic d-block custom-control-label" for="customCheck1"><%= reponse.getQuestion().getChoix2() %></label>
																			</div>
																		</li>
																		

																	<% } else if ( !(reponse_correct.contains("1")) && choix.contains("1") ) {  %>

																		<li class="list-group-item rounded-0 incorrecte">
																			<div class="custom-control-label">
																				<label class="cursor-pointer font-italic d-block custom-control-label" for="customCheck1"><%= reponse.getQuestion().getChoix2() %></label>
																			</div>
																		</li>
																		
																	<% } else  {  %>

																	<li class="list-group-item ">
																			<div class="custom-control-label">
																				<label class="cursor-pointer font-italic d-block custom-control-label" for="customCheck2"><%= reponse.getQuestion().getChoix2() %></label>
																			</div>
																	</li>	

																	<% } %>


																	<!--QUESTON 3 -->
																	<% if (  reponse_correct.contains("3") && !(choix.contains("3")) ) { %>

																	<li class="list-group-item correct missed">
																		<div class="custom-control-label">
																			<label class="cursor-pointer font-italic d-block custom-control-label" for="customCheck3"><%= reponse.getQuestion().getChoix3() %></label>
																		</div>
																	</li>
																	
																	<% } else if (reponse_correct.contains("3") && (choix.contains("3")) ) {  %>

																		<li class="list-group-item rounded-0 correcte">
																			<div class="custom-control-label">
																				<label class="cursor-pointer font-italic d-block custom-control-label" for="customCheck1"><%= reponse.getQuestion().getChoix3() %></label>
																			</div>
																		</li>
																		
																	
																	<% } else if (!(reponse_correct.contains("3")) && choix.contains("3") ) {  %>

																		<li class="list-group-item rounded-0 incorrecte">
																			<div class="custom-control-label">
																				<label class="cursor-pointer font-italic d-block custom-control-label" for="customCheck1"><%= reponse.getQuestion().getChoix3() %></label>
																			</div>
																		</li>
																		
																	<% } else  {  %>

																	<li class="list-group-item ">
																			<div class="custom-control-label">
																				<label class="cursor-pointer font-italic d-block custom-control-label" for="customCheck3"><%= reponse.getQuestion().getChoix3() %></label>
																			</div>
																	</li>


																	<!--QUESTON 4 -->
																	<% } %>

																	<% if ( reponse_correct.contains("4") && !(choix.contains("4")) ) { %>
																	<li class="list-group-item missed">
																		<div class="custom-control-label">
																			<label class="cursor-pointer font-italic d-block custom-control-label" for="customCheck4"><%= reponse.getQuestion().getChoix4() %></label>
																		</div>
																	</li>
																	
																	<% } else if (reponse_correct.contains("4") && (choix.contains("4")) ) {  %>

																		<li class="list-group-item rounded-0 correcte">
																			<div class="custom-control-label">
																				<label class="cursor-pointer font-italic d-block custom-control-label" for="customCheck1"><%= reponse.getQuestion().getChoix4() %></label>
																			</div>
																		</li>
																		
																	<% } else if (!(reponse_correct.contains("4")) && choix.contains("4") ) {  %>

																		<li class="list-group-item rounded-0 incorrecte">
																			<div class="custom-control-label">
																				<label class="cursor-pointer font-italic d-block custom-control-label" for="customCheck1"><%= reponse.getQuestion().getChoix4() %></label>
																			</div>
																		</li>	

																	<% } else  {  %>
																	<li class="list-group-item ">
																			<div class="custom-control-label">
																				<label class="cursor-pointer font-italic d-block custom-control-label" for="customCheck3"><%= reponse.getQuestion().getChoix3() %></label>
																			</div>
																	</li>

																	<% } %>
																</ul>
															</div>
														</div>
										
													</div>
												</div>
											</div>
										</section>

									<% }
									    } %>
												
											

										</div>

										<div class="modal-footer">

										</div>
												
									</div>
												
									</div>
								
				</div>
				<!-- FIN Modal -->  
				
				<label><%= note_Test %> / 10</label>
				<% note_Test = 0;%>
				
				</td>
				
				<td class="table-primary" style="text-align: center;" >
						<button type="button" class="btn btn-dark rounded-pill"  data-toggle="modal" data-target="#info<%=test.getIdTest()%>">
							<i class="fas fa-info"></i> Consulter
						</button>
				</td>
				
				</tr>


		<%
			
			}
		%>

					  </tbody>
					</table>
			  </div>
			</div>
		</div>
	</div>
</body>
</html>