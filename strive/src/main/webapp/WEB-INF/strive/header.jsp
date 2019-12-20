<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="/css/header.css" rel="stylesheet" type="text/css"/>
	<link href="https://fonts.googleapis.com/css?family=Nunito&display=swap" rel="stylesheet">
</head>
<body>
	<header class="p-3">
		<div class="logo d-inline">
			<p class="d-inline">Strive <img class="header_img" src="/images/icon2.png" alt=""></p>
			<div class="d-inline links pl-5">
				<a class="d-inline link" href="">About</a>
				<a class="d-inline link pl-3" href="/feed">News Feed</a>
				<c:choose>
					<c:when test="${user.goals.size() > 0}">
						<a class="d-inline link pl-3" href="/allGoals">Your Goals</a>
					</c:when>
				</c:choose>
			</div>
		</div>
		<div class="buttons d-inline">	
			<a href="/logout" class="logout_button">Logout</a>
		</div>
	</header>
</body>
</html>