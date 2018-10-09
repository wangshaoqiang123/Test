<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
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
    <form name="myForm" id="mform" enctype="multipart/form-data">
    <input  name="goodsName">
    <input  name="goodsDesc">
    <input type="file">
    <input type="button" id="btn" value="上传">
     </form>
  </body>
</html>
<script src="js/jquery-1.8.3.min.js"></script>
<script>
    $('#btn').click(function () {

        //获取form 表单内容
        var form = document.getElementById("mform");
        //获取form表单中第一个 input type是file的的对象
          var img=$('input[type=file]')[0].files[0];
          var fm = new FormData(form);
          fm.append('file', img);
        alert(fm)
        $.ajax(
            {
                url: 'Goods/save',
                type: 'POST',
                data: fm,
                contentType: false, //禁止设置请求类型
                processData: false, //禁止jquery对DAta数据的处理,默认会处理
                //禁止的原因是,FormData已经帮我们做了处理
                success: function (result) {
                    //测试是否成功
                    //但需要你后端有返回值
                    alert(result);
                }
            }
        );
    });
