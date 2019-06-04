<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">



<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/dataTables.bootstrap.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<!-- Start navbar -->
			<nav class="navbar navbar-default navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<a class="navbar-brand" }/home">Employee Management System</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li><a href="${pageContext.request.contextPath}/home">Home</a></li>
							<li><a href="${pageContext.request.contextPath}/email">Contact</a></li>
							<li><a href="${pageContext.request.contextPath}/gallery">Gallery</a></li>
							<li><a href="${pageContext.request.contextPath}/employee">Add Employee</a></li>
							<li><a href="${pageContext.request.contextPath}/profile">Profile</a></li>
							<li class="active"><a
								href="${pageContext.request.contextPath}/logout">Logout<span
									class="sr-only">(current)</span></a></li>
						</ul>
					</div>
				</div>
			</nav>
			<!-- End navbar -->
	
</body>
</html>