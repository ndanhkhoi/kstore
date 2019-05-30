<%@page import="com.ndanhkhoi.entity.Account"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String type = request.getAttribute("type").toString();
	String title = new String();
	if (type.equalsIgnoreCase("staff")) {
		title = "nhân viên";
	} else if (type.equalsIgnoreCase("customer")) {
		title = "khách hàng";
	}
	List<Account> listAccount = (List<Account>) request.getAttribute("listAccount");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<script src="<c:url value="/resources/js/admin.js" />"></script>
<title>Quản lý <%=title%></title>
</head>
<body>

	<jsp:include page="dashboard-header.jsp"></jsp:include>

	<!--	 This is content page	 -->
	<div class="container-fluid h-100">
		<div class="row h-100">
			<jsp:include page="dashbaord-navibar.jsp"></jsp:include>
			<div class="col-md-10 bg-light">
				<div class="container">
					<h4 class="text-danger m-3 text-center">
						Danh sách <%=title%>
					</h4>
					<div class="d-flex justify-content-center">
          			  <div class="col-md-5 pt-4">
           			     <input class="form-control" id="txtTimKiem" type="text" placeholder="Nhập thông tin tìm kiếm" />
           				     <p id="count" class="text-center pt-3">Số kết quả: </p>
          			  </div>
      				</div>
					<div class="d-flex justify-content-center mb-5">
						<div class="card col-md-11 p-3">
							<table class="table-scroll table table-hover table-striped" id="table-staff">
								<thead class='bg-dark'>
									<tr class="text-white">
										<th>ID </th>
										<th>Username </th>
										<th>Họ và tên </th>
										<th>Số điện thoại </th>
										<th colspan="2"></th>
									</tr>
								</thead>
								<tbody id="myTable">
									<%
										for (Account account : listAccount) {
									%>
									<tr>
										<td><%=account.getProfile().getId()%></td>
										<td class='font-weight-bold'><%=account.getUsername()%></td>
										<td><%=account.getProfile().getFullname()%></td>
										<td><%=account.getProfile().getTel()%></td>
										<td>
											<a href='../admin-view/<%=type%>/<%=account.getProfile().getId()%>'>
												<i class="material-icons">info</i>
											</a>
										</td>
										<td>
											<button type='button' class='btn btn-link'
												data-toggle='modal' data-target='#delete-confirm-modal'
												onclick="setIdProfileToModal(<%=account.getProfile().getId()%>, '<%=account.getProfile().getFullname()%>')">
												<i class="material-icons">delete</i>
											</button>
										</td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
							<%
								if (type.equalsIgnoreCase("staff")) {
							%>
							<div class='text-center m-2'>
								<button type='button' class='btn btn-primary'
									data-toggle='modal' data-target='#add-modal'>Thêm nhân
									viên</button>
							</div>
							<jsp:include page="add-staff.jsp"></jsp:include>
							<script src="<c:url value="/resources/js/register.js" />"></script>
							<%
								}
							%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="delete-profile-confirm.jsp"></jsp:include>
	<script src="<c:url value="/resources/js/filtertable.js" />"></script>
</body>
</html>