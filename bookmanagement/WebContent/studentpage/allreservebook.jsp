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
    
   		<%@ include file="/common-bars/studentsidebar.jsp" %>
   	
        <div class="right">
        
            <table class="table">
            
                <thead>
                    <tr>
                        <th>图书编号</th>
                        <th>图书名称</th>
                        <th>作者</th>
                        <th>价格</th>
                        <th>剩余数量</th>
                        <th>类型</th>
                        <th>书籍位置</th>
                        <th>操作</th>
                    </tr>
                </thead>
                
                <tbody>

                
                	 <c:forEach items="${allReserveBook}" var="book">
       					 <tr>
				            <td>${book.bookNo}</td>
				            <td>${book.bookName}</td> 
                			<td>${book.bookAuthor}</td>
                			<td>${book.bookPrice}</td>
                			<td>${book.bookNum}</td>
                			<td>${book.bookType}</td>
               				<td>${book.bookLocation}</td>

               				<td>
                    
               					<a class="btn" href="/bookmanagement/book/findAllBook?admin=false&startIndex=0">借阅</a>          
               					<a class="btn" href="/bookmanagement/log/cancelReserveBook?bookNo=${book.bookNo}">取消</a>                           	
                        	</td>
                        	
               			</tr>
           			 </c:forEach>
                </tbody>
                
            </table>
            
        </div>
        
    </div>
</body>
</html>