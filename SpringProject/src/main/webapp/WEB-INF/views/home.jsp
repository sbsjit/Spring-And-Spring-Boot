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
					<td>${emp.fname}${emp.lname}</td>
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


</body>
</html>
