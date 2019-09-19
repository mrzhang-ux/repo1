<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'pageFile.jsp' starting page</title>
    
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
                  第${page.currentPage }页 
       	  共${page.totalPageNum} 页
       	 <a href="${page.url }&num=1"> 首页 </a>
       	 <a href="${page.url}&num=${page.prePageNum}"> 上一页 </a>
       	 
       	 <c:forEach begin="${page.startPage }" end="${page.endPage }" var="num">
       	 <a href="${page.url}&num=${num}">${num }</a>
       	 </c:forEach>
       	 
       	 <a href="${page.url}&num=${page.nextPageNum}"> 下一页 </a>
       	 <a href="${page.url}&num=${page.totalPageNum}">尾页 </a>
  </body>
</html>
