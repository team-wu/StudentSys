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
    
    <title>主界面</title>
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
  
  <body class="layui-layout-body">
  <div class="layui-layout layui-layout-admin">
      <div class="layui-header">
          <div class="layui-logo" style=" padding-left: 18px;float: left"> <h2>欢迎登录</h2>

          </div>
          <ul class="layui-nav layui-layout-right">
              <li class="layui-nav-item">
                  <a href="javascript:;">
                      <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                      <c:out value="${ae.name}">用户</c:out>
                  </a>
              </li>
              <li class="layui-nav-item"><a href="">退出登录</a></li>
          </ul>
      </div>

      <div class="layui-side layui-bg-black">
          <div class="layui-side-scroll">
              <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
              <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                  <li class="layui-nav-item layui-nav-itemed">
                      <a class="" href="javascript:;">学生管理</a>
                      <dl class="layui-nav-child">
                          <dd><a onclick="nav('students/findForPager.do')">显示所有学生</a></dd>
                          <dd><a  onclick="nav('students/preAdd.do')">添加学生</a></dd>
                      </dl>
                  </li>
                  <li class="layui-nav-item layui-nav-itemed">
                      <a class="" href="javascript:;">课程管理</a>
                      <dl class="layui-nav-child">
                          <dd><a  onclick="nav('students/showAllCourse.do')">显示所有课程</a></dd>
                          <dd><a  onclick="nav('students/preAddCourse.do')">添加课程</a></dd>
                      </dl>
                  </li>

                  <li class="layui-nav-item">
                      <a href="javascript:;">学院管理</a>
                      <dl class="layui-nav-child">
                          <dd><a  onclick="nav('students/showAllAcademy.do')">显示所有学院</a></dd>
                          <dd><a  onclick="nav('students/preAddAcademy.do')">添加学院</a></dd>
                      </dl>
                  </li>
                  <li class="layui-nav-item">
                      <a href="javascript:;">专业管理</a>
                      <dl class="layui-nav-child">
                          <dd><a  onclick="nav('students/showAllMajor.do')">所有专业</a></dd>
                          <dd><a  onclick="nav('students/preAddMajor.do')">设置专业</a></dd>
                      </dl>
                  </li>
              </ul>
          </div>
      </div>

      <div class="layui-body">
          <!-- 内容主体区域 -->
          <div style="padding: 15px;">内容主体区域</div>

          <iframe id="iframe" src="students/findForPager.do" style="    width: 100%;
    height: 100%;"></iframe>
      </div>

      <div class="layui-footer">
          <!-- 底部固定区域 -->
          © layui.com - 底部固定区域
      </div>
  </div>
  <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
  <script>
      //JavaScript代码区域
      layui.use('element', function(){
          var element = layui.element;

      });
      function nav(uri) {
          $('#iframe').attr('src', uri);
      }
  </script>
  </body>
</html>
