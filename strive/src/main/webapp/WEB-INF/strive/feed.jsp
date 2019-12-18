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
		<div align="center">
			<c:forEach items="${articles}" var="article">
				<div class="articles col-4">
					<c:if
						test="${!article.getAsJsonObject().get('urlToImage').isJsonNull()}">
						<img
							src="<c:out value="${article.getAsJsonObject().get('urlToImage').getAsString()}" />"
							alt="NO IMG" class="col-12" height="200px">
					</c:if>
					<h3 align="left">
						<a
							href="<c:out
				value="${article.getAsJsonObject().get('url').getAsString()}"></c:out>"><c:out
								value="${article.getAsJsonObject().get('source').getAsJsonObject().get('name').getAsString()}"></c:out></a>
					</h3>
					<h5 align="left">
						<c:out
							value="${article.getAsJsonObject().get('title').getAsString()}"></c:out>
					</h5>
					<c:out
						value="${article.getAsJsonObject().get('description').getAsString()}"></c:out>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>