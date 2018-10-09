<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'SaveGoods.jsp' starting page</title>
    
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
      <h1>商品录入</h1>
        <form id="myForm" action="" >
	              商品名：<input type="text" name="goodsName"/><br/>
	              类型ID：<select name="type.typeId" id="type"></select><br/>
	              商品单价：<input type="text" name="goodsUnitPrice"/><br/>
	              商品图片：<input type="file"  name="file"/><br/>
	              录入时间：<input type="text" name="goodsDate"/><br/>
	       <input id="btn" type="button" value="确认录入"/>
        </form>
        <hr/>
        <table border="1" style="border-collapse:collapse">
           <tr>
              <td></td>
              <td>商品名称</td>
              <td>商品类型</td>
              <td>商品价格</td>
              <td>上架日期</td>
           </tr>
           <tbody id="tb">
           </tbody>
        </table>
        <a id="minusPage">上一页</a>
        <a id="addPage">下一页</a>
        当前<span id="pageNum"></span>页
        共<span id="pages"></span>页
        
        
  </body>
</html>
<script src="js/jquery.min.js"></script>
<script>
   
   $(function(){
      getAll();
      getGoodsAll(1);
   })
    
   //商品录入
   $("#btn").click(function(){
     // 用表单来初始化
      var form = document.getElementById("myForm");
      var formData = new FormData(form);
           /*  //获取file对象
           var file=$('#file')[0].files[0];  */
      $.ajax({
       url:"Goods/save",
       type:"post",
       async:false,
       contentType: false, //禁止jqueryjQuery不要去设置Content-Type请求头
       processData: false, // 告诉jQuery不要去处理发送的数据
       data:formData,
       success:function(data){
          window.location.reload();
       }
      }) 
   })
   //查询所有类型
    function getAll(){
       $.ajax({
       url:"GoodsType/getAll",
       type:"post",
       contentType:"application/json,charset=utf-8",
       dataType:"json",
       success:function(data){
           var array=data;
           for(var i=0;i<array.length;i++){
             var html="<option value='"+array[i].typeId+"'>"+array[i].typeName+"</option>"
            $("#type").append(html);
           }
       }
      }) 
   }
   
   //上下页
   $("#addPage").click(function(){
       var pageNum=parseInt($("#pageNum").html())+1;
       getGoodsAll(pageNum);
   })
   $("#minusPage").click(function(){
       var pageNum=parseInt($("#pageNum").html())-1;
       getGoodsAll(pageNum);
   })
   //查询所有商品
    function getGoodsAll(pageNum){
      $("#tb").html("");
       $.ajax({
       url:"Goods/getAll",
       type:"post",
       dataType:"json",
       data:{"pageNum":pageNum},
       success:function(data){
         var list=data.list;
         //分页
          if(data.isFirstPage){
            $("#minusPage").hide();
          }else{
             $("#minusPage").show();
          }
          if(data.isLastPage){
             $("#addPage").hide();
          }else{
             $("#addPage").show();
          }
          $("#pageNum").html(data.pageNum);
          $("#pages").html(data.pages)
         //数据
          for(var i=0;i<list.length;i++){
          var html="<tr>";
              html+="<td></td>";
              html+="<td>"+list[i].goodsName+"</td>";
              html+="<td>"+list[i].type.typeName+"</td>";
              html+="<td>"+list[i].goodsUnitPrice+"</td>";
              html+="<td>"+new Date(list[i].goodsDate).toLocaleDateString()+"</td>"
              html+="<td><a onclick='del("+list[i].goodsId+")'>删除</a></td>";
              html+="<td><a href='Goods/updateBegin/"+list[i].goodsId+"'>修改</a></td>"
              html+="</tr>";
             $("#tb").append(html);
          }
       }
      }) 
   }
   
   //删除数据
   function del(id){
     $.ajax({
        url:'Goods/del',
        type:'post',
        dataType:'text',
        data:{
           "id":id
        },success:function(data){
           if(data=="true"){
              var pageNum=parseInt($("#pageNum").html());
               getGoodsAll(pageNum);
           }
        }
     })
   }
    
</script>
