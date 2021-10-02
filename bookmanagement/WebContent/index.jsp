<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书馆理系统登录</title>

	<style>
        * {
            margin: 0;
            padding: 0;
        }

        em,
        i {
            font-style: normal
        }

        li {
            list-style: none
        }

        img {
            border: 0;
            vertical-align: middle
        }

        button {
            cursor: pointer
        }

        a {
            color: #666;
            text-decoration: none
        }

 
        button,
        input {
            font-family: Microsoft YaHei, Heiti SC, tahoma, arial, Hiragino Sans GB, "\5B8B\4F53", sans-serif
        }

        .hide,
        .none {
            display: none
        }

        .clearfix:after {
            visibility: hidden;
            clear: both;
            display: block;
            content: ".";
            height: 0
        }

     


        body {
            width: 100%;
            height: 100%;
            background: url(/bookmanagement/static/img/1.jpg) no-repeat center top;
            background-size: 100%;
            font: 12px/1.5 Microsoft YaHei, Heiti SC, tahoma, arial, Hiragino Sans GB, "\5B8B\4F53", sans-serif;
            color: #666
     
        }

        .father {

            position: relative;
            width: 850px;
            height: 550px;
            background-color: rgba(200, 200, 200, 0.3);

            border-radius: 50px;

            box-shadow: 0 0 10px #009dfd;
            margin: 100px auto;

            transition: all 1s;
        }

        .penguin {

            position: absolute;
            width: 220px;
            height: 314px;
            left: 82px;
            top: 115px;

        }

        .penguin img {
            border-radius: 10px;
            transition: all 0.4s;
        }
        
        .error {
            
            position: absolute;
            width: 300px;
            height: 30px;
            text-align: center;
            line-height: 30px;
            font-size: 18px;
            top: 190px;
            right: 160px;
            color: red;
        }

        .login {

            position: absolute;
            width: 470px;
            height: 450px;
            right: 28px;
            top: 50px;
            border-radius: 25px;
            /* box-shadow: 0 0 10px #009dfd; */
            padding-left: 80px;
            padding-top: ;
        }

        .tip {
            width: 300px;
            height: 100px;
            text-align: center;
            line-height: 100px;
            font-size: 30px;
            margin-top: 40px;
            margin-left: 40px;
            color: #009dfd;
        }

        .form {

            width: 200px;
            height: 100px;
            margin-top: 40px;
            margin-left: 40px;

        }

        .form-input {

            width: 300px;
            height: 30px;

            text-indent: 10px;

            border: 0;
            border-radius: 15px;

            margin-bottom: 10px;

            transition: all 0.5s;
        }

        .btn {
            width: 300px;
            height: 48px;
            color: #fff;
            background-color: #007bff;
            font-size: 20px;
            border: 0;
            border-radius: 24px;
            margin-top: 10px;
            cursor: pointer;

 
            transition: all 0.5s;
        }

        .register {
            display: block;
            float:right;
            width: 100px;
            height: 30px;
            color: #fff;
            background-color: #009dfd;
            text-align: center;
            line-height: 30px;
            font-size: 20px;
            border: 0;
            margin-top: 20px;
            margin-right: 40px;
            border-radius: 20px;
      		cursor: pointer;

            transition: all 0.5s;
        }

        .last {
            width: 300px;
            height: 48px;
            text-align: center;
            line-height: 48px;
            font-size: 20px;
            border: 0;
            border-radius: 15px;
            margin-top: 40px;
            color: #007bff;
        }

     

        .register:hover {
            background: linear-gradient(145deg, #755bcb, #8b6cf2);
            box-shadow: 0 0 8px #fff;
        }

        .father:hover {

            box-shadow: 0 0 10px #007bff;
            background-color: rgba(0, 0, 0, 0.8);
        }

        .form-input:hover {

            box-shadow: 0 0 10px #fff;
        }

        .btn:hover {

             box-shadow: 0 0 10px #fff;
        }

        .penguin img:hover {
            transform: scale(1.1);
        }

    </style>
    
</head>
<body>

    <div class="father">

        <div>
            <a class="register" href="/bookmanagement/register.jsp">
               	 注册
            </a>
        </div>

        <div class="penguin"><img src="/bookmanagement/static/img/penguin.png" alt=""></div>

        <c:if test="${requestScope.message != null}">
                <div class="error">${requestScope.message}</div>
        </c:if>

        <div class="login">
            <div class="tip">
                <p>图书管理系统</p>
            </div>
            <form action="/bookmanagement/login/login" class="form">
                <div>
                    <select name="identity" class="form-input">
                        <option selected="selected" value="admin">管理员</option>
                        <option value="student">学生</option>
                    </select>
                </div>
                <div>
                    <input type="text" class="form-input" name="username" required="required" placeholder="Username" />
                </div>
                <div>
                    <input type="password" class="form-input" name="password" required="required" placeholder="password" />
                </div>
                <div>
                    <input type="submit" class="btn" value="登录">
                </div>
                <div class="last">
                    <p>如有问题请联系设计人员 QQ:3126439801</p>
                </div>
            </form>

        </div>
    </div>


</body>
</html>