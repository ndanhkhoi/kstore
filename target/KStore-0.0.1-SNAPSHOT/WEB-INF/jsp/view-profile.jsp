<%@page import="java.util.Date"%>
<%@page import="com.ndanhkhoi.entity.Profile"%>
<%@page import="com.ndanhkhoi.entity.Province"%>
<%@page import="com.ndanhkhoi.entity.Account"%>
<%@page import="java.util.List"%><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
<script src="<c:url value="/resources/js/viewDetail.js" />"></script>
<%
	Account account = (Account) request.getAttribute("account");
	Profile profile = account.getProfile();
	String fullname = profile.getFullname();
	String username = profile.getAccount().getUsername();
	long id = profile.getId();
	String gender = profile.getGender();
	String birth = profile.getBirthday();
	String joindate = profile.getJoindate();
	String tel = profile.getTel();
	String idcard = profile.getIdcardNumber();
	String ward = profile.getWard().getName();
	String district =  profile.getWard().getDistrict().getName();
	String province = profile.getWard().getDistrict().getProvince().getName();	
	int role = (Integer) request.getAttribute("role");
	String type = request.getAttribute("type").toString();
	String editAction = new String();
    String resetPassAction = new String();
    String updateAvtAction = new String();
	switch (role){
		case 1: editAction = "admin-edit";
				resetPassAction = "admin-reset-password";
				updateAvtAction = "admin-update-avt";
				break;
		case 3: editAction = "customer-edit-profile"; 
				resetPassAction = "customer-reset-password";
				updateAvtAction = "customer-update-avt";
				break;
	}
%>								
			
<div class="col-md-10 bg-light">
	<h4 class="text-danger text-center p-3">Chi tiết tài khoản</h4>      
	<div class="row"> 												
		
	<!-- This is infomation profile -->
		<div class="col-md-7">
			<div class="card bg-white m-3">	
				<div class="card-body">
						<h4 class="mt-2 mb-5 text-info">Thông tin cá nhân</h4>
                           <form name = "infoForm" id = "infoForm" method="post" action="<c:url value="/" /><%=editAction%>">				                            		
 		                           <input type="hidden" id="id" class="form-control" name="id" value="<%=id%>">
	                               <div class="form-group row">
                                   <label for="fullname" class="col-md-3 col-form-label text-primary">Họ và tên</label>
                                   <div class="col-md-7">
                                       <input type="text" id="fullname" class="form-control" name="fullname" value="<%=fullname%>">
                                   </div>
                             	  </div>
	                               <div class="form-group row">
                                   <label for="fullname" class="col-md-3 col-form-label text-primary">Loại tài khoản</label>
                                   <div class="col-md-7">
                                       <input type="text" id="type" class="form-control bg-white" readonly name="type" value="<%=account.getRoles().getName()%>">
                                   </div>
                             	  </div>                              	  
                               <div class="form-group row">
                                   <label for="gender" class="col-md-3 col-form-label text-primary">Giới tính</label>
                                   <div class="col-md-7">
                                       <select id="gender" class="form-control custom-select" name="gender">
                                       		<option value="<%=gender%>" ><%=gender%></option>
                                       		<option value="<%=gender.equalsIgnoreCase("Nam") ? "Nữ" : "Nam"%>" ><%=gender.equalsIgnoreCase("Nam") ? "Nữ" : "Nam"%></option>
                                       </select>
                                   </div>
                               </div>				
                               <div class="form-group row">
                                   <label for="birth" class="col-md-3 col-form-label text-primary">Ngày sinh</label>
                                   <div class="col-md-7">
                                       <input type="date" id="birth" class="form-control" name="birth" value="<%=birth%>">
                                   </div>
                               </div>		 
                               <div class="form-group row">
                                   <label for="tel" class="col-md-3 col-form-label text-primary">SĐT</label>
                                   <div class="col-md-7">
                                       <input type="text" id="tel" class="form-control" name="tel" value="<%=tel%>">
                               		</div>             
                               	</div>        
                    		   <div class="form-group row">
                                   <label for="idcard" class="col-md-3 col-form-label text-primary">CMND</label>
                                   <div class="col-md-7">
                                       <input type="text" id="idcard" class="form-control" name="idcard" value="<%=idcard%>">
			                               		</div>             
			                               	</div>   
                               <div class="form-group row">
                                    <label for="province" class="col-md-3 col-form-label text-primary">Địa chỉ</label>
                                    <div class="col-md-7">
                                        <select id="province" class="form-control custom-select" name="province" onchange = "provinceChoose(this.value)">
                                        <%
                                        List<Province> provinceList = (List<Province>) request.getAttribute("provinceList");
                                    	for (Province p : provinceList)
                                    	{
                                        	out.print("<option value = '" + p.getId() + "'");
                                        	if (p.getId() == profile.getWard().getDistrict().getProvince().getId())
                                        		out.print(" selected ");
                                        	out.print(">");
                                    		out.println(p.getName());
	                                        out.println("</option>");
                                    	}
                                        %>
                                        </select>
                                    </div>
                                </div>	
                               <div class="form-group row">
                                	<div class="col-md-3"></div>
                                    <div class="col-md-7">
                                        <select id="district" class="form-control custom-select" name="district"  onchange = "districtChoose(this.value)">
                                        </select>
                                    </div>
                                </div>
                               <div class="form-group row">
                                	<div class="col-md-3"></div>
                                    <div class="col-md-7">
                                        <select id="ward" class="form-control custom-select" name="ward">
                                        </select>
                                    </div>
                                </div>
                            			   <br>
                                  <div class="form-group row">
                               	<div class="col-md-3"></div>
                                   <div class="col-md-7">
                                      <button type="submit" id = "submit" name = "submit" class="btn btn-primary">Hoàn tất</button>
                                   </div>
                               </div>                                
                               <input type="hidden" value="<c:url value="/" />" id = "realUrl">
                               <input type="hidden" value="<%=profile.getWard().getDistrict().getId()%>" id = "idDistrict">
                               <input type="hidden" value="<%=profile.getWard().getId()%>" id = "idWard">
                      		 </form>
				</div>
			</div>									
		</div>			
		
	<!-- This is infomation account -->
		<div class="col-md-5">
			<div class="card bg-white m-3">
				<div class="card-body">
				<h4 class="mt-2 mb-5 text-info">Thông tin tài khoản</h4>	
					<form method="post" enctype="multipart/form-data" name="avtForm" action="<c:url value="/" /><%=updateAvtAction%>"> 
						<div class="d-flex flex-column justify-content-center align-items-center">
							<h6 class="text-primary mb-2"><%=username%> - ID: <%=id%></h6>
							<span class="text-dark mb-2">Ngày bắt đầu: <%=joindate%></span>
							<div class="col-md-8">
								<img src='<c:url value="/" />avt/<%=username%>?t=<%=new Date().toString()%>'  class='img-thumbnail'>
					    	</div>
							<input type="hidden" id="id" name = "id" value="<%=id%>">
					        <div class="custom-file m-3 col-md-6">
		                       	<input type="file" id="AVT" class="custom-file-input" name="AVT" accept="image/*">
		                       	<br>
								<label for="AVT" class="custom-file-label">Chọn ảnh</label>
	                       	</div>
	                       <button type="submit" class="btn btn-primary">Update</button>
						</div>
					</form>
                     	 	</div>
                     	 </div>
                     	 
                     	 <!-- Reset Password -->
			<div class="card bg-white m-3">
				<div class="card-body">
					<h4 class="mt-2 mb-5 text-info">Đổi mật khẩu</h4>	
					<form name="reset-password" method="post">
					   <input type="hidden" value = "<%=username%>" name="username">
					   <div class="form-group">
					      <label for="admin-pass" class="text-primary">Mật khẩu <%= role == 1 ? "Admin" : "cũ" %>:</label>
					      <input type="password" class="form-control" id="pass" name="pass">
					    </div>										
					   <div class="form-group">
					      <label for="newpass" class="text-primary">Mật khẩu mới:</label>
					      <input type="password" class="form-control" id="newpass" name="newpass">
					    </div>										
					   <div class="form-group">
					      <label for="repass" class="text-primary">Nhập lại mật khẩu mới:</label>
					      <input type="password" class="form-control" id="repass" name="repass">
					    </div>										
					   <div class="form-group">
					   		<button type="button" class="btn btn-primary" onclick="resetPassword('<c:url value="/" /><%=resetPassAction%>')">Xác nhận</button>
					   </div>
					</form>
				</div>
			</div>
		
						
		</div>							

	</div>
</div>