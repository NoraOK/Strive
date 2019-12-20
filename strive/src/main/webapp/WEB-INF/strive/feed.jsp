<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Financial News</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link href="/css/feed.css" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Nunito&display=swap"
	rel="stylesheet">
</head>
<body>
	<div>
		<jsp:include page="headerNoLogout.jsp" />
	</div>
	<div class="body">
		<div id="feedBanner" align="center">
			<div align="left" class="col-5 d-inline-block text">
				<h1>Let's Talk Money</h1>
				<h3>In-depth financial articles from reliable sources.</h3>
				<p>Educate yourself in the world of finance and financial
					business with up-to-date news specially curated by our Strive
					specialists.</p>
			</div>
			<div class="col-5 d-inline-block">
				<img id="piggy" src="/images/piggyBank.png">
			</div>
		</div>
		<div align="center">
			<c:forEach items="${articles}" var="article">
				<div class="articles col-4">
					<c:if
						test="${!article.getAsJsonObject().get('urlToImage').isJsonNull()}">
						<img
							src="<c:out value="${article.getAsJsonObject().get('urlToImage').getAsString()}" />"
							alt="NO IMG" width="100%" height="300px">
					</c:if>
					<h4 align="left" class="">
						<c:if test="${!article.getAsJsonObject().get('title').isJsonNull()}">
							<a
								href="<c:out
				value="${article.getAsJsonObject().get('url').getAsString()}"></c:out>"><c:out
									value="${article.getAsJsonObject().get('title').getAsString()}"></c:out></a>
						</c:if>
					</h4>
					<p class="details" align="left">
						<c:if
							test="${!article.getAsJsonObject().get('description').isJsonNull()}">
							<c:out
								value="${article.getAsJsonObject().get('description').getAsString()}"></c:out>
						</c:if>
					</p>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>