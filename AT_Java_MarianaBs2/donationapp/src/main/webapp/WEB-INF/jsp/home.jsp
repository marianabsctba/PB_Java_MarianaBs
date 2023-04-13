<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Sobre</title>
<!-- BootsTrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
<!-- Font Awesome -->

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons" />
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link href='https://fonts.googleapis.com/css?family=Roboto'
	rel='stylesheet'>

</head>

<body>

	<c:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="aboutus-section">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="aboutus">
						<h2 class="aboutus-title">Sobre</h2>

						<p class="aboutus-text">Good Hands - Gerenciador de doações</p>
						<p class="aboutus-text">Projeto realizado para a disciplina de
							Java - Instituto Infnet - 2023</p>
						<p class="aboutus-text">A Good Hands trabalha com o coração.
							Contribui para o gerenciamento de doações de ONGs</p>
					</div>
				</div>
				<div class="col-md-5 col-sm-6 col-xs-15">
					<div class="aboutus-banner">
						<img src="/img/mari.jpg" alt="" width="50%" class="rounded-circle">
					</div>
					<div class="feature">
						<div class="feature-box">
							<div class="clearfix">
								<div class="feature-content">
									<h4>CEO/Criadora</h4>
									<p>Mariana Buhrer Sukevicz</p>
									<p>Estudante de Engenharia de Software</p>
								</div>
								<i class="fa fa-linkedin-square" style="font-size:36px">Mariana Buhrer</i>


							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>


	<c:import url="/WEB-INF/jsp/footer.jsp" />
</body>

</html>