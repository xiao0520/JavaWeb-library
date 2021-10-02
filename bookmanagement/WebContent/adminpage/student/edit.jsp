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

        	    <a class="btn-add" href="/bookmanagement/student/toAddStudentPage">添加</a>
	            <form action="/bookmanagement/student/updateStudent" class="form" method="post">
	
		            <div>
	                    <input type="hidden"  class="form-input" name="originalStudentNo" value="${originalStudentNo}"/>
	                </div>
	                
	                <div>
	                	学号
	                    <input type="number"  class="form-input" name="no" value="${student.no}"/>
	                </div>
	                <div>
	                	姓名
	                    <input type="text" class="form-input" name="name" value="${student.name}"/>
	                </div>
	                <div>
	                	年龄
	                    <input type="text" class="form-input" name="age" value="${student.age}"/>
	                </div>
	               <div>
	               		性别
	                    <input type="text" class="form-input" name="sex" value="${student.sex}"/>
	                </div>
	                <div>
	                	电话
	                    <input type="text" class="form-input" name="tel" value="${student.telephone}"/>
	                </div>
	                 <div>
	                  	专业
	                  	<select name="major" class="form-input">
	                    	<c:forEach items="${allMajor}" var="major">
	                        	<option value="${major.name}" ${major.name == student.major ?  "selected" :""}>${major.name}</option>
	                        </c:forEach>
	                    </select>
	                </div>
	                <div>
	                    <input type="submit" class="btn" value="修改">
	                </div>
	 
	            </form>

            
        </div>
        
    </div>
</body>
</html>