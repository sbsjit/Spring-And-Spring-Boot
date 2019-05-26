<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">

<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<title>Home</title>
</head>
<body bgcolor="#E9967A">
	<h1>Hello world!</h1>

	<P>Welcome : ${user}</P>

	<table id="emp" class="display">
		<thead>
			<tr>
				<td>Name</td>
				<td>Phone</td>
				<td>Gender</td>
				<td>Country</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${elist}">
				<tr>
					<td>${emp.fname}${emp.lname}</td>
					<td>${emp.phone}</td>
					<td>${emp.gender}</td>
					<td>${emp.address.country}</td>
					<td><input type="submit" onclick="editStudent(${emp.id})"
						value="Edit"> <input type="submit"
						onclick="deleteStudent(${emp.id})" value="Delete"></td>
				</tr>
			</c:forEach>

		</tbody>


	</table>

	<script type="text/javascript">
	
	
	function editStudent(id) {
		window.location="${pageContext.request.contextPath}/"+id+"/edit";
	}
	function deleteStudent(id) {
		window.location="${pageContext.request.contextPath}/"+id+"/delete";
	}
	$(document).ready( function () {
	    $('#emp').DataTable();
	} );
	
	</script>

</body>
</html>
