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
    <title>添加专业</title>
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
  <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
      <legend>专业设置</legend>
  </fieldset>
    <form class="layui-form" action="${pageContext.request.contextPath}/students/addMajor.do">
      <div class="layui-form-item">
          <label class="layui-form-label">专业名称：</label>
          <div class="layui-input-inline">
              <input type="text" name="name" lay-verify="required" autocomplete="off" class="layui-input">
          </div>
      </div>
      <div class="layui-form-item">
          <label class="layui-form-label">专业描述：</label>
          <div class="layui-input-inline">
              <input type="text" name="desc" lay-verify="required" autocomplete="off" class="layui-input">
          </div>
      </div>
     
      <div class="layui-form-item">
          <div class="layui-inline">
              <label class="layui-form-label">设立学院</label>
              <div class="layui-input-inline">
                  <select name="academyId">
                      <c:forEach var="list" items="${majorList}">
                          <option value="${list.id }">${list.name}</option>
                      </c:forEach>
                  </select>
              </div>
          </div>
          <div class="layui-form-item">
              <div class="layui-input-block">
              	  <input class="layui-btn" type="submit" value="添加">	
                  <!-- <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button> -->
                  <button type="reset" class="layui-btn layui-btn-primary">重置</button>
              </div>
          </div>
      </div>
  </form>
  <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
  <!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
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

         /* //自定义验证规则
          form.verify({
              title: function(value){
                  if(value.length < 5){
                      return '标题至少得5个字符啊';
                  }
              }
              ,pass: [/(.+){6,12}$/, '密码必须6到12位']
              ,content: function(value){
                  layedit.sync(editIndex);
              }
          });*/

          /*//监听指定开关
          form.on('switch(switchTest)', function(data){
              layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
                  offset: '6px'
              });
              layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
          });*/

          /* //监听提交
           form.on('submit(demo1)', function(data){
               layer.alert(JSON.stringify(data.field), {
                   title: '最终的提交信息'
               })
               return false;
           });*/

      });
  </script>
  </body>
</html>
