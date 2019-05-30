<%@page import="com.ndanhkhoi.entity.Category"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="com.ndanhkhoi.entity.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Product product = (Product) request.getAttribute("product");
%>
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
		<title>Thông tin điện thoại</title>
	</head>
<body>

	<jsp:include page="dashboard-header.jsp"></jsp:include>		
			
	<!--	 This is content page	 -->
		<div class="container-fluid h-100">			
	 		<div class="row h-100">
				
				<jsp:include page="dashbaord-navibar.jsp"></jsp:include>			
				
				<div class="col-md-10 bg-light">
					<div class="container">
						<h4 class="text-primary p-3">Chỉnh sửa thông tin điện thoại</h4>
						<div class="row"> 
							<div class="col-md-6">
								<div class="card mt-3">
									<div class="card-header text-info font-weight-bold">Hình ảnh điện thoại</div>
									<div class="card-body bg-white">
										<form method="post" enctype="multipart/form-data" name="imgPhoneForm" action="../admin-update-product-img">
											<input type="hidden" value="<%=product.getId()%>" name="id" id="id">
											<div class="row">
												<div class="col-md-4">
													<img class="img-thumbnail" src="<c:url value="/product/" /><%=product.getId() + "-img1"%>?t=<%=new Date().toString()%>" alt="img1">
													<div class="custom-file">
								                       	<input type="file" id="img1" class="custom-file-input" name="img1" accept="image/*"><br>
														<label for="img1" class="custom-file-label">Chọn ảnh</label>
							                       	</div>
						                       	</div>
												<div class="col-md-4">
													<img class="img-thumbnail" src="<c:url value="/product/" /><%=product.getId() + "-img2"%>?t=<%=new Date().toString()%>" alt="img2">
													<div class="custom-file">
								                       	<input type="file" id="img2" class="custom-file-input" name="img2" accept="image/*"><br>
														<label for="img2" class="custom-file-label">Chọn ảnh</label>
							                       	</div>
						                       	</div>
												<div class="col-md-4">
													<img class="img-thumbnail" src="<c:url value="/product/" /><%=product.getId() + "-img3"%>?t=<%=new Date().toString()%>" alt="img3">
													<div class="custom-file">
								                       	<input type="file" id="img3" class="custom-file-input" name="img3" accept="image/*"><br>
														<label for="img3" class="custom-file-label">Chọn ảnh</label>
							                       	</div>
						                       	</div>
					                       	</div>
											<center class="mt-3">
												<button type="submit" class="btn btn-primary">
													Cập nhật ảnh
												</button>
											</center>
										</form> 
									</div>
								</div>
								<div class="card mt-3">
									<div class="card-header text-info font-weight-bold mb-3">Nhập thêm điện thoại (Hiện tại: <%=product.getNumber()%>)</div>
									<div class="card-body">
										<form class="d-flex justify-content-center" method="post" action="../admin-import-phone">
											<input type="hidden" value="<%=product.getId()%>" name="id" id="id">
											<input type="number" class="form-control custom-input col-md-5 ml-3" id="number" name="number" required>
											<button type="submit" class="btn btn-primary ml-3">Xác nhận</button>
										</form>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="card mt-3">
									<div class="card-header text-info font-weight-bold mb-3">Thông tin điện thoại</div>
									<div class="card-body">
										<form method="post" action="../admin-edit-phone">
										    <input type="hidden" class="form-control col-md-7" id="ID" name="ID" value="<%=product.getId()%>" >
											  <div class="form-group row">
											  	<div class="col-md-1"></div>
											    <label for="NAME" class="col-md-3 p-2">Tên điện thoại: </label>
											    <input type="text" class="form-control col-md-7" id="NAME" name="NAME" required value="<%=product.getName()%>" >
											  </div>
											  <div class="form-group row">
											  	<div class="col-md-1"></div>
											    <label for="CATEGORYID" class="col-md-3 p-2">Category: </label>
											    <select class="form-control col-md-7 custom-select" id="CATEGORYID" name="CATEGORYID">
											    	<%
												    	List<Category> categoryList = (List) request.getAttribute("categoryList");
											    		for (Category c: categoryList){
											    			out.print("<option value = '" + c.getId() + "' ");
											    			if (c.getId() == product.getCategory().getId())
											    				out.println("selected");
											    			out.print(" >");
											    			out.print(c.getName());
											    			out.println("</option>");
											    		}
											    	%>
											    </select>											  
											  </div>
											  <div class="form-group row">
											  	<div class="col-md-1"></div>
											    <label for="PRICE" class="col-md-3 p-2">Giá: </label>
											    <input type="number" class="form-control col-md-7" id="PRICE" name="PRICE" required value="<%=product.getPrice()%>" > 
											  </div>
											  <div class="form-group row">
											  	<div class="col-md-1"></div>
											    <label for="OS" class="col-md-3 p-2">Hệ điều hành: </label>
											    <input type="text" class="form-control col-md-7" id="OS" name="OS" required value="<%=product.getOs()%>" >
											  </div>
											  <div class="form-group row">
											  	<div class="col-md-1"></div>
											    <label for="SCREEN" class="col-md-3 p-2">Màn hình: </label>
											    <input type="text" class="form-control col-md-7" id="SCREEN" name="SCREEN" required value="<%=product.getScreen()%>" >
											  </div>
											  <div class="form-group row">
											  	<div class="col-md-1"></div>
											    <label for="FRONTCAMERA" class="col-md-3 p-2">Camera trước: </label>
											    <input type="text" class="form-control col-md-7" id="FRONTCAMERA" name="FRONTCAMERA" required value="<%=product.getFrontCamera()%>" >
											  </div>
											  <div class="form-group row">
											  	<div class="col-md-1"></div>
											    <label for="BACKCAMERA" class="col-md-3 p-2">Camera Sau: </label>
											    <input type="text" class="form-control col-md-7" id="BACKCAMERA" name="BACKCAMERA" required value="<%=product.getBackCamera()%>" >
											  </div>
											  <div class="form-group row">
											  	<div class="col-md-1"></div>
											    <label for="CPU" class="col-md-3 p-2">CPU: </label>
											    <input type="text" class="form-control col-md-7" id="CPU" name="CPU" required value="<%=product.getCpu()%>" >
											  </div>
											  <div class="form-group row">
											  	<div class="col-md-1"></div>
											    <label for="RAM" class="col-md-3 p-2">RAM: </label>
											    <input type="number" class="form-control col-md-7" id="RAM" name="RAM" required value="<%=product.getRam()%>" >
											  </div>
											  <div class="form-group row">
											  	<div class="col-md-1"></div>
											    <label for="ROM" class="col-md-3 p-2">Bộ nhớ trong: </label>
											    <input type="number" class="form-control col-md-7" id="ROM" name="ROM" required value="<%=product.getRom()%>" >
											  </div>
											  <div class="form-group row">
											  	<div class="col-md-1"></div>
											    <label for="BATTERY" class="col-md-3 p-2">Pin: </label>
											    <input type="text" class="form-control col-md-7" id="BATTERY" name="BATTERY" required value="<%=product.getBattery()%>" >
											  </div>
											  <div class="form-group row">
											  	<div class="col-md-1"></div>
											    <label for="SECURITY" class="col-md-3 p-2">Bảo mật: </label>
											    <input type="text" class="form-control col-md-7" id="SECURITY" name="SECURITY" required value="<%=product.getSecurity()%>" >
											  </div>
											  <div class="form-group row">
											  	<div class="col-md-1"></div>
											    <label for="COLOR" class="col-md-3 p-2">Màu sắc: </label>
											    <input type="text" class="form-control col-md-7" id="COLOR" name="COLOR" required value="<%=product.getColor()%>" >
											  </div>
											  <div class="form-group row">
											  	<div class="col-md-1"></div>
											    <label for="DESCRIPTION" class="col-md-3 p-2">Mô tả: </label>
											    <textarea class="form-control col-md-7" id="DESCRIPTION" name="DESCRIPTION" required ><%=product.getDescription()%></textarea>
											  </div>
											  <div class="form-group row">
											  	<div class="col-md-1"></div>
											    <div class="col-md-3 p-2"></div>
											  	<button type="submit" class="btn btn-primary">Xác nhận</button>
											  </div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>		
		</div>
</body>
</html>