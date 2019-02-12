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
    <title>My JSP 'showAllMajor.jsp' starting page</title>  
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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" >
  </head>
  
  <body>
   <br>
  <h2>当前专业信息</h2>
  <div align="center"><font color="red">${error }</font></div>
  <hr/>
  
  <div class="layui-form layui-border-box layui-table-view" lay-filter="LAY-table-1"
		>
	   <div class="layui-table-box">
		   <div class="layui-table-header">
			   <table cellspacing="0" cellpadding="0" border="0" class="layui-table">
				   <thead>
					   <th data-field="id">
						   <div class="layui-table-cell laytable-cell-1-id">
                               <span>专   业ID</span>
                               <span class="layui-table-sort layui-inline">
                                 <i class="layui-edge layui-table-sort-asc"></i>
	                             <i class="layui-edge layui-table-sort-desc"></i>
                               </span></div>
					   </th>
					   <th data-field="username">
						   <div class="layui-table-cell laytable-cell-1-username"><span>专业名称</span></div>
					   </th>
					   <th data-field="sex">
						   <div class="layui-table-cell laytable-cell-1-sex"><span>专业描述</span><span
								   class="layui-table-sort layui-inline"></span></div>
					   </th>
					   <th data-field="sex">
						   <div class="layui-table-cell laytable-cell-1-sex"><span>所属学院</span><span
								   class="layui-table-sort layui-inline"></span></div>
					   </th>
					   <th data-field="10">
						   <div class="layui-table-cell laytable-cell-1-10" align="center"><span>操作</span></div>
					   </th>
   		</thead>
   		 </table>
    </div>
    <div class="layui-table-body layui-table-main" >
			   <table cellspacing="0" cellpadding="0" border="0" class="layui-table">
   		<c:forEach var="major"	items="${list}">
   			<tr>
   					<td data-field="id">
						   <div class="layui-table-cell laytable-cell-1-id">${major.id}</div>
					   </td>
					   <td data-field="username">
						   <div class="layui-table-cell laytable-cell-1-username">${major.name}</div>
					   </td>
					   <td data-field="sex">
						   <div class="layui-table-cell laytable-cell-1-sex">${major.desc}</div>
					   </td>
   						<td data-field="sex">
						   <div class="layui-table-cell laytable-cell-1-sex">${major.academyName}</div>
					   </td>
					   <td data-field="10" align="center" data-off="true">
						   <div class="layui-table-cell laytable-cell-1-10">
								   <a class="layui-btn layui-btn-xs" href="${pageContext.request.contextPath}/students/preModifyMajor.do?id=${major.id}">修改</a>
							   <a class="layui-btn layui-btn-danger layui-btn-xs" href="${pageContext.request.contextPath}/students/delMajor.do?id=${major.id}" onclick="return confirmd()">删除</a>
						   </div>
					   </td>
    		   			</tr>
   		</c:forEach>
		
   		</table>
   		</div>
   		
   		<style>
		   .laytable-cell-1-0 {
			   width: 48px;
		   }
		   .laytable-cell-1-id {
			   width: 160px;
		   }
		   .laytable-cell-1-username {
			   width: 160px;
		   }
		   .laytable-cell-1-sex {
			   width: 160px;
		   }
		   .laytable-cell-1-city {
			   width: 160px;
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
  </body>
</html>
