<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="com.ndanhkhoi.entity.Bill"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int countCustomer = 0, countStaff = 0;
	try{
		countCustomer = (Integer) request.getAttribute("countCustomer");
		countStaff = (Integer) request.getAttribute("countStaff");
	}
	catch (Exception e){}
%>
<div class="col-md-6 p-3">
	<h5 class="text-danger text-center p-3">Tài khoản</h5>
	<table class="table table-sm table-borderless table-hover">
		<tr>
			<th class='pl-3'>Số khách hàng đăng ký</th>
			<td class='text-right'><%=countCustomer%></td>
		</tr>
		<tr>
			<th class='pl-3'>Số tài khoản nhân viên mới</th>
			<td class='text-right'><%=countStaff%></td>
		</tr>
	</table>
</div>    
   