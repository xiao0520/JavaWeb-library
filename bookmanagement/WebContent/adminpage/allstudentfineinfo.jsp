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
                        <th>所欠金额</th>
                        <th>操作</th>
                    </tr>
                </thead>
                
                <tbody>
                
                	 <c:forEach items="${allFineInfo}" var="fineInfo">
       					 <tr>
				            <td>${fineInfo.studentNo}</td>
				            <td>${fineInfo.studentName}</td> 
                			<td>${fineInfo.studentAge}</td>
                			<td>${fineInfo.studentSex}</td>
                			<td>${fineInfo.studentTelephone}</td>
                			<td>${fineInfo.studentMajor}</td>   
                			<td>${fineInfo.fineMoney}</td>   
		                	<td><a class="btn" href="/bookmanagement/admin/urgeOneUserPayback?studentNo=${fineInfo.studentNo}">催促</a></td>
               			</tr>
           			 </c:forEach>
           			 
                </tbody>
                
            </table>
            
        </div>
        
    </div>
</body>
</html>