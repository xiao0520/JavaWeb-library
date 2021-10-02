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

        	    <a class="btn-add" href="/bookmanagement/bookshelf/toAddBookshelfPage">添加</a>
	            <form action="/bookmanagement/bookshelf/updateBookshelf" class="form" method="post">
	            
	            	<div>
	                    <input type="hidden"  class="form-input" name="originalBookshelfNo" value="${originalBookshelfNo}"/>
	                </div>
	            
	                <div>
	                	书架编号
	                    <input type="text"  class="form-input" name="no" value="${bookshelf.no}"/>
	                </div>
	                <div>
						占地面积
	                    <input type="text" class="form-input" name="area" value="${bookshelf.area}"/>
	                </div>
	                <div>
	                	书架位置
	                    <input type="text" class="form-input" name="location" value="${bookshelf.location}"/>
	                </div>
	               <div>
	               		书架种类
	                    <input type="text" class="form-input" name="type" value="${bookshelf.type}"/>
	                </div>
	                <div>
	                	书架简介
	                    <input type="text" class="form-input" name="remark" value="${bookshelf.remark}"/>
	                </div>
	                 
	                <div>
	                    <input type="submit" class="btn" value="修改">
	                </div>
	 
	            </form>
	            

            
        </div>
        
    </div>
</body>
</html>