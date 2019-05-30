<%@page import="com.ndanhkhoi.entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<c:url value="/resources/css/main_styles.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script
	src="<c:url value="/resources/bootstrap/js/jquery-3.3.1.min.js" />"></script>
<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
<title>Danh sách điện thoại</title>
</head>
<body>
	<jsp:include page="dashboard-header.jsp"></jsp:include>
	<div class="container-fluid h-100">
		<div class="row h-100">
			<jsp:include page="dashbaord-navibar.jsp"></jsp:include>
			<div class="col-md-10 bg-light">
				<h4 class="text-danger m-3 text-center">Danh sách điện thoại</h4>
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
							String viewPhoneUrl = request.getContextPath() + "/"
									+ (request.isUserInRole("ROLE_ADMIN") ? "admin-view-phone/" : "about-phone/");
						%>
						<div class='my-table-scrollbar'>
							<table class='table-scroll table table-striped'>
								<thead class='bg-dark'>
									<tr class='text-white'>
										<th>Tên điện thoại </th>
										<th>Số lượng còn lại </th>
										<th>Giá bán </th>
										<th></th>
										<%
											if (request.isUserInRole("ROLE_ADMIN")) {
										%>
										<th></th>
										<%
											}
										%>
									</tr>
								</thead>
								<tbody id="myTable">
									<%
										List<Product> products = (List) request.getAttribute("products");
										for (Product p : products) {
									%>
									<tr>
										<td class='font-weight-bold'><%=p.getName()%></td>
										<td><%=p.getNumber()%></td>
										<td class='text-danger'><%=p.getPriceString()%></td>
										<td><a href='<%=viewPhoneUrl + p.getId()%>'><i class="material-icons">info</i></a></td>
										<%
											if (request.isUserInRole("ROLE_ADMIN")) {
										%>
										<td><button type='button' class='btn btn-link'
												data-toggle='modal' data-target='#delete-confirm-modal'
												onclick="setIdProductToModal(<%=p.getId()%>, '<%=p.getName()%>')">
												<i class="material-icons">delete</i>
											</button></td>
										<%
											} 
										%>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
						</div>
						<%
							if (request.isUserInRole("ROLE_ADMIN")) {
						%>
						<div class='text-center m-2'>
							<button type='button' class='btn btn-primary' data-toggle='modal'
								data-target='#add-phone-modal'>Thêm điện thoại</button>
						</div>
						<jsp:include page="add-phone.jsp"></jsp:include>
						<jsp:include page="delete-phone-confirm.jsp"></jsp:include>
						<script src="<c:url value="/resources/js/admin.js" />"></script>
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