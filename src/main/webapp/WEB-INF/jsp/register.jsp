<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="<c:url value="/resources/css/main_styles.css" />">
		<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />">
		<script src="<c:url value="/resources/bootstrap/js/jquery-3.3.1.min.js" />"></script>
		<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>

	    <!-- Fonts -->
	    <link rel="dns-prefetch" href="https://fonts.gstatic.com">
	    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600" rel="stylesheet" type="text/css">
	    <link rel="icon" href="Favicon.png">
	
		<title>Đăng ký</title>
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
			<a href="login">Đăng nhập</a>		  
		</div>                			
		<div id='contentPath' class='d-none'><%=request.getContextPath()%></div>
	    <div class="cotainer m-5">
	        <div class="row justify-content-center">
	            <div class="col-md-7">
	                    <div class="card">
	                        <div class="card-header">Đăng ký</div>
	                        <div class="card-body">
	                            <form id = "my-form" name="my-form" action="register" method="POST" enctype="multipart/form-data"  onsubmit="return validate()">
	                                <div class="form-group row">
	                                    <label for="HOTEN" class="col-md-4 col-form-label text-md-right">Họ và tên</label>
	                                    <div class="col-md-6">
	                                        <input type="text" id="HOTEN" class="form-control" name="HOTEN">
	                                        <div id = "namecheck"></div> 
	                                    </div>
	                                </div>
	
	                                <div class="form-group row">
	                                    <label for="USERNAME" class="col-md-4 col-form-label text-md-right">Tên đăng nhập</label>
	                                    <div class="col-md-6">
	                                        <input type="text" id="USERNAME" class="form-control" name="USERNAME">
	                                        <div id = "usercheck"></div> 
	                                    </div>
	                                </div>
	
	                                <div class="form-group row">
	                                    <label for="PASSWORD" class="col-md-4 col-form-label text-md-right">Mật khẩu</label>
	                                    <div class="col-md-6">
	                                        <input type="password" id="PASSWORD" class="form-control" name="PASSWORD">
	                                        <div id = "passcheck"></div> 
	                                    </div>
	                                </div>
	
	                                <div class="form-group row">
	                                    <label for="PASSWORD2" class="col-md-4 col-form-label text-md-right">Nhập lại mật khẩu</label>
	                                    <div class="col-md-6">
	                                        <input type="password" id="PASSWORD2" class="form-control" name="PASSWORD2">
	                                        <div id = "passcheck2"></div> 
	                                    </div>
	                                </div>
	                                <div class="form-group row">
	                                	<div class="col-md-4 col-form-label text-md-right">Ảnh đại diện</div>
	                                    <div class="custom-file col-md-6">
											<input type="file" id="AVT" class="custom-file-input" name="AVT" accept="image/*">	
    	                                    <label for="AVT" class="custom-file-label">Chọn ảnh</label>
	                                        <div id = "avtcheck"></div> 
	                                    </div>
	                                </div>
	                                <div class="form-group row">
	                                    <label for="NGAYSINH" class="col-md-4 col-form-label text-md-right">Ngày sinh</label>
	                                    <div class="col-md-6">
	                                        <input type="date" id="NGAYSINH" class="form-control" name="NGAYSINH">
	                                        <div id = "daycheck"></div> 
	                                    </div>
	                                </div>
	
	                                <div class="form-group row">
	                                    <label for="GIOITINH" class="col-md-4 col-form-label text-md-right">Giới tính</label>
	                                    <div class="col-md-6">
	                                        <select id="GIOITINH" class="form-control custom-select" name="GIOITINH">
	                                        	<option value = "Nam">Nam</option>
	                                        	<option value = "Nữ">Nữ</option>
	                                        </select>
	                                    </div>
	                                </div>
	
	                                <div class="form-group row">
	                                    <label for="SDT" class="col-md-4 col-form-label text-md-right">Số điện thoại</label>
	                                    <div class="col-md-6">
	                                        <input type="text" id="SDT" class="form-control" name="SDT">
	                                        <div id = "telcheck"></div> 
	                                    </div>
	                                </div>
	
	                                <div class="form-group row">
	                                    <label for="CMND" class="col-md-4 col-form-label text-md-right">Số CMND</label>
	                                    <div class="col-md-6">
	                                        <input type="text" id="CMND" class="form-control" name="CMND">
	                                        <div id = "idcheck"></div> 
	                                    </div>
	                                </div>
	
	                                <div class="form-group row">
	                                    <label for="province" class="col-md-4 col-form-label text-md-right">Địa chỉ</label>
	                                    <div class="col-md-6">
	                                        <select id="province" class="form-control custom-select" name="province" onchange = "provinceChoose(this.value)">
	                                        </select>
	                                    </div>
	                                </div>
	
	                                <div class="form-group row">
	                                	<div class="col-md-4"></div>
	                                    <div class="col-md-6">
	                                        <select id="district" class="form-control custom-select" name="district"  onchange = "districtChoose(this.value)">
	                                        </select>
	                                    </div>
	                                </div>
	
	                                <div class="form-group row">
	                                	<div class="col-md-4"></div>
	                                    <div class="col-md-6">
	                                        <select id="ward" class="form-control custom-select" name="ward">
	                                        </select>
	                                    </div>
	                                </div>
	
	                                    <div class="col-md-6 offset-md-4">
	                                        <button type="submit" class="btn btn-primary">
	                                        Đăng ký
	                                        </button>                                     
	                                    </div>
	                            </form>
	                        </div>                      
	                    </div>
	            </div>
	        </div>
	    </div>
	    <script src="<c:url value="/resources/js/register.js" />"></script>
		<jsp:include page="_footer.jsp"></jsp:include>
	</body>	
</html>