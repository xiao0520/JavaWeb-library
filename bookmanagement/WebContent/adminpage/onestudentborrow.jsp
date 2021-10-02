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
                        <th>图书编号</th>
                        <th>图书名称</th>
                        <th>作者</th>
                        <th>价格</th>
                        <th>借阅时间</th>
                        <th>到期时间</th>
                        <th>类型</th>
                        <th>书籍位置</th>
                        <th>续借</th>

                    </tr>
                </thead>
                <tbody>

                
                	 <c:forEach items="${allBorrowBook}" var="book">
       					 <tr>
				            <td>${book.bookNo}</td>
				            <td>${book.bookName}</td> 
                			<td>${book.bookAuthor}</td>
                			<td>${book.bookPrice}</td>
                			<td>${book.borrowDate}</td>
                			<td>${book.backDate}</td>
                			<td>${book.bookType}</td>
               				<td>${book.bookLocation}</td>
               				<c:if test="${book.renew == 1}"><td>已续借</td></c:if>
               				<c:if test="${book.renew == 0}"><td>未续借</td></c:if>
               				
               			</tr>
           			 </c:forEach>
           			 
                </tbody>
            </table>
            
        </div>
        
    </div>
</body>
</html>