<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>

<!-- For DataTables -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/dataTables.bootstrap.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/dataTables.bootstrap.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Template by Dry Themes" />
<meta name="keywords" content="HTML, CSS, JavaScript, PHP" />
<meta name="author" content="DryThemes" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<link rel="shortcut icon" href="resources/gallery/images/favicon.png" />
<link
	href='http://fonts.googleapis.com/css?family=Roboto:300,400,400i,700,700i,900%7CMontserrat:400,700%7CPT+Serif'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css"
	href='resources/gallery/css/clear.css' />
<link rel="stylesheet" type="text/css"
	href='resources/gallery/css/common.css' />
<link rel="stylesheet" type="text/css"
	href='resources/gallery/css/font-awesome.min.css' />
<link rel="stylesheet" type="text/css"
	href='resources/gallery/css/carouFredSel.css' />
<link rel="stylesheet" type="text/css"
	href='resources/gallery/css/prettyPhoto.css' />
<link rel="stylesheet" type="text/css"
	href='resources/gallery/css/sm-clean.css' />
<link rel="stylesheet" type="text/css"
	href='resources/gallery/style.css' />

<title>Employee Details</title>
</head>
<body>
	
	<%@include file="header.jsp" %>
		

	<P>Welcome : ${user}</P>

	<table id="emp" class="table table-striped table-bordered"
		style="width: 100%;">
		<thead>
			<tr class="success">
				<td>Name</td>
				<td>Phone</td>
				<td>Gender</td>
				<td>Country</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${elist}">
				<tr class="danger">
					<td>${emp.fname} ${emp.lname}</td>
					<td>${emp.phone}</td>
					<td>${emp.gender}</td>
					<td>${emp.address.country}</td>
					<td><input type="submit" class="btn btn-success"
						onclick="editEmployee(${emp.id})" value="Edit"> <input
						type="submit" class="btn btn-danger"
						onclick="deleteEmployee(${emp.id})" value="Delete"></td>
				</tr>
			</c:forEach>

		</tbody>


	</table>
	
	<%@include file="footer.jsp"%>

	<script type="text/javascript">
		function editEmployee(id) {
			window.location="${pageContext.request.contextPath}/"+id+"/edit";
		}
		function deleteEmployee(id) {
			window.location="${pageContext.request.contextPath}/"+id+"/delete";
		}
		
		 $(document).ready( function () {
		    $('#emp').DataTable();
		} );  
	
		
		
	</script>
	
	<script src="resources/gallery/js/jquery.js"></script>
	<script src='resources/gallery/js/jquery.fitvids.js'></script>
	<script src='resources/gallery/js/jquery.smartmenus.min.js'></script>
	<script src='resources/gallery/js/isotope.pkgd.js'></script>
	<script src='resources/gallery/js/imagesloaded.pkgd.js'></script>
	<script src='resources/gallery/js/isotope.pkgd.js'></script>
	<script src='resources/gallery/js/jquery.carouFredSel-6.0.0-packed.js'></script>
	<script src='resources/gallery/js/jquery.mousewheel.min.js'></script>
	<script src='resources/gallery/js/jquery.touchSwipe.min.js'></script>
	<script src='resources/gallery/js/jquery.easing.1.3.js'></script>
	<script src='resources/gallery/js/imagesloaded.pkgd.js'></script>
	<script src='resources/gallery/js/jquery.prettyPhoto.js'></script>
	<script src='resources/gallery/js/jquery.nicescroll.min.js'></script>
	<script src='resources/gallery/js/main.js'></script>


</body>
</html>
