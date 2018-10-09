<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  <form action="" id="criteria">
       时间:<input type="text" name="old"/>-<input type="text" name="ne"/>
       状态:<input type="radio" name="pay"/>未付款 <input type="radio" name="pay"/>已付款
   <input type="button" onclick="byCriteria()" value="查询"/>
   </form>
       <table border="1">
          <tr>
            <td>customerName</td>
            <td>totalMoney</td>
            <td>orderDate</td>
            <td>orderState</td>
          </tr>
          <tbody id="tb">
            
          </tbody>
       </table>
       <br/>    <br/>
       <div border="1" width="400" height="300">
          <table>
           <tr>
            <td>订单编号</td>
            <td>客户名称</td>
            <td>总价格</td>
            <td>下单日期</td>
            <td>订单状态</td>
            <td>商品编号</td>
            <td>商品名称</td>
            <td>购买数量</td>
          </tr>
          <tbody id="tb2">
            
          </tbody>
          </table>
       </div>
  </body>
</html>
<script src="js/jquery-1.8.3.min.js"></script>
<script>
   $(function(){
      getAll();
   })
   //获取所有订单
   function getAll(){
    $.ajax({
        url:'Order/getAll',
        type:'post',
        dataType:'json',
        success:function(data){
           for(var i=0;i<data.length;i++){
              var html="<tr>";
               html+="<td>"+data[i].customerName+"</td>";
               html+="<td>"+data[i].totalMoney+"</td>";
               html+="<td>"+new Date(data[i].orderDate).toLocaleDateString()+"</td>";
               if(data[i].orderState==1){
                html+="<td>未付款</td>";
                html+="<td><input onclick=detail("+data[i].orderId+") type='button'  value='查询详情'/></td>"
                html+="<td><input onclick=update("+data[i].orderId+") type='button'  value='点击付款'/></td>";              
                html+="</tr>";
               }else{
                html+="<td>已付款</td>";
                html+="<td><input onclick=detail("+data[i].orderId+") type='button'  value='查询详情'/></td>"
                html+="</tr>";
               }
               $("#tb").append(html);
             }
        }
       
    })
   }
   //获取订单详情
   function detail(data){
     alert(data)
      $.ajax({
        url:'OrderDetail/getOne',
        type:'post',
        dataType:'json',
        data:{"id":data},
        sync:false,
        success:function(data){
               $("#tb2").html("");
               var html="<tr>";
               html+="<td>"+data.order.orderId+"</td>";
               html+="<td>"+data.order.customerName+"</td>";
               html+="<td>"+data.order.totalMoney+"</td>";
               html+="<td>"+new Date(data.order.orderDate).toLocaleDateString()+"</td>";
               if(data.order.orderState==1){
                 html+="<td>未付款</td>";
               }else{
                 html+="<td>已付款</td>";
               }
               html+="<td>"+data.goods.goodsId+"</td>";
               html+="<td>"+data.goods.goodsName+"</td>"
               html+="<td>"+data.goodsCount+"</td>"
               html+="</tr>"; 
               $("#tb2").append(html);
        }
        })
   }
   //点击付款
   function update(id){
	   $.ajax({
	        url:'Order/update',
	        type:'post',
	        data:{"id":id},
	        success:function(data){
	          window.location.reload()
	        }
	      })
   }
   //条件查询
   function byCriteria(){
       var form=new FormData(document.getElementById("criteria"))
      $.ajax({
        url:'Order/criteria',
        type:'post',
        data:form,
        contentType:false,
        processData:false,
        sync:false,
        dataType:'json',
        success:function(data){
            alert(data)
           for(var i=0;i<data.length;i++){
              var html="<tr>";
               html+="<td>"+data[i].customerName+"</td>";
               html+="<td>"+data[i].totalMoney+"</td>";
               html+="<td>"+new Date(data[i].orderDate).toLocaleDateString()+"</td>";
               if(data[i].orderState==1){
                html+="<td>未付款</td>";
                html+="<td><input onclick=detail("+data[i].orderId+") type='button'  value='查询详情'/></td>"
                html+="<td><input onclick=update("+data[i].orderId+") type='button'  value='点击付款'/></td>";              
                html+="</tr>";
               }else{
                html+="<td>已付款</td>";
                html+="<td><input onclick=detail("+data[i].orderId+") type='button'  value='查询详情'/></td>"
                html+="</tr>";
               }
               $("#tb").append(html);
             }
        }
    })
   }
</script>
