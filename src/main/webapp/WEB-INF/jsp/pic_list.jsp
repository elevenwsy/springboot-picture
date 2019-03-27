<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/static/jquery/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {

		$("#addForm").submit(function() {
			if (!checkEmpty("name", "分类名称"))
				return false;
			if (!checkEmpty("categoryPic", "分类图片"))
				return false;
			return true;
		});
	});
</script>
</head>
<body>
	<div>
		<div>
			<table class="table table-responsive">
				<thead>
					<tr>
						<th>名称</th>
						<th>图片</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pic }" var="p">
						<tr>
							<td>${p.name }</td>
							<td><img height="40px" src="img/${p.id}.jpg"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div>
			<form method="post" action="img_add" id="addForm"
				enctype="multipart/form-data">
				<table>
					<tr>
						<td>姓名</td>
						<td><input id="name" name="name" type="text"></td>
					</tr>
					<tr>
						<th>图片</th>
						<td><input id="userPic" accept="image/*" type="file"
							name="image" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="提交" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>