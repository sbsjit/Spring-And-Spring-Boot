<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png"
	href="resources/contact/images/icons/favicon.ico" />

<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/contact/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/contact/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/contact/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/contact/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/contact/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/contact/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/contact/css/util.css">
<link rel="stylesheet" type="text/css"
	href="resources/contact/css/main.css">
<!--===============================================================================================-->

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

</head>
<body>
	<%@include file="header.jsp"%>

	<div class="container-contact100">

		<div class="wrap-contact100">
			<form class="contact100-form validate-form" action="email" method="post" >
			
				<span class="contact100-form-title"> Send a Message </span>

				<div class="wrap-input100 validate-input"
					data-validate="Please enter your email: e@a.x">
					<input class="input100" type="text" name="to" placeholder="E-mail">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input"
					data-validate="Please enter the subject">
					<input class="input100" type="text" name="subject"
						placeholder="Subject"> <span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input"
					data-validate="Please Enter the Message/Content">
					<textarea class="input100" name="msg" placeholder="Your Message"></textarea>
					<span class="focus-input100"></span>
				</div>

				<div class="container-contact100-form-btn">
					<button class="contact100-form-btn" type="Submit">
						<span> <i class="fa fa-paper-plane-o m-r-6"
							aria-hidden="true"></i> Send
						</span>
					</button>
				</div>
			</form>
		</div>
	</div>


	<%@include file="footer.jsp"%>


	<!--===============================================================================================-->
	<script src="resources/contact/vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="resources/contact/vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="resources/contact/vendor/bootstrap/js/popper.js"></script>
	<script src="resources/contact/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="resources/contact/vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="resources/contact/vendor/daterangepicker/moment.min.js"></script>
	<script
		src="resources/contact/vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="resources/contact/vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="resources/contact/js/main.js"></script>

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
