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
                        <th>图书编号</th>
                        <th>图书名称</th>
                        <th>作者</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>所属书架</th>
                        <th>简介</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                
                	 <c:forEach items="${allBook}" var="book">
       					 <tr>
				            <td>${book.no}</td>
				            <td>${book.name}</td> 
                			<td>${book.author}</td>
                			<td>${book.price}</td>
                			<td>${book.num}</td>
                			<td>${book.shelf}</td>
               				<td>${book.remark}</td>
               				<td>
                            	<a class="btn" href="/bookmanagement/book/toEditBookPage?originalBookNo=${book.no}">编辑</a>
                            	<a class="btn" href="/bookmanagement/book/deleteBookByNo?bookNo=${book.no}">删除</a>
                        	</td>
               			</tr>
           			 </c:forEach>
           			 
                </tbody>
            </table>
            
        </div>
        
         <div class="cut">
            <ul>
                <li><a href="/bookmanagement/book/findAllBook?admin=true&startIndex=0">1</a></li>
                <li><a href="/bookmanagement/book/findAllBook?admin=true&startIndex=9">2</a></li>
                <li><a href="/bookmanagement/book/findAllBook?admin=true&startIndex=18">3</a></li>
                <li><a href="/bookmanagement/book/findAllBook?admin=true&startIndex=27">4</a></li>
                <li><a href="/bookmanagement/book/findAllBook?admin=true&startIndex=36">5</a></li>
        	</ul>
    	</div>
        
    </div>
</body>
</html>