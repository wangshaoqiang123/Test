<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updat.jsp' starting page</title>
    
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
        <form action="Goods/endupdate" method="post">
		           商品ID：<input value="${list[0].goodsId}" name="goodsId"/><br/>
		           商品名:<input value="${list[0].goodsName}" name="goodsName"/><br/>
		           商品图片路径:<input value="${list[0].goodsImageName}" name="goodsImageName"/><br/>
		           <input type="submit" value="提交"/>
        </form>
  </body>
</html>
