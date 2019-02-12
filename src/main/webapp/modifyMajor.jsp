<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modifyMajor.jsp' starting page</title>
    
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
      <legend>修改专业信息</legend>
  </fieldset>
  <%-- <%
  Integer id=Integer.parseInt(request.getParameter("id"));
  String name = request.getParameter("name");
  String desc = request.getParameter("desc");
  %> --%>
 
  
    <form class="layui-form" action="${pageContext.request.contextPath}/students/modifyMajor.do" style="padding-top: 26px">
      <input type="hidden" name="id" value=${majorDomain.id }>
      <div class="layui-form-item">
          <label class="layui-form-label">专业名称</label>
          <div class="layui-input-inline">
              <input type="text" name="name" value="${majorDomain.name }" lay-verify="required" autocomplete="off" class="layui-input">
          </div>
      </div>
      <div class="layui-form-item">
          <label class="layui-form-label">专业描述：</label>
          <div class="layui-input-inline">
              <input type="text" name="desc" value=${majorDomain.desc } lay-verify="required" autocomplete="off" class="layui-input">
          </div>
      </div>
      <div class="layui-form-item">
          <div class="layui-inline">
              <label class="layui-form-label">设立学院：</label>
              <div class="layui-input-inline">
                  <select name="academyId">
                      <c:forEach var="list" items="${majorList}">
                          <option value="${list.id }" ${list.id==majorDomain.academyId?'selected':'' }>${list.name}</option>
                      </c:forEach>
                  </select>
              </div>
          </div>
       </div>
    	<div class="layui-form-item">
          <div class="layui-input-block">
          	  <input class="layui-btn" type="submit" value="修改">	
              <button type="reset" class="layui-btn layui-btn-primary">重置</button>
          </div>
      </div>
    	</form>
    	<script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
  <script>
      layui.use(['form', 'layedit', 'laydate'], function(){
          var form = layui.form
              ,layer = layui.layer
              ,layedit = layui.layedit
              ,laydate = layui.laydate;

          //日期
          laydate.render({
              elem: '#date'
          });
          laydate.render({
              elem: '#date1'
          });

          //创建一个编辑器
          var editIndex = layedit.build('LAY_demo_editor');

          //监听指定开关
          form.on('switch(switchTest)', function(data){
              layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
                  offset: '6px'
              });
              layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
          });

      });
  </script>
  </body>
</html>
