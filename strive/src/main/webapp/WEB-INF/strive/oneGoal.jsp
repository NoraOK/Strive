<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link href="/css/oneGoal.css" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Nunito&display=swap"
	rel="stylesheet">
<html>
<head>
<meta charset="UTF-8">
<title>Strive | Goal</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />
	</div>
	<div class="body col-5 d-inline-block" align="left">
		<c:out value="${goal.user}"></c:out>
		<p class="main">
			<c:out value="${goal.goalName}" />
		</p>
		<p class="labels">
			<fmt:formatDate pattern="MMMM dd, yyyy" value="${goal.deadline}" />
		</p>
		<p class="labels">
			Goal Result:
			<c:out value="${goal.goalResult}" />
		</p>
		<p>
			<form:form action="/addGoalExpense" method="post"
				modelAttribute="goalExpense">
				<form:hidden path="goal" value="${goal.id}" />
				<form:label path="name">Expense:</form:label>
				<form:input path="name" type="text" class="form-control" />
				<form:label path="amount">Amount:</form:label>
				<form:input path="amount" type="text" class="form-control" />
				<input type="submit" value="Add" />
			</form:form>
		</p>
	</div>
	<div class="body col-5 d-inline-block">
		<p>Monthly Expenses:</p>
		<c:forEach items="${goal.goal_expenses}" var="goalExpense">
			<p>
				<c:out value="${goalExpense.name}" />
				<c:out value="${goalExpense.amount}" />
				<%-- 			<form action="/deleteGoalExpense" method="post">
				<input type="hidden" name="_method" value="delete"> <input
					type="submit" value="Delete">
			</form> --%>
			</p>
		</c:forEach>
	</div>
</body>
</html>