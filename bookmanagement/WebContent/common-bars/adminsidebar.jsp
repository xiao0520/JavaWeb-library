<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	
</head>
<body>
	   <div class="left">
            <div class="title">M A I N</div>
            <ul>
                <li><a href="/bookmanagement/adminpage/welcome.jsp" class="icon-1"><span>首页</span></a></li>
                <li><a href="/bookmanagement/student/findAllStudent" class="icon-2"><span>学生管理</span></a></li>
                <li><a href="/bookmanagement/book/findAllBook?admin=true&startIndex=0" class="icon-3"><span>图书管理</span></a></li>
                <li><a href="/bookmanagement/bookshelf/findAllBookshelf" class="icon-4"><span>书架管理</span></a></li>
                <li><a href="/bookmanagement/major/findAllMajor" class="icon-5"><span>专业管理</span></a></li>
                <li><a href="/bookmanagement/department/findAllDepartment" class="icon-6"><span>院系管理</span></a></li>
                <li><a href="/bookmanagement/admin/findAllStudentFineInfo" class="icon-7"><span>学生罚款账单</span></a></li>
                <li><a href="/bookmanagement/adminpage/givenotice.jsp"  class="icon-8"><span>下达通知</span></a></li>
                <li><a href="/bookmanagement/admin/toUserFeedbackPage" class="icon-9"><span>用户反馈</span></a></li>
                <li><a href="#" class="icon-10"><span>设置</span></a></li>
            </ul>
        </div>
</body>
</html>