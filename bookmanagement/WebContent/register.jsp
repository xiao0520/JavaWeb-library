<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>注册新用户</title>
    <link rel="stylesheet" href="/bookmanagement/static/css/base.css">
    <link rel="stylesheet" href="/bookmanagement/static/css/register.css">
</head>

<body>

    <div class="w">
    
        <header>
            <div class="logo">
                <a href="/bookmanagement/index.jsp" title="返回主页"><img src="/bookmanagement/static/img/book.jpg" alt="error"></a>
            </div>
        </header>
        
        <div class="registerarea">
        
            <h3>
                             注册新用户
                <div class="login">我有账号，去<a href="/bookmanagement/index.jsp">登录</a></div>
            </h3>
            
            <div class="reg-form">
            
                <form action="/bookmanagement/login/register" method="POST">
                    <ul>
                        <li><label for="">学生证号&nbsp;&nbsp; </label><input type="number" name="studentNo" class="inp" required></li>
                        <li><label for="">用户名  &nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="username" class="inp" required></li>
                        <li><label for="">登录密码&nbsp;&nbsp;  </label><input type="password" name="password" class="inp" required></li>
                        <li class="safe">安全程度  <em class="ruo">弱</em><em class="zhong">中</em><em class="qiang">强</em></li>
                        
                        <li><label for="">确认密码&nbsp;&nbsp;</label><input type="password" name="passwordAgain" class="inp" required></li>
                        <li class="agree"><input type="checkbox" name="" id="">&nbsp;同意协议并注册<a href="useagreement.jsp">(用户使用协议)</a></li>
                        
                        <c:if test="${requestScope.message != null}"><li style="color: red; text-align: center; width: 690px;"> ${requestScope.message}</li></c:if>
                        
                        <li><input type="submit" value="提交注册" class="btn" style="margin-top: 0;"></li>
                    </ul>
                </form>
                
            </div>
        </div>
    </div>
</body>
</html>