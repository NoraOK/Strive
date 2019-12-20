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
<link href="https://fonts.googleapis.com/css?family=Nunito:200,400,700&display=swap" rel="stylesheet">

<html>
<head>
<meta charset="UTF-8">
<title>Strive | Goal</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />
	</div>
	<div class="body col-12" align="center">
	<img src="/images/city.png" >
		<div class="leftRight col-5 d-inline-block p-5" align="left">
			<%-- <c:out value="${goal.user.firstName}" /> --%>
			<p class="main">
				<c:out value="${goal.goalName}" />
			</p>
			<p>
				<span class="labels">Created on:</span>
				<fmt:formatDate pattern="MMMM dd, yyyy" value="${goal.createdAt}" />
			</p>
			<p>
				<span class="labels">Deadline:</span>
				<fmt:formatDate pattern="MMMM dd, yyyy" value="${goal.deadline}" />
			</p>
			<p class="labels">
				<c:choose>

					<c:when test="${goal.goal_expenses.size() == 0}">
						<p>Add an expense to your goal so Strive can create a plan to
							help you reach it!</p>
					</c:when>
					<c:when
						test="${((user.incomeLessExpense) + (user.currentBalance)) < (goal.totalGoalExpense /(goal.duration/4))}">
						<p>
							According to your <a href="/updateFinances">Personal Finances</a>
							you will not be able to achieve your goal. But we don't want you
							to give up! Try setting your goal deadline farther out.
						</p>
					</c:when>
					<c:otherwise>
						<p>
							<span class="labels">Goal Plan:</span></p>
							<c:out value="${goal.goalResult}" />
						
					</c:otherwise>
				</c:choose>
			</p>
		</div>
		<div class="leftRight col-5 d-inline-block p-5" align="left">

			<p class="labels">Goal Expenses:</p>
			<table class="table">
				<thead>
					<tr>
						<th>Expense</th>
						<th>Cost</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${goal.goal_expenses}" var="goalExpense">
						<tr>
							<td><c:out value="${goalExpense.name}" /></td>
							<td><fmt:formatNumber value="${goalExpense.amount}" type="currency" /></td>
							<td>
								<form action="/deleteGoalExpense/${goalExpense.id}"
									method="post">
									<input type="hidden" name="_method" value="delete"> 
									<input type="submit" value="Delete" class="button2 btn-sm">
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>


			</table>
			<p>
				<form:form action="/addGoalExpense" method="post"
					modelAttribute="goalExpense" class="row">
					<form:hidden path="goal" value="${goal.id}" />
					<form:input path="name" type="text" class="form-control col m-1" placeholder="Expense"/>
					<form:input path="amount" type="text" class="form-control col m-1" placeholder="Amount" />
					<input class="button2 btn-sm" type="submit" value="Add" />
				</form:form>
			</p>
		</div>
	</div>
</body>
</html>