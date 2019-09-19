<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



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
		 <input type="hidden" name="op" value="updateCustomer"/>
		 <input type="hidden" name="id" value="${customer.id }"/>
		<tr>
			<td nowrap="nowrap">姓名:</td>
			<td><input type="text" name="name" value="${customer.name }" />
			<td>
		<tr>
		<tr>
			<td nowrap="nowrap">性别:</td>
			<td><input type="radio" name="gender" value="男"  ${customer.gender=='男'?'checked':'' }/>男 <input
				type="radio" name="gender" value="女"  ${customer.gender=='女'?'checked':'' }/>女
			<td>
		<tr>
		<tr>
			<td nowrap="nowrap">邮箱:</td>
			<td><input type="email" name="email" value="${customer.email }"  />
			<td>
		<tr>
		<tr>
			<td nowrap="nowrap">爱好:</td>
			<td>  			    <input type="checkbox" name="hobby" value="java"  ${fn:contains(customer.hobby,'java')?'checked':'' }  /> JAVA 
			    <input type="checkbox" name="hobby" value="oracle" ${fn:contains(customer.hobby,'oracle')?'checked':'' }  />ORACLE 
			    <input type="checkbox" name="hobby" value="spring" ${fn:contains(customer.hobby,'spring')?'checked':'' }  /> SPRING 
				<input type="checkbox" name="hobby" value="mybatis" ${fn:contains(customer.hobby,'mybatis')?'checked':'' }  /> MYBATIS
			<td>
		<tr>
		<tr>
			<td nowrap="nowrap">电话:</td>
			<td><input type="tel" name="phonenum" value="${customer.phonenum }"  />
			<td>
		<tr>
		<tr>
			<td nowrap="nowrap">类型:</td>
			<td>
			 <select name="type">
					<option value="vip"  ${customer.type=='vip'?'selected':'' } >VIP</option>
					<option value="svip"  ${customer.type=='svip'?'selected':'' }>SVIP</option>
			</select>
			<td>
		<tr>
		<tr>
			<td nowrap="nowrap">生日:</td>
			<td><input type="date" name="birthday"  value="${customer.birthday }" />
			<td>
		<tr>
		<tr>
			<td nowrap="nowrap">描述:</td>
			<td><textarea name="description" rows="" cols="">${customer.description }</textarea>
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
