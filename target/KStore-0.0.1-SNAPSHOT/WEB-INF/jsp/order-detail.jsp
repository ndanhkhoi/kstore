<%@page import="com.ndanhkhoi.entity.Bill"%>
<%@page import="com.ndanhkhoi.entity.OrderDetail"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<OrderDetail> orderDetails = (List) request.getAttribute("orderDetails");
%>
<div class = "card p-5 wow bounceInUp">
	
	<% if (orderDetails.get(0).getOrderInfo().getPaid() == 0) { 	//chua thanh toan %>
	<h3 class='text-success text-center'>Đơn đặt hàng số <%=orderDetails.get(0).getOrderInfo().getId()%></h3>
	<div class='text-center'>Tên khách hàng:<%=orderDetails.get(0).getOrderInfo().getProfile().getFullname()%></div>
	<div class='text-center'>Ngày đặt hàng:<%=orderDetails.get(0).getOrderInfo().getOrderDay()%></div>
	<% } else{ 
			Bill bill = orderDetails.get(0).getOrderInfo().getBill(); %>
	<h3 class='text-success text-center'>Hóa đơn thanh toán </h3>
	<div class='text-center'>Mã hóa đơn:<%=bill.getId()%></div>
	<div class='text-center'>Mã đặt hàng:<%=orderDetails.get(0).getOrderInfo().getId()%></div>
	<div class='text-center'>Tên khách hàng:<%=orderDetails.get(0).getOrderInfo().getProfile().getFullname()%></div>
	<div class='text-center'>Ngày thanh toán:<%=bill.getpaymentDay()%></div>			
	<div class='text-center'>Người thu tiền:<%=bill.getProfile().getFullname()%></div>			
		<% } %>
	<table class='table table-striped mt-3 p-2'>
		<tr>
			<th>STT</th>
			<th>Mặt hàng</th>
			<th>Đơn giá</th>
			<th>Số lượng</th>
		</tr>
		<%
		int i = 0;
		for (OrderDetail o : orderDetails){
			i++; %>
		<tr>
			<td><%=i%></td>
			<td><%=o.getProduct().getName()%></td>
			<td class='text-danger'><%=o.getProduct().getPriceString()%></td>
			<td><%=o.getNumber()%></td>
		</tr>
		<% } %>
		</table>
	<h4 class="text-danger text-center pt-3">Tổng tiền: <%=orderDetails.get(0).getOrderInfo().getTotalPriceString()%></h4>
	<% if (orderDetails.get(0).getOrderInfo().getPaid() == 0 && (request.isUserInRole("ROLE_STAFF") || request.isUserInRole("ROLE_ADMIN") ) ){ %>
		<a href='../staff-save-bill/<%=orderDetails.get(0).getOrderInfo().getId()%>' class='btn btn-primary m-2'>Thanh toán và lưu hóa đơn</a>
	<% } %>
</div>