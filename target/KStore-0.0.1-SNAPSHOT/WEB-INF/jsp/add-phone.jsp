<%@page import="com.ndanhkhoi.entity.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="modal" id="add-phone-modal">
    <div class="modal-dialog modal-lg">
	      <div class="modal-content">    
	      	<div class="modal-header">
				<h4 class="text-danger">Thêm điện thoại mới</h4>      
	            <button type="button" class="close" data-dismiss="modal">&times;</button>
		    </div>
			<div class="d-flex justify-content-center m-5">
				<div class="card col-md-10">
					<div class="card-header font-weight-bold mb-3">Thông tin điện thoại</div>
					<div class="card-body">
						<form method="post" action="admin-add-phone" enctype="multipart/form-data">
							  <div class="form-group d-flex justify-content-center">
							    <label for="NAME" class="col-md-3 p-2">Tên điện thoại: </label>
							    <input type="text" class="form-control col-md-7" id="NAME" name="NAME" required>
							  </div>
							   <div class="form-group d-flex justify-content-center">
							   <div class="col-md-3 p-2">Hình ảnh: </div>
								<div class="custom-file col-md-7">
			                       	<input type="file" id="img2" class="custom-file-input" name="img1" accept="image/*"><br>
									<label for="img2" class="custom-file-label">Ảnh 1</label>
		                       	</div>
	                       	  </div>
							   <div class="form-group d-flex justify-content-center">
							   <div class="col-md-3 p-2"></div>
								<div class="custom-file col-md-7">
			                       	<input type="file" id="img2" class="custom-file-input" name="img2" accept="image/*"><br>
									<label for="img2" class="custom-file-label">Ảnh 2</label>
		                       	</div>
	                       	  </div>
							   <div class="form-group d-flex justify-content-center">
							   <div class="col-md-3 p-2"></div>
								<div class="custom-file col-md-7">
			                       	<input type="file" id="img2" class="custom-file-input" name="img3" accept="image/*"><br>
									<label for="img2" class="custom-file-label">Ảnh 3</label>
		                       	</div>
	                       	  </div>
							  <div class="form-group d-flex justify-content-center">
							  	
							    <label for="CATEGORYID" class="col-md-3 p-2">Danh mục: </label>
							    <select class="form-control col-md-7 custom-select" id="CATEGORYID" name="CATEGORYID">
							    	<%
										List<Category> categoryList = (List) request.getAttribute("categories");
							    		for (Category c: categoryList){
							    			out.print("<option value = '" + c.getId()  + "'>");
							    			out.print(c.getName());
							    			out.println("</option>");
							    		}
							    	%>
							    </select>
							  </div>											  
							  <div class="form-group d-flex justify-content-center">
							  	
							    <label for="PRICE" class="col-md-3 p-2">Giá: </label>
							    <input type="number" class="form-control col-md-7" id="PRICE" name="PRICE" required>
							  </div>
							  <div class="form-group d-flex justify-content-center">
							  	
							    <label for="OS" class="col-md-3 p-2">Hệ điều hành: </label>
							    <input type="text" class="form-control col-md-7" id="OS" name="OS" required>
							  </div>
							  <div class="form-group d-flex justify-content-center">
							    <label for="SCREEN" class="col-md-3 p-2">Màn hình: </label>
							    <input type="text" class="form-control col-md-7" id="SCREEN" name="SCREEN" required>
							  </div>
							  <div class="form-group d-flex justify-content-center">
							    <label for="FRONTCAMERA" class="col-md-3 p-2">Camera trước: </label>
							    <input type="text" class="form-control col-md-7" id="FRONTCAMERA" name="FRONTCAMERA" required>
							  </div>
							  <div class="form-group d-flex justify-content-center">
							    <label for="BACKCAMERA" class="col-md-3 p-2">Camera Sau: </label>
							    <input type="text" class="form-control col-md-7" id="BACKCAMERA" name="BACKCAMERA" required>
							  </div>
							  <div class="form-group d-flex justify-content-center">
							    <label for="CPU" class="col-md-3 p-2">CPU: </label>
							    <input type="text" class="form-control col-md-7" id="CPU" name="CPU" required>
							  </div>
							  <div class="form-group d-flex justify-content-center">
							    <label for="RAM" class="col-md-3 p-2">RAM: </label>
							    <input type="number" class="form-control col-md-7" id="RAM" name="RAM" required>
							  </div>
							  <div class="form-group d-flex justify-content-center">
							    <label for="ROM" class="col-md-3 p-2">Bộ nhớ trong: </label>
							    <input type="number" class="form-control col-md-7" id="ROM" name="ROM" required>
							  </div>
							  <div class="form-group d-flex justify-content-center">
							    <label for="BATTERY" class="col-md-3 p-2">Pin: </label>
							    <input type="text" class="form-control col-md-7" id="BATTERY" name="BATTERY" required>
							  </div>
							  <div class="form-group d-flex justify-content-center">
							    <label for="SECURITY" class="col-md-3 p-2">Bảo mật: </label>
							    <input type="text" class="form-control col-md-7" id="SECURITY" name="SECURITY" required>
							  </div>
							  <div class="form-group d-flex justify-content-center">
							    <label for="COLOR" class="col-md-3 p-2">Màu sắc: </label>
							    <input type="text" class="form-control col-md-7" id="COLOR" name="COLOR" required>
							  </div>
							  <div class="form-group d-flex justify-content-center">
							    <label for="DESCRIPTION" class="col-md-3 p-2">Mô tả: </label>
							    <textarea class="form-control col-md-7" id="DESCRIPTION" name="DESCRIPTION" required></textarea>
							  </div>
							  <div class="form-group d-flex justify-content-center">
							    <div class="col-md-3 p-2"></div>
							  	<button type="submit" class="btn btn-primary">Thêm</button>
							  </div>
						</form>
					</div>
				</div>
			</div>					
		</div>
	</div>
</div>