<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id='contentPath' class='d-none'><%=request.getContextPath()%></div>
<div class="modal" id="add-modal">
    <div class="modal-dialog modal-lg">
	      <div class="modal-content">
	      
		        <div class="modal-header">
					<h4 class="text-danger">Thêm nhân viên mới</h4>      
		            <button type="button" class="close" data-dismiss="modal">&times;</button>
		         </div>
		         
				<div class="d-flex justify-content-center m-5">
                    <div class="card col-md-10">
                        <div class="card-header font-weight-bold">Thông tin nhân viên</div>
                        <div class="card-body">
                            <form id = "my-form" name="my-form" action="<%=request.getContextPath()%>/admin-add-staff" method="POST" enctype="multipart/form-data"  onsubmit="return validate()">
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
                                    <label for="province" class="col-md-4 col-form-label text-md-right">Thành phố / Tỉnh</label>
                                    <div class="col-md-6">
                                        <select id="province" class="form-control custom-select" name="province" onchange = "provinceChoose(this.value)">
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="district" class="col-md-4 col-form-label text-md-right">Quận / Huyện</label>
                                    <div class="col-md-6">
                                        <select id="district" class="form-control custom-select" name="district"  onchange = "districtChoose(this.value)">
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="ward" class="col-md-4 col-form-label text-md-right">Xã / Phường</label>
                                    <div class="col-md-6">
                                        <select id="ward" class="form-control custom-select" name="ward">
                                        </select>
                                    </div>
                                </div>
                                   <div class="col-md-6 offset-md-4">
                                       <button type="submit" class="btn btn-primary">Thêm nhân viên</button>                                     
                                   </div>
                            </form>
                        </div>
                    </div>
				</div>
		</div>
	</div>
</div>