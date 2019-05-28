<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>

<!-- For DataTables -->
<link rel="stylesheet" type="text/css" href="resources/dataTables/datatables/css/dataTables.bootstrap4.css"/>
<link rel="stylesheet" type="text/css" href="resources/dataTables/buttons/css/buttons.bootstrap4.css"/>
<link rel="stylesheet" type="text/css" href="resources/dataTables/responsive/css/responsive.bootstrap4.css"/>
<link rel="stylesheet" type="text/css" href="resources/dataTables/scroller/css/scroller.bootstrap4.css"/>
 
 <!-- Bootstrap Core JavaScript -->
<script type="text/javascript" src="resources/js/bootstrap.js"></script>
 
<script type="text/javascript" src="resources/dataTables/jQuery-1.12.4/jquery-1.12.4.js"></script>
 
<!-- <script type="text/javascript" src="resources/dataTables/jQuery-3.3.1/jquery-3.3.1.js"></script> -->
<script type="text/javascript" src="resources/dataTables/datatables/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="resources/dataTables/datatables/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript" src="resources/dataTables/buttons/js/dataTables.buttons.js"></script>
<script type="text/javascript" src="resources/dataTables/buttons/js/buttons.bootstrap4.js"></script>
<script type="text/javascript" src="resources/dataTables/buttons/js/buttons.flash.js"></script>
<script type="text/javascript" src="resources/dataTables/responsive/js/dataTables.responsive.js"></script>
<script type="text/javascript" src="resources/dataTables/scroller/js/dataTables.scroller.js"></script>

<title>Employee Details</title>
</head>
<body>

	<P>Welcome : ${user}</P>

	<table id="emp" class="table table-striped table-bordered"  style="width: 100%;">
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
					<td>${emp.fname} ${emp.lname}</td>
					<td>${emp.phone}</td>
					<td>${emp.gender}</td>
					<td>${emp.address.country}</td>
					<td><input type="submit" onclick="editEmployee(${emp.id})"
						value="Edit"> <input type="submit"
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
		
		 /*  $(document).ready( function () {
		    $('#emp').DataTable();
		} );   */
	
		
		/*  $(document).ready(function() {
			    var table = $('#emp').DataTable( {
			        lengthChange: false,
			        buttons: [ 'copy', 'excel', 'pdf', 'colvis' ]
			    } );
			 
			    table.buttons().container()
			        .appendTo( '#example_wrapper .col-md-6:eq(0)' );
			} ); */
			
		
			// Material Design example
			$(document).ready(function () {
			$('#emp').DataTable();
			$('#emp_wrapper').find('label').each(function () {
			$(this).parent().append($(this).children());
			});
			$('#emp_wrapper .dataTables_filter').find('input').each(function () {
			$('input').attr("placeholder", "Search");
			$('input').removeClass('form-control-sm');
			});
			$('#emp_wrapper .dataTables_length').addClass('d-flex flex-row');
			$('#emp_wrapper .dataTables_filter').addClass('md-form');
			$('#emp_wrapper select').removeClass(
			'custom-select custom-select-sm form-control form-control-sm');
			$('#emp_wrapper select').addClass('mdb-select');
			$('#emp_wrapper .mdb-select').materialSelect();
			$('#emp_wrapper .dataTables_filter').find('label').remove();
			});
			
	</script>

	
</body>
</html>
