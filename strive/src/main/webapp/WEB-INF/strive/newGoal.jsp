<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page isErrorPage="true" %>

    
<!DOCTYPE html>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="/css/newGoal.css" rel="stylesheet" type="text/css"/>
	<link href="https://fonts.googleapis.com/css?family=Nunito&display=swap" rel="stylesheet">
<html>
<head>
<meta charset="UTF-8">
<title>Strive for a new goal!</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp"/>
	</div>
	<div align="center">
	<div class="body col-5" align="left">
		<h3>Set a new goal</h3>
		<form:form action="/strive/newGoal" method="post"
			modelAttribute="goal">
			<form:hidden path="user" value="${user.id}"/>
			<p>
				<form:label path="goalName" class="lead col-form-label">Goal: </form:label>
				<form:errors path="goalName"/>
				<form:input path="goalName" type="text" class="form-control" />
			</p>

			<p>
				<form:label path="deadline" class="lead col-form-label">Deadline: </form:label>
				<form:errors path="deadline"/>
				<form:input path="deadline" type="date" class="form-control" />
			</p>
			<input class="btn btn-info" type="submit" value="Submit" />
			<a class="btn btn-warning" href="/userHome">Cancel</a>
		</form:form>
	</div>
	</div>
</body>
</html>