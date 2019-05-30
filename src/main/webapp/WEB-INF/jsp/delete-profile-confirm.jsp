<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="modal" id="delete-confirm-modal">
    <div class="modal-dialog">
	      <div class="modal-content">    
	      	<div class="modal-header">
				<h4 class="text-danger">Xóa <span id = 'profile-name-modal'></span> ?</h4>      
	            <button type="button" class="close" data-dismiss="modal">&times;</button>
		    </div>
		    <div class='d-flex flex-column m-2 p-3'>
			  <center>    
			    	<input type="hidden" value ='' id='id-profile-modal'>
			    	 <label for="password-admin">Nhập mật khẩu để xóa</label>
		            <input type="password" class="form-control col-md-7" id="password-admin">
		            <button type="button" class="btn btn-primary mt-2 con-md-3" onclick="deleteProfile()">Xác nhận</button>
	         </center>
	         </div>
		 </div>
	</div>
</div>