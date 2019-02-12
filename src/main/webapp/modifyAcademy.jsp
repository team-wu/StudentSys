<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modifyAcademy.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css"  media="all">
  </head>
  
  <body>
  	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
      <legend>修改学院信息</legend>
  </fieldset>
    <%
    	String id=request.getParameter("id"); 
   	    String name=request.getParameter("name"); 
    %>
  
    <form class="layui-form" action="${pageContext.request.contextPath}/students/modifyAcademy.do" style="padding-top: 26px">
      <input type="hidden" name="id" value=<%=id %>>
      <div class="layui-form-item">
          <label class="layui-form-label">学院名称</label>
          <div class="layui-input-inline">
              <input type="text" name="name" value=<%=name %> lay-verify="required" autocomplete="off" class="layui-input" value=<%=name %>>
          </div>
      </div>

    	<div class="layui-form-item">
          <div class="layui-input-block">
          	  <input class="layui-btn" type="submit" value="修改">	
              <button type="reset" class="layui-btn layui-btn-primary">重置</button>
          </div>
      </div>
  </form>
  </body>
</html>
