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
        	    <a class="btn-add" href="/bookmanagement/department/toAddDepartmentPage">添加</a>
	            <form action="/bookmanagement/department/insertDepartment" class="form" method="post">
	            
	                <div>
	                	院系编号
	                    <input type="text"  class="form-input" name="no" required="required" placeholder="xxx"/>
	                </div>
	                <div>
						院系名称
	                    <input type="text" class="form-input" name="name" required="required" placeholder="xxx"/>
	                </div>

	                <div>
	                    <input type="submit" class="btn" value="修改">
	                </div>
	 
	            </form>
	            

            
        </div>
        
    </div>
</body>
</html>