<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="../static/css/base.css">
    <link rel="stylesheet" href="../static/css/inner.css">
    <link rel="stylesheet" href="../static/fonts/iconfont.css">
    <link rel="shortcut icon" href="../static/img/bitbug_favicon.ico">

</head>


<body>

	<%@ include file="/common-bars/topbar.jsp" %>
	
    <div class="main">
    
   		<%@ include file="/common-bars/adminsidebar.jsp" %>
   	
        <div class="right">
        
            <table class="table">
            
                <thead>
                    <tr>
                        <th>发送方</th>
                        <th>姓名</th>
                        <th>专业</th>
                        <th>院系</th>
                        <th>发送时间</th>
                        <th>消息内容</th>
                        <th>操作</th>
                    </tr>
                </thead>
                
                <tbody>
                
                	 <c:forEach items="${allMessage}" var="message">
       					 <tr>
				            <td>${message.sender}</td>
				            <td>${message.senderName}</td>
				            <td>${message.senderMajor}</td>
				            <td>${message.senderDepartment}</td>
				            <td>${message.time}</td>
				            
				            <td><a class="btn" href="/bookmanagement/admin/toOneConcreteFeedbackPage?senderName=${message.senderName}&time=${message.time}&message=${message.message}">查看</a></td> 
				            <td><a class="btn" href="/bookmanagement/admin/deleteOneFeedback?senderNo=${message.sender}&message=${message.message}">删除</a></td> 
               			</tr>
           			 </c:forEach>
           			 
                </tbody>
            </table>
            
        </div>
        
    </div>
</body>
</html>