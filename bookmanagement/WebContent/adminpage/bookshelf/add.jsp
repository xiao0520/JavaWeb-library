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
	            <form action="/bookmanagement/bookshelf/insertBookshelf" class="form" method="post">
	            
	                <div>
	                	书架编号
	                    <input type="text"  class="form-input" name="no" required="required" placeholder="xxxxxx"/>
	                </div>
	                <div>
						占地面积
	                    <input type="text" class="form-input" name="area" required="required" placeholder="xxxxxx"/>
	                </div>
	                <div>
	                	书架位置
	                    <input type="text" class="form-input" name="location" required="required" placeholder="xxxxxx"/>
	                </div>
	               <div>
	               		书架种类
	                    <input type="text" class="form-input" name="type" required="required" placeholder="xxxxxx"/>
	                </div>
	                <div>
	                	书架简介
	                    <input type="text" class="form-input" name="remark" required="required" placeholder="xxxxxx"/>
	                </div>
	                 
	                <div>
	                    <input type="submit" class="btn" value="确定">
	                </div>
	 
	            </form>
	            

            
        </div>
        
    </div>
</body>
</html>