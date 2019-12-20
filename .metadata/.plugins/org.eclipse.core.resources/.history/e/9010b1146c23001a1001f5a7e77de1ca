<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Strive | Home</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link href="/css/userHome.css" rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,400,700&display=swap"
	rel="stylesheet">
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />
	</div>
	<div class="body">
		<img src="/images/sunset.jpg">
		<div class="container col-8 spotlight">
			<p class="welcome">
				Welcome
				<c:out value="${user.firstName}" />
			</p>
			<c:choose>
				<c:when
					test="${user.currentBalance == null || user.currentIncome == null }">
					<div class="col-5 d-inline-block">
						<p class="labels">Current Savings</p>
						<p class="fig">Click below to add your current savings.</p>
					</div>
					<div class="col-5 d-inline-block">
						<p class="labels">Current Income (Monthly)</p>
						<p class="fig inc">Click below to update your current income.</p>
					</div>
					<div class="col-5 d-inline-block">
						<p class="labels">Current Expenses (Monthly)</p>
						<p class="fig exp">Click below to update your current
							expenses.</p>
					</div>
					<div class="col-5 d-inline-block">
						<p class="labels">Net Income (Monthly)</p>
						<p class="fig netinc ">$ 0</p>
					</div>
				</c:when>
				<c:otherwise>

					<div class="col-5 d-inline-block">
						<p class="labels">Current Savings</p>
						<p class="fig">
							<fmt:formatNumber value="${user.currentBalance}" type="currency" />
						</p>
					</div>
					<div class="col-5 d-inline-block">
						<p class="labels">Current Income (Monthly)</p>
						<p class="fig inc">
							<fmt:formatNumber value="${user.currentIncome}" type="currency" />
						</p>
					</div>
					<div class="col-5 d-inline-block">
						<p class="labels">Current Expenses (Monthly)</p>
						<p class="fig exp">
							<fmt:formatNumber value="${user.totalUserExpense}"
								type="currency" />
						</p>
					</div>
					<div class="col-5 d-inline-block">
						<p class="labels">Net Income (Monthly)</p>
						<c:choose>
							<c:when test="${user.incomeLessExpense > 0}">
								<p class="fig netinc pos">
									<fmt:formatNumber value="${user.incomeLessExpense}"
										type="currency" />
								</p>
							</c:when>
							<c:otherwise>
								<p class="fig netinc neg">
									<fmt:formatNumber value="${user.incomeLessExpense}"
										type="currency" />
								</p>
							</c:otherwise>
						</c:choose>
					</div>
				</c:otherwise>
			</c:choose>
			<p>
			<a href="/updateFinances" class="button1 one col btn-lg">Update
				Personal Finances</a> <a href="/newGoal" class="button1 two col btn-lg">Set
				New Goals</a>
				</p>
		</div>

	</div>
</body>
</html>