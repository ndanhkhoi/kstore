<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="<c:url value="/resources/css/main_styles.css" />">
		<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />">
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<script src="<c:url value="/resources/bootstrap/js/jquery-3.3.1.min.js" />"></script>
		<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
		<script src="<c:url value="/resources/js/admin.js" />"></script>
		<title>Xác nhận xóa</title>
	</head>
<body>
	<%
		String type = request.getAttribute("type").toString();
		long id =  Long.parseLong( request.getAttribute("id").toString() );
	%>
	<div id = "div-logo">
		<div class="row">
			<div class="col-lg-2">
					<div class="logo"><a href="#">KStore</a></div>
			</div>
		</div>
	</div>
	<div class="navbar navbar-expand-sm bg-light d-flex flex-row-reverse">
		<a class="btn btn-primary" href="<c:url value="/admin-manager/"/><%out.print(type);%>">Quay lại</a>
	</div>	
	<center>
		<div class="row justify-content-center m-5">
			<div class=" col-md-3">
			<div class="card justify-content-center">
				<div class="card-header">
					Xác nhận xóa <%out.print(type + " ");%> <b id='id'><%=id%></b> ?
				</div>
				<div class="card-body">
		            <div class="form-group"> 
		              <input type="password" class="form-control" id="password">
		 		   </div>
		            <div class="form-group">
		              <button type="button" class="btn btn-primary" onclick="deleteEmployee('<c:url value="/" />', '<%out.print(type);%>')">Xác nhận</button>
		            </div>
		        </div>
	        </div>
	        </div>
	    </div>
	</center>
</body>
</html>