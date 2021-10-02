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

        	    <a class="btn-add" href="/bookmanagement/book/toAddBookPage">添加</a>
	            <form action="/bookmanagement/book/updateBook" class="form" method="post">
	            	            
	            	<div>
	                    <input type="hidden"  class="form-input" name="originalBookNo" value="${originalBookNo}"/>
	                </div>
	
	                <div>
	                	书名
	                    <input type="text"  class="form-input" name="no" value="${book.no}"/>
	                </div>
	                <div>
	                	书号
	                    <input type="text" class="form-input" name="name" value="${book.name}"/>
	                </div>
	                <div>
	                	作者
	                    <input type="text" class="form-input" name="author" value="${book.author}"/>
	                </div>
	               <div>
	               		价格
	                    <input type="text" class="form-input" name="price" value="${book.price}"/>
	                </div>
	                <div>
	                	数量
	                    <input type="text" class="form-input" name="num" value="${book.num}"/>
	                </div>
	                 <div>
	                  	书架
	                  	<select name="shelf" class="form-input">
	                    	<c:forEach items="${allBookshelf}" var="bookshelf">
	                        	<option value="${bookshelf.no}" ${book.shelf == bookshelf.no ?  "selected" :""}>${bookshelf.no}</option>
	                        </c:forEach>
	                    </select>
	                </div>
	               <div>
	                	简介
	                    <input type="text" class="form-input" name="remark" value="${book.remark}"/>
	                </div>
	                <div>
	                    <input type="submit" class="btn" value="修改">
	                </div>
	 
	            </form>

            
        </div>
        
    </div>
</body>
</html>