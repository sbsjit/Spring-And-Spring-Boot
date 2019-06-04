<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML>
<html lang="en-US">
<head>
<title>Employee's Gallery</title>
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

<!--[if lt IE 9]>
                <script src="js/html5shiv.js"></script>                
                <script src="js/respond.min.js"></script>                
        <![endif]-->

</head>
<body class="page">

	<%@include file="header.jsp"%>





	<div class="block content-1170 center-relative">
		<h1 class="entry-title">Welcome to our employee's gallery!!!</h1>
		<p class="page-desc">Without their efforts it's not possible.</p>
	</div>


	<c:forEach var="imgname" items="${imglist}">

		<img alt="${imgname }" src="resources/imgs/${imgname}" width="500px;"
			height="400px;" hspace=”30;”>

	</c:forEach>




	<div
		class="block content-1170 center-relative center-text top-50 bottom-50">
		<a target="_self" class="more-posts-portfolio"> <img
			src="resources/gallery/images/loadMoreArrow.png" alt="Load more" />
		</a>
	</div>
	<div class="clear"></div>

	
	


	<!--Footer-->

	<%@include file="footer.jsp"%>

	<!-- End .body-border -->


	<!--Load JavaScript-->
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