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
     <title>My JSP 'showAll.jsp' starting page</title>
	 <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" >
  </head>
  
  <body>
  <br/>
  <h2>当前学生信息</h2><br>
  <form action="${pageContext.request.contextPath}/students/findByName.do">
  		<div class="layui-form-item">
	  	<label class="layui-form-label">查询学生</label>
	 	 <div class="layui-input-inline">
			  <input type="text" name="name" lay-verify="required" placeholder="请输入学生姓名" autocomplete="off" class="layui-input">
		 </div>
			<button class="layui-btn" lay-submit="">查询</button>
		</div>
</form>
  <hr/>
  <br>
  <div class="layui-form layui-border-box layui-table-view" lay-filter="LAY-table-1"
		style="height:232px;">
	   <div class="layui-table-box">
		   <div class="layui-table-header">
			   <table cellspacing="0" cellpadding="0" border="0" class="layui-table">
				   <thead>
					   <th data-field="id">
						   <div class="layui-table-cell laytable-cell-1-id">
                               <span>ID</span>
                               <span class="layui-table-sort layui-inline">
                                 <i class="layui-edge layui-table-sort-asc"></i>
	                             <i class="layui-edge layui-table-sort-desc"></i>
                               </span></div>
					   </th>
					   <th data-field="username">
						   <div class="layui-table-cell laytable-cell-1-username"><span>姓名</span></div>
					   </th>
					   <th data-field="sex">
						   <div class="layui-table-cell laytable-cell-1-sex"><span>性别</span><span
								   class="layui-table-sort layui-inline"></span></div>
					   </th>
					   <th data-field="city">
						   <div class="layui-table-cell laytable-cell-1-city"><span>出生日期</span></div>
					   </th>
						<th data-field="city">
						   <div class="layui-table-cell laytable-cell-1-email"><span>邮箱地址</span></div>
					   </th>
					   <th data-field="experience">
						   <div class="layui-table-cell laytable-cell-1-experience"><span>学期</span><span
								   class="layui-table-sort layui-inline"><i class="layui-edge layui-table-sort-asc"></i><i
								   class="layui-edge layui-table-sort-desc"></i></span></div>
					   </th>
					   <th data-field="classify">
						   <div class="layui-table-cell laytable-cell-1-classify"><span>学年</span></div>
					   </th>
					   <th data-field="wealth">
						   <div class="layui-table-cell laytable-cell-1-wealth"><span>电话</span><span
								   class="layui-table-sort layui-inline"><i class="layui-edge layui-table-sort-asc"></i><i
								   class="layui-edge layui-table-sort-desc"></i></span></div>
					   </th>
					   <th data-field="score">
						   <div class="layui-table-cell laytable-cell-1-score"><span>专业</span><span
								   class="layui-table-sort layui-inline"><i class="layui-edge layui-table-sort-asc"></i><i
								   class="layui-edge layui-table-sort-desc"></i></span></div>
					   </th>
					   <th data-field="10">
						   <div class="layui-table-cell laytable-cell-1-10" align="center"><span>操作</span></div>
					   </th>
				   </tr>
				   </thead>
			   </table>
		   </div>


		   <div class="layui-table-body layui-table-main" style="height: 252px;">
			   <table cellspacing="0" cellpadding="0" border="0" class="layui-table">
                    <c:forEach items="${pager.pageItems}" var="stu" >
					   <td data-field="id">
						   <div class="layui-table-cell laytable-cell-1-id">${stu.id}</div>
					   </td>
					   <td data-field="username">
						   <div class="layui-table-cell laytable-cell-1-username">${stu.name}</div>
					   </td>
					   <td data-field="sex">
						   <div class="layui-table-cell laytable-cell-1-sex">${stu.genderName}</div>
					   </td>
					   <td data-field="city">
						   <div class="layui-table-cell laytable-cell-1-city">${stu.birthday}</div>
					   </td>
					   <td data-field="city">
						   <div class="layui-table-cell laytable-cell-1-email">${stu.email}</div>
					   </td>
					   <td data-field="experience">
						   <div class="layui-table-cell laytable-cell-1-experience">${stu.schoolTerm}</div>
					   </td>
					   <td data-field="classify">
						   <div class="layui-table-cell laytable-cell-1-classify">${stu.schoolYear}</div>
					   </td>
					   <td data-field="wealth">
						   <div class="layui-table-cell laytable-cell-1-wealth">${stu.tellphone}</div>
					   </td>
					   <td data-field="score">
						   <div class="layui-table-cell laytable-cell-1-score">${stu.majorName}</div>
					   </td>
					   <td data-field="10" align="center" data-off="true">
						   <div class="layui-table-cell laytable-cell-1-10">
								   <a class="layui-btn layui-btn-xs" href="${pageContext.request.contextPath}/students/preModifyStudents.do?id=${stu.id}">编辑</a>
							   <a class="layui-btn layui-btn-danger layui-btn-xs" href="${pageContext.request.contextPath}/students/delStudents.do?id=${stu.id}" onclick="return confirmd()">删除</a>
						   </div>
					   </td>
				            </tr>
                   </c:forEach>

                </table>
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
	   <style>
	   .laytable-cell-1-0 {
		   width: 48px;
	   }
	   .laytable-cell-1-id {
		   width: 80px;
	   }
	   .laytable-cell-1-username {
		   width: 100px;
	   }
	   .laytable-cell-1-sex {
		   width: 80px;
	   }
	   .laytable-cell-1-city {
		   width: 110px;
	   }
	   .laytable-cell-1-email {
		   width: 150px;
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
		   width: 129px;
	   }
	   .laytable-cell-1-10 {
		   width: 178px;
	   }
	   </style>
    </div>
   </div>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" >


 <%-- <c:if test="${pager.page > 1}">
	  <a href="findForPager.do?page=${pager.page-1}&perPage=${pager.perPage}">上一页</a>
  </c:if>
  <c:if test="${pager.page<pager.pageCount}">
	  <a href="findForPager.do?page=${pager.page+1}&perPage=${pager.perPage}">下一页</a>
  </c:if>

  --%>
  <div id="demo0">
	  <div class="layui-box layui-laypage layui-laypage-default" id="layui-laypage-1">
		<c:if test="${pager.page > 1}">
		  <a href="${pageContext.request.contextPath}/students/findForPager.do?page=${pager.page-1}&perPage=${pager.perPage}"class="layui-laypage-prev" >上一页</a>
		</c:if>
		<c:forEach begin="1" end="${pager.pageCount}" var="i">
		  <a  href="${pageContext.request.contextPath}/students/findForPager.do?page=${i}&perPage=${pager.perPage}" >${i}</a>
		</c:forEach>
		<c:if test="${pager.page<pager.pageCount}">
		  <a href="${pageContext.request.contextPath}/students/findForPager.do?page=${pager.page+1}&perPage=${pager.perPage}" class="layui-laypage-next">下一页</a>
		</c:if>
	  </div>
  </div>

  </body>
</html>
