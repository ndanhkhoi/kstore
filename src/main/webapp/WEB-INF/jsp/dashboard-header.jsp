<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!-- 	This is header -->
<div id = "div-logo">
	<div class="d-flex justify-content-between">
	<!-- Logo -->
		<div class="col-md-2">
			<div class="logo"><a href="<%=request.getContextPath()%>">KStore</a></div>
		</div>
		<div class='col-md-1'>
				<img src='<%=request.getContextPath()%>/avt/<%=request.getUserPrincipal().getName()%>' class='avt-dashboard mx-auto'>
				<h6 class='text-center text-success'><%=request.getUserPrincipal().getName()%></h6>
		</div>
	</div>
</div>