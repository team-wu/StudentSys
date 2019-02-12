<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
  <meta charset="utf-8">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'modifystudent.jsp' starting page</title>
    
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
      <legend>修改学生信息</legend>
  </fieldset>
 <%--  <%
  	String id=request.getParameter("id");
  	String name=request.getParameter("name");
  	String birthday=request.getParameter("birthday");
  	String schoolTerm=request.getParameter("schoolTerm");
  	String schoolYear=request.getParameter("schoolYear");
  	String tellphone=request.getParameter("tellphone");
  	String email = request.getParameter("email");
  %> --%>
 
  <form class="layui-form" action="${pageContext.request.contextPath}/students/modifyStudents.do" style="padding-top: 26px">
     
      <div class="layui-form-item">
          <label class="layui-form-label">学生姓名</label>
          <div class="layui-input-inline">
              <input type="text" name="name" lay-verify="required" value="${student.name }" autocomplete="off" class="layui-input">
          </div>
      </div>
      <div class="layui-form-item">
          <label class="layui-form-label">性别</label>
          <div class="layui-input-block">
              <input type="radio" name="gender" value="1" title="男"  ${student.gender==1?'checked':'' }>
              <input type="radio" name="gender" value="2" title="女" ${student.gender==2?'checked':'' }>
          </div>
      </div>
      <div class="layui-form-item">
          <div class="layui-inline">
              <label class="layui-form-label">联系方式</label>
              <div class="layui-input-inline">
                  <input type="tel" name="tellphone" value="${student.tellphone }" lay-verify="required|phone" autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-inline">
              <label class="layui-form-label">出生日期</label>
              <div class="layui-input-inline">
                  <input type="text" name="birthday" value="${student.birthday }" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
              </div>
          </div>
      </div>
		<div class="layui-form-item">
          <div class="layui-inline">
              <label class="layui-form-label">邮箱地址</label>
              <div class="layui-input-inline">
                  <input type="text" name="email" lay-verify="required|email" value="${student.email }" autocomplete="off" class="layui-input">
              </div>
          </div>
          </div>
      <div class="layui-form-item">
          <div class="layui-inline">
              <label class="layui-form-label">所属学年</label>
              <div class="layui-input-inline">
                  <input type="text" name="schoolYear" value="${student.schoolYear }" lay-verify="required|number" autocomplete="off" class="layui-input">
              </div>
          </div>
      </div>

      <div class="layui-form-item">
          <div class="layui-inline">
              <label class="layui-form-label">所属学期</label>
              <div class="layui-input-inline">
                  <input type="text" name="schoolTerm" value="${student.schoolTerm }" lay-verify="required|number" autocomplete="off" class="layui-input">
              </div>
          </div>
      </div>
      <div class="layui-form-item">
          <div class="layui-inline">
              <label class="layui-form-label">所选专业</label>
              <div class="layui-input-inline">
                  <select name="majorId">
                      <c:forEach var="major" items="${mojorList}" >
                          <option	value="${major.id}" ${major.id==student.majorId?'selected':'' }>${major.name}</option>
                      </c:forEach>
                  </select>
              </div>
          </div>
      </div>
      <div class="layui-form-item">
          <div class="layui-input-block">
          	  <input class="layui-btn" type="submit" value="修改"  >	
               <input type="hidden" name="id" value="${student.id }" >
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
