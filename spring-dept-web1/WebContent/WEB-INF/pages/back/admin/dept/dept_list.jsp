<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fnt" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";

	String delete_url = "pages/back/admin/dept/dept_delete.action";
	String edit_url = "pages/back/admin/dept/edit_pre.action";
%>
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP + 业务层实现部门管理</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<script type="text/javascript" src="jquery/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/common/mldn_util.js"></script>
<script type="text/javascript"
	src="js/pages/back/admin/dept/dept_list.js"></script>
<script type="text/javascript" src="pages/back/admin/dept/dept_add.jsp"></script>
<script type="text/javascript"
	src="pages/back/admin/dept/dept_delete.jsp"></script>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
</head>
<body>


	<div class="container">
		<div class="row">
			<div class="h1">
				<strong><span class="glyphicon glyphicon-th-list"></span>&nbsp;部门信息列表</strong>
			</div>
		</div>
		<jsp:include
			page="/WEB-INF/pages/plugins/split_page_search_plugin.jsp" />
		<div class="row">
			<table class="table table-striped table-bordered table-hover">
				<tr>
					<td>部门编号</td>
					<td>部门名称</td>
					<td>部门位置</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${alldept}" var="dept">
					<tr>
						<td>${dept.deptno }</td>
						<td>${dept.dname }</td>
						<td>${dept.loc }</td>
						
						<td>
							<button id="editBtn" class="btn btn-danger btn-xs">
								<span class="glyphicon glyphicon-trash"></span>&nbsp;<a
									href="<%=edit_url%>?deptno=${dept.deptno}">修改部门信息</a>
							</button>
							<button id="deleteBtn" class="btn btn-danger btn-xs">
								<span class="glyphicon glyphicon-trash"></span>&nbsp;<a
									href="<%=delete_url%>?deptno=${dept.deptno}">删除部门信息</a>
							</button>
						</td>
					</tr>
				</c:forEach>
			</table>

			<button id="addBtn" class="btn btn-info btn-lg">
				<span class="glyphicon "></span>&nbsp;增加部门信息
			</button>

		</div>
		<jsp:include page="/WEB-INF/pages/plugins/split_page_bar_plugin.jsp" />
	</div>


</body>
</html>