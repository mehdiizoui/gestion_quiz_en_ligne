<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.Entity.Question"%>
<%@page import="org.upf.gestion_quiz.gestion_quiz_enligne.Bean.BeanQuestion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
	BeanQuestion bean ;
	if (session.getAttribute("lst10") == null){
		bean = new BeanQuestion();
	}else{
		bean = (BeanQuestion)session.getAttribute("lst10");
	}
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title id="temps">Quiz</title>
	
      
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/2da0a9a74b.js" crossorigin="anonymous"></script>
	<script type="text/javascript">
        var total_seconds = 30 * 1;
        var c_minutes = parseInt(total_seconds / 60);
        var c_seconds = parseInt(total_seconds % 60);
        var timer;

        function CheckTime() {
        document.getElementById("temps").innerHTML = 'Temps : ' + c_minutes + ' M ' + c_seconds + ' S ';
        document.getElementById("toastalert").innerHTML = '' + c_minutes + ' Minutes ' + c_seconds + ' Secondes ';

        if (total_seconds <= 0) {
            document.form.submit();
        } else {
            total_seconds = total_seconds - 1;
            c_minutes = parseInt(total_seconds / 60);
            c_seconds = parseInt(total_seconds % 60);
            timer = setTimeout(CheckTime, 1000);
        }
        }
        timer = setTimeout(CheckTime, 1000);  
    </script>
     <script>
        $(document).ready(function(){
           $('.toast').toast('show');   
        });
        function play() {
        		var audio = document.getElementById("audio");
                audio.play();
        }
        function pause() {
    		var audio = document.getElementById("audio");
            audio.pause();
    	}
      </script>
     <style type="text/css">
     .btn-lg {
    padding: 3px 13px;
}

.text-small {
    font-size: 0.9rem !important;
}

body {
    background: linear-gradient(to left, #4535da, #a8e063);
}

.cursor-pointer {
    cursor: pointer;
}

</style>
</head>
<body >
<form action="/gestion_quiz_enligne/ServletQuiz" name="form" method="post">

<section class="py-5 header text-center text-white">
    <div class="container pt-4">
        <header>
            <h1 class="display-4">Bienvenue Au Quiz</h1>
            <p class="font-italic mb-1">Genre : <b><%=session.getAttribute("genre").toString() %></b></p>
        </header>
    </div>
</section>
	
	
    <div aria-live="polite" aria-atomic="true" style="position: relative;">

      <div  class="position-fixed" style="right: 0px; bottom: 0px" >

	      <div id="toast1" class="toast" role="alert" aria-live="assertive" aria-atomic="true" data-autohide="false"  >
	          <div class="toast-header">
	              <svg class="bd-placeholder-img rounded mr-2" width="20" height="20" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img"><rect width="100%" height="100%" fill="#7c4dff"></rect></svg>
	              <strong class="mr-auto"> <i class="far fa-clock"></i> Temps restant : <i class="fas fa-level-down-alt"></i></strong>
	              
	              <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
	                
	              </button>
	          </div>
	          <div class="toast-body" id="toastalert">
	             
	          </div>
	      </div>
	  </div>
    </div>
    
    <div aria-live="polite" aria-atomic="true" style="position: relative;">

      <div  class="position-fixed" style="right: 0px; bottom: 90px" >

	      <div id="toast1" class="toast" role="alert" aria-live="assertive" aria-atomic="true" data-autohide="false"  >
	          <div class="toast-header">
	              <svg class="bd-placeholder-img rounded mr-2" width="20" height="20" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img"><rect width="100%" height="100%" fill="#7c4dff"></rect></svg>
	              <strong class="mr-auto"> <i class="fas fa-music"></i> Ecouter Music : <i class="fas fa-level-down-alt"></i></strong>
	              
	              <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
	                
	              </button>
	          </div>
	          <div class="toast-body" style="width:100px; margin:0 auto;">
	             
	             
	             <div class="btn-group btn-group-toggle" data-toggle="buttons">
				  
				  
				  <button type="button" class="btn btn-outline-success" onclick="play()"><i class="far fa-play-circle"></i></button>
				  <button type="button" class="btn btn-outline-danger" onclick="pause()"><i class="far fa-pause-circle"></i></button>
				  
				</div>
				
	          </div>
	      </div>
	  </div>
    </div>
      
    
	<section>
	    <div class="container">
	        <div class="row">
	            <div class="col-lg-7 mx-auto">
	                
					<% for(Question q : bean.getLst10()) {%>
	                <div class="card shadow border-0 mb-5">
	                    <div class="card-body p-5">
	                        <h2 class="h4 mb-1"><%=q.getQuestion() %></h2>
	                        <ul class="list-group">
	                            <li class="list-group-item rounded-0">
	                                <div class="custom-control custom-checkbox">
	                                    <input class="custom-control-input" name="selected" type="checkbox" id="<%=q.getId_Question()+"-1" %>" value="<%=q.getId_Question()+"-1" %>"  >
	                                    <label class="cursor-pointer font-italic d-block custom-control-label" for="<%=q.getId_Question()+"-1" %>" ><%=q.getChoix1() %></label>
	                                </div>
	                            </li>
	                            <li class="list-group-item">
	                                <div class="custom-control custom-checkbox">
	                                    <input class="custom-control-input" name="selected" type="checkbox" id="<%=q.getId_Question()+"-2" %>" value="<%=q.getId_Question()+"-2" %>"  >
	                                    <label class="cursor-pointer font-italic d-block custom-control-label" for="<%=q.getId_Question()+"-2" %>"><%=q.getChoix2() %></label>
	                                </div>
	                            </li>
	                            <li class="list-group-item">
	                                <div class="custom-control custom-checkbox">
	                                    <input class="custom-control-input" name="selected" type="checkbox" id="<%=q.getId_Question()+"-3" %>" value="<%=q.getId_Question()+"-3" %>"  >
	                                    <label class="cursor-pointer font-italic d-block custom-control-label" for="<%=q.getId_Question()+"-3" %>"><%=q.getChoix3() %></label>
	                                </div>
	                            </li>
	                            <li class="list-group-item">
	                                <div class="custom-control custom-checkbox">
	                                    <input class="custom-control-input" name="selected" type="checkbox" id="<%=q.getId_Question()+"-4" %>" value="<%=q.getId_Question()+"-4" %>" >
	                                    <label class="cursor-pointer font-italic d-block custom-control-label" for="<%=q.getId_Question()+"-4" %>" ><%=q.getChoix4() %></label>
	                                </div>
	                            </li>
	                            
	                        </ul>
	                    </div>
	                </div>
	                <%} %>
	                
	                <button type="submit" class="btn btn-primary btn-lg btn-block">Valider</button>
	            </div>
	        </div>
	    </div>
	</section>
    
    
        
      
      
	
    
    <audio id="audio" src="https://ia801707.us.archive.org/5/items/onycs-shine/Onycs-Shine.mp3"></audio>
      

   </form>
</body>
</html>