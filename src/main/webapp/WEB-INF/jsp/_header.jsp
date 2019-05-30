<%@page import="com.ndanhkhoi.entity.Product"%>
<%@page import="java.util.HashMap"%>
<%@page
	import="org.springframework.security.authentication.AnonymousAuthenticationToken"%>
<%@page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String user = SecurityContextHolder.getContext().getAuthentication().getName();
	String url = request.getContextPath();
%>
<div class="row bg-light text-primary p-2">
	<div class="col-md-4 d-flex flex-row align-items-center">
		<span class="material-icons">call</span>
		<div>+84 77 652 4327</div>
		<span class="material-icons ml-5">mail</span>
		<div>kstore@gmail.com</div>
	</div>
	<div class='col-md-8 d-flex justify-content-end text-center'>
		<%
			if (SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) {
				out.println("<div class='col-md-2'>");
				out.println("<a href='" + url + "/register' class='nav-link'>Đăng ký</a>");
				out.println("</div>");
				out.println("<div class='col-md-2'> ");
				out.println("<a href='" + url + "/login' class='nav-link'>Đăng nhập</a>");
				out.println("</div>");
			} else {
				String profileUrl = new String();
				if (request.isUserInRole("ROLE_CUSTOMER")) {
					profileUrl = url + "/customer-view-profile";
					out.println("<div class='col-md-3'>");
					out.println("<a href='" + url
							+ "/customer-transaction-history' class='nav-link'>Lịch sử giao dịch</a>");
					out.println("</div>");
					out.println("<div class='col-md-2'>");
					int productInCart = session.getAttribute("cart") == null ? 0 
						: ((HashMap) session.getAttribute("cart")).keySet().size();
					out.println("<a href='" + url
							+ "/customer-shopping-cart' class='nav-link'>Giỏ hàng <span class='badge badge-danger'>"
							+ productInCart + "</span></a>");
					out.println("</div>");
				} else if (request.isUserInRole("ROLE_ADMIN")) {
					profileUrl = url + "/admin-profile";
					out.println("<div class='col-md-2'>");
					out.println("<a href='" + url + "/welcome' class='nav-link text-danger'>Dashboard</a>");
					out.println("</div>");
				} else if (request.isUserInRole("ROLE_STAFF"))
					profileUrl = url + "/staff-manager-order";
				out.println("<div class='col-md-4'>");
				out.println("<a href='" + profileUrl + "' class='nav-link'>Chào! <b class='text-danger'>" + user
						+ "</b></a>");
				out.println("</div>");
				out.println("<div class='col-md-2'> ");
				out.println("<a href='" + url + "/logout' class='nav-link'>Đăng xuất</a>");
				out.println("</div>");
			}
		%>
	</div>
</div>

<div id="div-logo">
	<div class="row p-3">
		<!-- Logo -->
		<div class="col-md-2">
			<div class="logo">
				<a href="<c:url value="/" />">KStore</a>
			</div>
		</div>
	</div>
</div>

<div class="navbar navbar-expand-sm bg-white navbar-light row">
	<div class="col-md-8 d-flex">
		<a href="<c:url value="/" />#mi" class="nav-link">Điện thoại Mi</a> <a
			href="<c:url value="/" />#redmi" class="nav-link">Điện thoại
			Redmi</a> <a href="<c:url value="/" />#one" class="nav-link">Android
			One</a> <a href="<c:url value="/" />#pocophone" class="nav-link">Điện
			thoại Pocophone</a>
	</div>
	<div class="col-md-4">
		<form class="form row" action="<c:url value="/" />search-product"
			method="get">
			<input class="form-control col-md-9" name="name" id="name"
				type="text" placeholder="Tìm kiếm sản phẩm" required>
			<div class="col-md-3">
				<button class="btn btn-primary" type="submit">Search</button>
			</div>
		</form>
	</div>
</div>
