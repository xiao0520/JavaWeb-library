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
                <li><a href="/bookmanagement/studentpage/welcome.jsp" class="icon-1"><span>首页</span></a></li>
                <li><a href="/bookmanagement/book/findAllBook?admin=false&startIndex=0" class="icon-2"><span>查询图书</span></a></li>
                <li><a href="/bookmanagement/book/findCanReserveBook" class="icon-3"><span>预约图书</span></a></li>
                <li><a href="/bookmanagement/log/findAllBorrowBook" class="icon-4"><span>查已借阅</span></a></li>
                <li><a href="/bookmanagement/log/findFine" class="icon-5"><span>罚款记录</span></a></li>
                <li><a href="/bookmanagement/log/findAllReserveBook" class="icon-6"><span>查已预约</span></a></li>
                <li><a href="/bookmanagement/log/toSendLetterPage" class="icon-7"><span>发邮件</span></a></li>
                <li><a href="/bookmanagement/log/findAllMessage" class="icon-8"><span>收件箱</span></a></li>
                <li><a href="/bookmanagement/log/toSystemFeedbackPage" class="icon-9"><span>系统反馈</span></a></li>
                <li><a href="/bookmanagement/log/toEditPasswordPage" class="icon-10"><span>设置</span></a></li>
            </ul>
        </div>
</body>
</html>