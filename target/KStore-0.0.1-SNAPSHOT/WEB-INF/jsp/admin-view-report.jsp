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
 		<title>Báo cáo</title>
	</head>
<body>

	<jsp:include page="dashboard-header.jsp"></jsp:include>
		
<!-- 	This is content page -->		
	<div class="container-fluid h-100">
	 		<div class="row h-100">

	 			<!-- This is column navi bar -->
				<jsp:include page="dashbaord-navibar.jsp"></jsp:include>
				
				<div class="col-md-10 bg-light">
					<h4 class="text-danger m-3 text-center">Báo cáo tổng hợp</h4>      
					<h6 class="m-3 text-primary text-center">
					<%
						String fromDayToDay = (String) request.getAttribute("fromDayToDay");
						if (fromDayToDay == null) fromDayToDay = "Chọn khoảng thời gian xem báo cáo";
						out.println(fromDayToDay);
					%>
					</h6>
					<form action="<c:url value='/admin-view-report' />" method="post" class="d-flex justify-content-center">
						<label for="start-day" class="col-form-label">Từ ngày</label>
						<input type="date" class="form-control col-md-2 ml-3" name="start-day" id="start-day" required>
						<label for="end-day" class="col-form-label ml-3">Đến</label>
						<input type="date" class="form-control col-md-2  ml-3" name="end-day" id="end-day" required> 
						<button class="btn btn-primary ml-3" type="submit">Xem</button>
					</form>							
					
					<div class="d-flex justify-content-center m-5">
						<div class="card col-md-11 p-3">
							<div class="row">
								<jsp:include page="turnover-report.jsp"></jsp:include>
								<jsp:include page="revenue-report.jsp"></jsp:include>
								<jsp:include page="account-report.jsp"></jsp:include>
							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>
</body>
</html>