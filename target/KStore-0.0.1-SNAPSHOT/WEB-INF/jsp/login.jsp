<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="<c:url value="/resources/css/main_styles.css" />">
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />">
		<script src="<c:url value="/resources/bootstrap/js/jquery-3.3.1.min.js" />"></script>
		<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
		<title>Đăng nhập</title>
	</head>
	<body>

		<div id = "div-logo">
			<div class="row">
			<!-- Logo -->
					<div class="col-lg-2">
							<div class="logo"><a href="<c:url value="/" />">KStore</a></div>
					</div>
			</div>
		</div>	
		
		<div class="navbar navbar-expand-sm bg-light d-flex flex-row-reverse">
			<a href="register">Đăng ký</a>		  
		</div>    
	
	 <div class="cotainer m-5">
	        <div class="row justify-content-center">
	            <div class="col-md-5">
	                <div class="card">
	                    <div class="card-header">Đăng nhập</div>
	                    <div class="card-body">
	                        <form action="authenticateUser" method='POST'>
	                            
	                            <div class="form-group row">
	                                <label for="username" class="col-md-4 col-form-label text-md-right">Tên đăng nhập</label>
	                                <div class="col-md-6">
	                                    <input type="text" id="username" class="form-control" name="username" required autofocus>
	                                </div>
	                            </div>
	
	                            <div class="form-group row">
	                                <label for="password" class="col-md-4 col-form-label text-md-right">Mật khẩu</label>
	                                <div class="col-md-6">
	                                    <input type="password" id="password" class="form-control" name="password" required>
	                                </div>
	                            </div>
	
	                            <div class="col-md-6 offset-md-4">
	    							<button type="submit" class="btn btn-primary">Đăng Nhập</button>
	                            </div>
	                            <div class="col-md-6 offset-md-4 text-danger">
	                            	<br>
	    							<%
	    								String mess = request.getAttribute("mess").toString();
	                                	out.println(mess);
	    							%>
	                            </div>
	                      </form>
	                  </div>
	                </div>
	           </div>
	       </div>
	</div>

	<jsp:include page="_footer.jsp"></jsp:include>

	</body>
</html>