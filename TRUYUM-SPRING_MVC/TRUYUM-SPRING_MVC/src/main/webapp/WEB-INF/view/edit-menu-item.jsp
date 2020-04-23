<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="https://www.thymeleaf.org">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link type="text/css" rel="stylesheet" href="./style/style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<title>Edit Menu Item</title>
</head>

<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<header class="mdl-layout__header">
			<div class="mdl-layout__header-row">
				<span class="mdl-layout-title">truYum</span> <img
					class="mdl-layout-icon logo" src="images/truyum-logo-light.png"></img>
				<div class="mdl-layout-spacer"></div>
				<nav class="mdl-navigation">
					<a class="mdl-navigation__link" href="">Menu</a>
				</nav>
			</div>
		</header>
		<div class="mdl-layout__drawer">
			<span class="mdl-layout-title">Select Role</span>
			<nav class="mdl-navigation">
				<a class="mdl-navigation__link" href="menu-item-list-admin.html">Admin</a>
				<a class="mdl-navigation__link" href="menu-item-list-customer.html">Customer</a>
			</nav>
		</div>
		<main class="mdl-layout__content">
			<div class="page-content">
				<div class="mdl-grid">
					<div class="mdl-cell mdl-cell--3-col"></div>
					<div class="mdl-cell--6-col">
						<caption>
							<h3>Edit Menu Item</h3>
						</caption>
						<form name="menuItemForm" method="post" action="/edit-menu-item" th:object="{menuItem}">
							<c:set var="menuItem" value="${menuItem}"></c:set>
							<div class="form-group">
								<label for="pname" path="name">Name</label> <input type="text"
									class="form-control" id="prodname" value="${menuItem.name}" th:field="*{name}">
							</div>
							<div class="form-row">
								<div class="form-group col-md-2">
									<label for="price">Price (Rs.)</label> <input type="text"
										class="form-control" id="price" value="${menuItem.price}">
								</div>
								<div class="form-group col-md-2" style="margin: 0px 20px;">
									<label for="active">Active</label><br>
									<div style="padding: 5px;">
										<input type="radio" value="Yes" name="active"
											<c:if test="${menuItem.active}">checked</c:if>>Yes</label>&nbsp;&nbsp;
										<input type="radio" value="No" name="active"
											<c:if test="${!menuItem.active}">checked</c:if>><label>No</label>
									</div>
								</div>
								<div class="form-group col-md-3">
									<label for="dateOfLaunch">Date of Launch</label> <input
										type="date" class="form-control" id="dateOfLaunch"
										value="${menuItem.dateOfLaunch}">
								</div>
								<div class="form-group col-md-3">
									<label for="category">Category</label> <select id="category"
										class="form-control">
										<option value="Starters" <c:if test="${menuItem.category == 'Starters'}">selected</c:if>>Starters</option>
										<option value="Main Course" <c:if test="${menuItem.category == 'Main Course'}">selected</c:if> >Main Course</option>
										<option value="Dessert" <c:if test="${menuItem.category == 'Dessert'}">selected</c:if>>Dessert</option>
										<option value="Drinks" <c:if test="${menuItem.category == 'Drinks'}">selected</c:if>>Drinks</option>
									</select>
								</div>

							</div>
							<div class="form-group">
								<div class="form-check">
									<input class="form-check-input" type="checkbox"
										id="freeDelivery"> <label class="form-check-label"
										for="gridCheck"> Free Delivery </label>
								</div>
							</div>
							<button
								class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored mdl-js-ripple-effect"
								type="submit" id="save">Save</button>
						</form>

					</div>
					<div class="mdl-cell mdl-cell--3-col"></div>
				</div>
			</div>
		</main>
		<footer class="mdl-mini-footer">
			<div class="mdl-mini-footer__left-section">
				<div class="mdl-logo">Copyright &copy; 2019</div>
			</div>
		</footer>
	</div>
</body>

</html>