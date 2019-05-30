<%@ page language='java' contentType='text/html; charset=UTF-8'
    pageEncoding='UTF-8'%>
<div class='col-md-2 text-white bg-dark'>
	<div class='nav nav-pills flex-column'>
		<% if (request.isUserInRole("ROLE_ADMIN")) { %>
		<h5 class='row p-3 bg-info text-center'>Admin Dashboard</h5>
		<a class='nav-link text-white mt-2' href='<%=request.getContextPath()%>/admin-manager/staff'>Quản lý nhân viên </a>
		<a class='nav-link text-white' href='<%= request.getContextPath()%>/admin-manager/customer'>Quản lý khách hàng </a>
		<a class='nav-link text-white' href='<%= request.getContextPath()%>/staff-view-phones'>Quản lý điện thoại </a>
		<a class='nav-link text-white' href='<%= request.getContextPath()%>/staff-manager-order'>Quản lý đơn đặt hàng </a>
		<a class='nav-link text-white' href='<%= request.getContextPath()%>/staff-manager-bill'>Quản lý hóa đơn </a>
		<a class='nav-link text-white' href='<%= request.getContextPath()%>/admin-view-report'>Báo cáo</a>
		<a class='nav-link text-white' href='<%= request.getContextPath()%>/admin-view-log'>Nhật ký hệ thống</a>
		<a class='nav-link text-white' href='<%= request.getContextPath()%>/admin-profile'>Thông tin tài khoản </a>		
		<% } else if (request.isUserInRole("ROLE_STAFF")) {  %>
		<h5 class='row p-3 bg-info text-center'>Staff Dashboard</h5>
		<a class='nav-link text-white mt-2' href='<%= request.getContextPath()%>/staff-manager-order'>Quản lý đơn đặt hàng </a>
		<a class='nav-link text-white' href='<%= request.getContextPath()%>/staff-manager-bill'>Quản lý hóa đơn </a>
		<a class='nav-link text-white' href='<%= request.getContextPath()%>/staff-view-phones'>Danh sách điện thoại </a>
		<% } %>
	<a class='nav-link text-white' href='<%= request.getContextPath()%>/logout'>Đăng xuất</a>	</div>			
</div>