<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="/bookmanagement/static/css/base.css">
    <link rel="stylesheet" href="/bookmanagement/static/css/inner.css">
    <link rel="stylesheet" href="/bookmanagement/static/fonts/iconfont.css">
    <link rel="shortcut icon" href="/bookmanagement/static/img/bitbug_favicon.ico">
    
</head>

<body>

	<%@ include file="/common-bars/topbar.jsp" %>
	
    <div class="main">
    
   		<%@ include file="/common-bars/adminsidebar.jsp" %>
   	
        <div class="right" style="width: 1211px;">
        
            <table class="table">
                <thead>
                    <tr>
                        <th>院系编号</th>
                        <th>院系名称</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                
                	 <c:forEach items="${allDepartment}" var="department">
       					 <tr>
				            <td>${department.no}</td>
				            <td>${department.name}</td> 
               				<td>
                            	<a class="btn" href="/bookmanagement/department/toEditDepartmentPage?originalDepartmentNo=${department.no}">编辑</a>
                            	<a class="btn" href="/bookmanagement/department/deleteDepartmentByNo?departmentNo=${department.no}">删除</a>
                        	</td>
               			</tr>
           			 </c:forEach>
           			 
                </tbody>
            </table>
            
        </div>
       
        
    </div>
</body>
</html>