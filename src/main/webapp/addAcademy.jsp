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
    <meta charset="utf-8">
    <title>添加学院</title>
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
  <br/>
  <body>
  <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
	  <legend>添加学院</legend>
  </fieldset>
   <form action="${pageContext.request.contextPath}/students/addAcademy.do" class="layui-form">
	   <div class="layui-form-item">
		   <label class="layui-form-label">学院名称</label>
		   <div class="layui-input-inline">
			   <input type="text" name="name" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
		   </div>
	   </div>

	   <div class="layui-form-item">
		   <div class="layui-input-block">
		   	   <input class="layui-btn" type="submit" value="添加">
			   <!-- <button class="layui-btn" lay-submit="" lay-filter="demo1">添加</button> -->
			   <button type="reset" class="layui-btn layui-btn-primary">重置</button>
		   </div>
	   </div>
   </form>
  </body>
  <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>

  <script >
      layui.use(['form', 'layedit', 'laydate'], function() {
          var form = layui.form
              , layer = layui.layer
              , layedit = layui.layedit
              , laydate = layui.laydate;
      });

  </script>
</html>
