<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="com.ndanhkhoi.entity.Bill"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Bill> bills = (List) request.getAttribute("bills");
	long totalRevenue = 0;
	int countBills = 0;
	if (bills != null)
	{
		for (Bill b : bills) totalRevenue += b.getOrderInfo().getTotalPrice();
		countBills = bills.size();
	}
	Locale localeVN = new Locale("vi", "VN");
    NumberFormat vn = NumberFormat.getCurrencyInstance(localeVN);
%>
<div class="col-md-6 p-3">
	<h5 class="text-danger text-center p-3">Doanh thu</h5>
	<table class="table table-sm table-borderless table-hover">
		<tr>
			<th class='pl-3'>Số hóa đơn bán được</th>
			<td class='text-right'><%=countBills%></td>
		</tr>
		<tr>
			<th class='pl-3'>Tổng doanh thu</th>
			<td class='text-right text-danger'><%=vn.format(totalRevenue)%></td>
		</tr>
	</table>
</div>    
   