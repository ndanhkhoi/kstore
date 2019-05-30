<%@page import="com.ndanhkhoi.entity.Log"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<c:url value="/resources/css/main_styles.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<script
	src="<c:url value="/resources/bootstrap/js/jquery-3.3.1.min.js" />"></script>
<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
<title>Nhật ký hệ thống</title>
</head>
<body>

	<jsp:include page="dashboard-header.jsp"></jsp:include>

	<!-- 	This is content page -->
	<div class="container-fluid h-100">
		<div class="row h-100">

			<!-- This is column navi bar -->
			<jsp:include page="dashbaord-navibar.jsp"></jsp:include>

			<div class="col-md-10 bg-light">
				<h4 class="text-danger m-3 text-center">Nhật ký hệ thống</h4>
				<h6 class="m-3 text-primary text-center">
					<%
						String fromDayToDay = (String) request.getAttribute("fromDayToDay");
						out.println(fromDayToDay);
					%>
				</h6>
				<form action="<c:url value='/admin-view-log' />" method="post"
					class="d-flex justify-content-center">
					<label for="start-day" class="col-form-label">Từ ngày</label> <input
						type="date" class="form-control col-md-2 ml-3" name="start-day"
						id="start-day" required> <label for="end-day"
						class="col-form-label ml-3">Đến</label> <input type="date"
						class="form-control col-md-2  ml-3" name="end-day" id="end-day"
						required>
					<button class="btn btn-primary ml-3" type="submit">Xem</button>
				</form>
				<div class="d-flex justify-content-center">
					<div class="col-md-5 pt-4">
						<input class="form-control" id="txtTimKiem" type="text"
							placeholder="Nhập thông tin tìm kiếm" />
						<p id="count" class="text-center pt-3">Số kết quả:</p>
					</div>
				</div>
				<div class="d-flex justify-content-center mb-5">
					<div class="card col-md-10 p-3">
						<%
							List<Log> logs = (List) request.getAttribute("logs");
							if (!logs.isEmpty()) {
						%>
						<table class='table-scroll table table-striped table-hover'>
							<thead class="bg-dark">
								<tr class='text-white'>
									<th>Thời gian</th>
									<th>Tài khoản</th>
									<th>Hành động</th>
								</tr>
							</thead>
							<tbody id="myTable">
								<%
									for (Log l : logs) {
								%>
								<tr>
									<td><%=l.getTime()%></td>
									<td class='text-danger'><%=l.getAccount().getUsername()%></td>
									<td><%=l.getAction()%></td>
								</tr>
								<%
									}
								%>
							</tbody>
						</table>
						<%
							} else {
						%>
						<h5 class='p-5 text-center'>Không tìm thấy nhật ký</h5>
						<%
							}
						%>
					</div>
				</div>

			</div>
		</div>
	</div>
	<script src="<c:url value="/resources/js/filtertable.js" />"></script>
</body>
</html>