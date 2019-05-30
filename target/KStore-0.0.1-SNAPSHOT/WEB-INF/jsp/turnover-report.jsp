<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="col-md-12 p-3">
	<h5 class="text-danger text-center p-3">Doanh số</h5>
	<div class="d-flex  justify-content-around">
		<div class="col-md-4">
			<h6 class="text-center">Nhập hàng</h6>
			<div class='my-table-scrollbar'>
			<table class="table table-sm table-borderless table-hover">
				<%
					List<Object[]> imports = (List) request.getAttribute("imports");
					int totalImport = 0;
					if (imports != null)
						for (Object[] o : imports){
							out.println("<tr>");
							out.println("<td class='pl-3'>" + o[0] + "</td>");
							out.println("<td class='text-right'>" + o[1] + "</td>");
							out.println("</tr>");
							totalImport += Integer.parseInt(o[1].toString());
						}
				%>
				<tr>
					<th class='pl-3'>Tổng nhập</th>
					<td class='text-right'><%=totalImport%></td>
				</tr>
			</table>
			</div>
		</div>
		<div class="col-md-4">
			<h6 class="text-center">Bán hàng</h6>
			<div class='my-table-scrollbar'>
			<table class="table table-sm table-borderless table-hover">
				<%
					List<Object[]> sales = (List) request.getAttribute("sales");
					int totalSale = 0;
					if (imports != null)
						for (Object[] o : sales){
							out.println("<tr>");
							out.println("<td class='pl-3'>" + o[0] + "</td>");
							out.println("<td class='text-right'>" + o[1] + "</td>");
							out.println("</tr>");
							totalSale += Integer.parseInt(o[1].toString());
						}
				%>
				<tr>
					<th class='pl-3'>Tổng bán</th>
					<td class='text-right'><%=totalSale%></td>
				</tr>
			</table>
			</div>
		</div>
	</div>
</div>    
   