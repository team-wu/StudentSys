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
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
      <meta name="keywords" content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design">
	  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
	  <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" >
	  <title>教务系统登录</title>
  </head>
  
  <body>
	<div id="container" class="kit-login">
			<div class="kit-login-bg"></div>
			<div class="kit-login-wapper">
				<h1 class="kit-login-slogan">欢迎使用 <br>教务管理系统</h1>
				<div class="kit-login-form">
					<h4 class="kit-login-title">用户登录</h4>
					<form class="layui-form" action="${pageContext.request.contextPath}/students/login.do"  method="post">
						<div class="kit-login-row">
							<div class="kit-login-col">
								<i class="layui-icon">&#xe63b;</i>
								<span class="kit-login-input">
                <input name="name" type="text" maxlength="12" lay-verify="required" placeholder=" 请输入账号" v-model="name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'User Id';}" value="User Id"/>
              </span>
							</div>
							<div class="kit-login-col"></div>
						</div>
						<div class="kit-login-row">
							<div class="kit-login-col">
								<i class="layui-icon">&#xe642;</i>
								<span class="kit-login-input">
                <input type="password" name="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'password';}" value="password" maxlength="12" lay-verify="required" placeholder=" 请输入密码" v-model="password"/>
              </span>
							</div>
							<div class="kit-login-col"></div>
						</div>
						<div class="kit-login-row">
							<button class="layui-btn kit-login-btn" type="submit" lay-filter="login_hash" @click="denglv">登  录</button>
						</div>
					</form>
				</div>
			</div>
		</div>

  </body>
</html>
