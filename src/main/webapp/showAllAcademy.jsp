<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showAllAcademy.jsp' starting page</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
  </head>
  
  <body>
  <br>
  <h2>当前学院信息</h2>
  <div align="center"><font color="red">${error }</font></div>
  <hr/>
   	 <div class="layui-form layui-border-box layui-table-view" lay-filter="LAY-table-1"
		style="height:232px;">
	   <div class="layui-table-box">
		   <div class="layui-table-header">
			   <table cellspacing="0" cellpadding="0" border="0" class="layui-table">
				   <thead>
					   <th data-field="id">
						   <div class="layui-table-cell laytable-cell-1-id">
                               <span>学院ID</span>
                               <span class="layui-table-sort layui-inline">
                                 <i class="layui-edge layui-table-sort-asc"></i>
	                             <i class="layui-edge layui-table-sort-desc"></i>
                               </span></div>
					   </th>
					   <th data-field="username">
						   <div class="layui-table-cell laytable-cell-1-username"><span>学院名称</span></div>
					   </th>
					   <th data-field="10">
						   <div class="layui-table-cell laytable-cell-1-10" align="center"><span>操作</span></div>
					   </th>
		   			</thead>
		   		 </table>
		   </div>
		<div class="layui-table-body layui-table-main" style="height: 252px;">
			   <table cellspacing="0" cellpadding="0" border="0" class="layui-table">
			   		<c:forEach var="academy" items="${Pager.pageItems}">
			   			<tr>
   					<td data-field="id">
						   <div class="layui-table-cell laytable-cell-1-id">${academy.id}</div>
					   </td>
					   <td data-field="username">
						   <div class="layui-table-cell laytable-cell-1-username">${academy.name}</div>
					   </td>
   						<td data-field="10" align="center" data-off="true">
						   <div class="layui-table-cell laytable-cell-1-10">
						   		<a class="layui-btn layui-btn-xs" href="${pageContext.request.contextPath}/modifyAcademy.jsp?id=${academy.id}&name=${academy.name}">编辑</a>
							   <a class="layui-btn layui-btn-danger layui-btn-xs" href="${pageContext.request.contextPath}/students/delAcademy.do?id=${academy.id}" onclick="return confirmd()">删除</a>
						   </div>
					   </td>
   		</tr>
   		</c:forEach>
   		
   		</table>
   		</div>
   		</div>
   		</div>
   		<script type="text/javascript"> 
		function confirmd() {  
            var msg = "您真的确定要删除吗？";  
            if (confirm(msg)==true){  
                return true;  
            }else{  
                return false;  
            }  
        }  
</script> 
  	<div id="demo">
    	<div class="layui-box layui-laypage layui-laypage-default" id="layui-laypage-1">
		<c:if test="${Pager.page>1}">
		  <a href="${pageContext.request.contextPath}/students/showAllAcademy.do?page=${Pager.page-1}&perPage=${Pager.perPage}" class="layui-laypage-prev" >上一页</a>
		</c:if>
		<c:forEach begin="1" end="${Pager.pageCount}" var="i">
		  <a  href="${pageContext.request.contextPath}/students/showAllAcademy.do?page=${i}&perPage=${Pager.perPage}" >${i}</a>
		</c:forEach>
		<c:if test="${Pager.page<Pager.pageCount}">
		  <a href="${pageContext.request.contextPath}/students/showAllAcademy.do?page=${Pager.page+1}&perPage=${Pager.perPage}" class="layui-laypage-next">下一页</a>
		</c:if>
	  </div>
	  </div>
   		<style>
	   .laytable-cell-1-0 {
		   width: 48px;
	   }
	   .laytable-cell-1-id {
		   width: 89px;
	   }
	   .laytable-cell-1-username {
		   width: 150px;
	   }
	   .laytable-cell-1-sex {
		   width: 80px;
	   }
	   .laytable-cell-1-city {
		   width: 110px;
	   }
	   .laytable-cell-1-sign {
		   width: 160px;
	   }
	   .laytable-cell-1-experience {
		   width: 80px;
	   }
	   .laytable-cell-1-classify {
		   width: 80px;
	   }
	   .laytable-cell-1-wealth {
		   width: 150px;
	   }
	   .laytable-cell-1-score {
		   width: 80px;
	   }
	   .laytable-cell-1-10 {
		   width: 178px;
	   }
	   </style>
  </body>
</html>

