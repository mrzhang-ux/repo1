<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<title>My JSP 'addCustomer.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<table align="center">
		<form action="${pageContext.request.contextPath }/servlet/CustomerServlet" method="post">
		 <input type="hidden" name="op" value="addCustomer"/>
		<tr>
			<td nowrap="nowrap">姓名:</td>
			<td><input type="text" name="name" />
			<td>
		<tr>
		<tr>
			<td nowrap="nowrap">性别:</td>
			<td><input type="radio" name="gender" value="男" />男 <input
				type="radio" name="gender" value="女" />女
			<td>
		<tr>
		<tr>
			<td nowrap="nowrap">邮箱:</td>
			<td><input type="email" name="email" />
			<td>
		<tr>
		<tr>
			<td nowrap="nowrap">爱好:</td>
			<td><input type="checkbox" name="hobby" value="java" /> JAVA <input
				type="checkbox" name="hobby" value="oracle" />ORACLE <input
				type="checkbox" name="hobby" value="spring" /> SPRING <input
				type="checkbox" name="hobby" value="mybatis" /> MYBATIS
			<td>
		<tr>
		<tr>
			<td nowrap="nowrap">电话:</td>
			<td><input type="tel" name="phonenum" />
			<td>
		<tr>
		<tr>
			<td nowrap="nowrap">类型:</td>
			<td>
			 <select name="type">
					<option value="vip">VIP</option>
					<option value="svip">SVIP</option>
			</select>
			<td>
		<tr>
		<tr>
			<td nowrap="nowrap">生日:</td>
			<td><input type="date" name="birthday" />
			<td>
		<tr>
		<tr>
			<td nowrap="nowrap">描述:</td>
			<td><textarea name="description" rows="" cols=""></textarea>
			<td>
		<tr>
		<tr>
			<td nowrap="nowrap" colspan="2">
			    <input type="submit" value="添加" />
				<input type="reset" value="重置" />
			</td>
		<tr>
	</form>
	</table>
</body>
</html>
