<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Edit Employee Details</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png"
	href="resources/form/images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/form/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/form/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/form/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/form/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/form/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/form/css/util.css">
<link rel="stylesheet" type="text/css"
	href="resources/form/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	<%@include file="header.jsp" %>
	
	<div class="bg-contact3"
		style="background-image: url('resources/form/images/bg-01.jpg');">
		<div class="container-contact3">
			<div class="wrap-contact3">
				<spring:form action="${pageContext.request.contextPath}/update"
					method="post" modelAttribute="emodel"
					class="contact3-form validate-form">
				<span class="contact3-form-title"> Edit Employee Details </span>

					<div class="wrap-input3 validate-input"
						data-validate="First name is required">
						<spring:input class="input3" type="text" path="fname"
							placeholder="Employee's First Name" />
						<span class="focus-input3"></span>
					</div>

					<div class="wrap-input3 validate-input"
						data-validate="Last name is required">
						<spring:input class="input3" type="text" path="lname"
							placeholder="Last Name" />
						<span class="focus-input3"></span>
					</div>

					<div class="wrap-contact3-form-radio">
						<div class="contact3-form-radio m-r-42">
							<spring:radiobutton class="input-radio3" id="radio1"
								path="gender" value="male" name="choice" />
							<label class="label-radio3" for="radio1"> Male </label>
						</div>

						<div class="contact3-form-radio m-r-42">
							<spring:radiobutton class="input-radio3" id="radio1"
								path="gender" value="female" name="choice" />
							<label class="label-radio3" for="radio1"> Female </label>
						</div>
					</div>

					<div class="wrap-input3 validate-input"
						data-validate="Phone Number is required">
						<spring:input class="input3" path="phone"
							placeholder="Phone Number" />
						<span class="focus-input3"></span>
					</div>

					<div class="wrap-input3 validate-input"
						data-validate="DOB is required">
						<spring:input class="input3" path="dob" type="date"
							placeholder="Date-Of-Birth" />
						<span class="focus-input3"></span>
					</div>

					<div class="wrap-input3 validate-input"
						data-validate="Company name is required">
						<spring:input class="input3" path="company" placeholder="Company" />
						<span class="focus-input3"></span>
					</div>

					<div class="wrap-input3 validate-input"
						data-validate="Post is required">
						<spring:input class="input3" path="post" placeholder="Post" />
						<span class="focus-input3"></span>
					</div>

					<div class="wrap-input3 validate-input"
						data-validate="Salary is required">
						<spring:input class="input3" path="salary" placeholder="Salary" />
						<span class="focus-input3"></span>
					</div>

					<div class="wrap-input3 validate-input"
						data-validate="Joining Date is required">
						<spring:input class="input3" path="joiningDate" type="date"
							placeholder="Joining Date" />
						<span class="focus-input3"></span>
					</div>

					<div class="wrap-input3 validate-input"
						data-validate="Country is required">
						<spring:input class="input3" path="address.country"
							placeholder="Country" />
						<span class="focus-input3"></span>
					</div>

					<div class="wrap-input3 validate-input"
						data-validate="City is required">
						<spring:input class="input3" path="address.city"
							placeholder="City" />
						<span class="focus-input3"></span>
					</div>

					<div class="wrap-input3 validate-input"
						data-validate="State is required">
						<spring:select class="input3" path="address.state"
							placeholder="State">
							<spring:option value="">------Select State-------</spring:option>
							<spring:option value="1">State-1</spring:option>
							<spring:option value="2">State-2</spring:option>
							<spring:option value="3">State-3</spring:option>
							<spring:option value="4">State-4</spring:option>
							<spring:option value="4">State-4</spring:option>
							<spring:option value="5">State-5</spring:option>
							<spring:option value="6">State-6</spring:option>
							<spring:option value="7">State-7</spring:option>
						</spring:select>
						<span class="focus-input3"></span>
					</div>

					<div class="wrap-input3 validate-input"
						data-validate="Zip Address is required">
						<spring:input class="input3" path="address.zip"
							placeholder="Zip Address" />
						<span class="focus-input3"></span>
					</div>

					<div class="container-contact3-form-btn">
						<input type="submit" value="Update" class="contact3-form-btn">
					</div>
					
					<spring:hidden path="id" />
					<spring:hidden path="address.id" />
					
				</spring:form>
			</div>
		</div>
	</div>


	<div id="dropDownSelect1"></div>

	<!--===============================================================================================-->
	<script src="resources/form/vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="resources/form/vendor/bootstrap/js/popper.js"></script>
	<script src="resources/form/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="resources/form/vendor/select2/select2.min.js"></script>
	<script>
		$(".selection-2").select2({
			minimumResultsForSearch : 20,
			dropdownParent : $('#dropDownSelect1')
		});
	</script>
	<!--===============================================================================================-->
	<script src="resources/form/js/main.js"></script>

	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async
		src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
	
	<script>
		window.dataLayer = window.dataLayer || [];
		function gtag() {
			dataLayer.push(arguments);
		}
		gtag('js', new Date());

		gtag('config', 'UA-23581568-13');
	</script>

</body>
</html>
