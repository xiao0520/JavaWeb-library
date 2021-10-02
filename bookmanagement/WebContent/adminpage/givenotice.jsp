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

	            <form action="/bookmanagement/log/insertSystemNotice" class="form" method="post">
	
	               <div>
	                	具体的信息
	                    <textarea rows="" cols="" maxlength="254" class="textarea" name="message"></textarea>
	                </div>
	                
	                <div>
	                    <input type="submit" class="btn" value="通知">
	                </div>
	                
					 <c:if test="${success != null}"><div class="tip">发送成功!</div></c:if>
					 
	            </form>

        </div>
        
    </div>
</body>
</html>