<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>客户列表的展示</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

    <style type="text/css">
       .even{
         background-color: #c3f3c3; 
       }
       
       .odd{
          background-color: #f3c3f3; 
       }
   	 </style>
  </head>
  
  <body>
  <form action="" method="post" id="form1">
   <table align="center" width="80%">
       
        <tr align="right">
        	<td>
        	 <a href="${pageContext.request.contextPath }/servlet/CustomerServlet?op=addCustomerUI">添加</a>
        	</td>
        </tr>
    	<tr>
    	     <td>
    	         <table border="1" align="center" width="100%">
				    	<tr>
				    	   <td nowrap="nowrap"></td>
				    	   <td nowrap="nowrap">姓名</td>
				    	   <td nowrap="nowrap">生日</td>
				    	   <td nowrap="nowrap">电话</td>
				    	   <td nowrap="nowrap">邮箱</td>
				    	   <td nowrap="nowrap">性别</td>
				    	   <td nowrap="nowrap">爱好</td>
				    	   <td nowrap="nowrap">类型</td>
				    	   <td nowrap="nowrap">描述</td>
				    	   <td nowrap="nowrap">操作</td>
				    	</tr>
				        
				        <c:forEach items="${page.records }" var="customer" varStatus="vs">
					        <tr class="${vs.index%2==0? 'even':'odd' }" >
					           <td nowrap="nowrap"> 
					           	 <input type="checkbox" name="ids" value="${customer.id }"/> 
					           </td>
					           <td nowrap="nowrap">${customer.name }</td>
					           <td nowrap="nowrap">${customer.birthday }</td>
					    	   <td nowrap="nowrap">${customer.phonenum }</td>
					    	   <td nowrap="nowrap">${customer.email }</td>
					    	   <td nowrap="nowrap">${customer.gender }</td>
					    	   <td nowrap="nowrap">${customer.hobby }</td>
					    	   <td nowrap="nowrap">${customer.type }</td>
					    	   <td nowrap="nowrap">${customer.description }</td>
					    	   <td nowrap="nowrap">
					    	     <!--  ${pageContext.request.contextPath }/servlet/CustomerServlet?op=updateCustomerUI&id=${customer.id } -->
					    	     <a href="javascript:delOne('${customer.id }')">删除</a>
					    	     <a href="${pageContext.request.contextPath }/servlet/CustomerServlet?op=updateCustomerUI&id=${customer.id }">|修改</a>
					    	   </td>
					        </tr>
				      </c:forEach> 
				    </table>
    	     </td>
    	</tr>
	    
        <tr>
        	<td>
        	 <a href="javascript:delMul()"> 批量删除 </a>
        	</td>
        </tr>
        <tr align="center">
        	<td >
        	     <!-- 分页开始 -->
        	     <%@ include file="pageFile.jsp" %>
        	</td>
        </tr>
        
        
    </table>
    </form>
    <script type="text/javascript">
    
    //删除单条记录： 
       function delOne(cid){
       	 var flag =  window.confirm("您确定要删除吗?"); 
       	 //alert(flag);
       	 if(flag){
       	     alert(cid);
       	 	window.location.href="${pageContext.request.contextPath }/servlet/CustomerServlet?op=deleteCustomer&id="+cid; 
       	 }
       }
       
       function delMul(){
          var flag = false;
       	   //获得checkbox的值：
       	  var idsObjs  =  document.getElementsByName("ids");
       	  
       	  //检验： 
       	  
       	  for(var i=0 ; i< idsObjs.length; i++){
       	  	 if(idsObjs[i].checked){//true 表明用户选中： checkbox ：checked或者是true
       	  	 	flag= true; 
       	  	 }
       	  }
       	  
       	  if(!flag){//表明用户没有选中： 
       	      alert("请选择您要删除的记录");
       	      return; 
       	  }
       	  
       	  var f = window.confirm("您确定要删除选中的记录吗");
       	  if(f){//用户点击确定按钮
       	     //使用form表单提交数据： 
       	     //document.forms[0].submit();
       	     
       	     var formEle = document.getElementById("form1");
       	     formEle.action="${pageContext.request.contextPath }/servlet/CustomerServlet?op=deleteMulCustomer"; 
       	     
       	     formEle.submit();
       	  }
       }
       
    </script>
  </body>
</html>
