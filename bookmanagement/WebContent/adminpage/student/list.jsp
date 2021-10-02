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
   	
        <div class="right">
        
            <table class="table">
                <thead>
                    <tr>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>年龄</th>
                        <th>性别</th>
                        <th>手机号</th>
                        <th>专业</th>
                        <th>操作</th>
                        <th>借书信息</th>
                    </tr>
                </thead>
                <tbody>
                
                	 <c:forEach items="${allStudent}" var="student">
       					 <tr>
				            <td>${student.no}</td>
				            <td>${student.name}</td> 
                			<td>${student.age}</td>
                			<td>${student.sex}</td>
                			<td>${student.telephone}</td>
                			<td>${student.major}</td>   
                			<td>
                				<a class="btn" href="/bookmanagement/student/toEditStudentPage?originalStudentNo=${student.no}">编辑</a>
                				<a class="btn" href="/bookmanagement/student/deleteStudentByNo?studentNo=${student.no}">删除</a>
                			</td>  	
                			<td>
                				<a class="btn" href="/bookmanagement/admin/findStudentBorrowBookByNo?studentNo=${student.no}">查看</a>
                			</td>			
               			</tr>
           			 </c:forEach>
           			 
                </tbody>
            </table>
            
        </div>
        
    </div>
</body>
</html>