<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>预定图书</title>
    <link rel="stylesheet" href="../static/css/base.css">
    <link rel="stylesheet" href="../static/css/inner.css">
    <link rel="stylesheet" href="../static/fonts/iconfont.css">
    <link rel="shortcut icon" href="../static/img/bitbug_favicon.ico">
</head>

<body>

	<%@ include file="/common-bars/topbar.jsp" %>
	
    <div class="main">
    
   		<%@ include file="/common-bars/studentsidebar.jsp" %>
   	
        <div class="right">
        
            <table class="table">
            
                <thead>
                    <tr>
                        <th>图书编号</th>
                        <th>图书名称</th>
                        <th>作者</th>
                        <th>价格</th>
                        <th>所属书架</th>
                       	<th>类型</th>
                        <th>位置</th>
                        <th>操作</th>
                    </tr>
                </thead>
                
                <tbody>
                
                	 <c:forEach items="${canReserveBook}" var="book">
       					 <tr>
				            <td>${book.no}</td>
				            <td>${book.name}</td> 
                			<td>${book.author}</td>
                			<td>${book.price}</td>
                			<td>${book.shelf}</td>
               				<td>${book.bookType}</td>
               				<td>${book.bookLocation}</td>
               				<td>
                            	<a class="btn" href="/bookmanagement/log/reserveBookByNo?bookNo=${book.no}">预约</a>
                        	</td>
               			</tr>
           			 </c:forEach>
           			 
                </tbody>
            </table>
            
        </div>
        
    </div>
</body>
</html>