<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
   	
   	
        <div class="fineright">
        
			<div class="message">
				 <c:if test="${fineMoney != null}">
               		 大事不好了! 好兄弟你欠了整整${fineMoney}元 再不还工作人员张伟就要打电话找你了! 
               		 右边是恐怖张伟的微信和支付宝的付款码 快抓紧机会啊 只能帮你到这里了!
               		 <div class="scare"><img alt="" src="../static/img/scare.jpg"></div>
		        </c:if>
		        <c:if test="${fineMessage != null}">
               		 不会吧不会吧，不会真的有人从来没有违规过吧 不会这个人就是你吧！ 
               		 <div class="scare"><img alt="" src="../static/img/happy.jpg"></div>
		        </c:if>
			</div>
			
			<div class="operation">对工作人员张伟不满意? 点击举报!<img alt="" src="../static/img/happy.jpg"></div>
			<a class="btn-report" href="#">举报</a>
		
        </div>
        
        
        <div class="fineright">
			<img alt="" src="../static/img/alipay.jpg" class="pay">
			<img alt="" src="../static/img/wechat.jpg" class="pay">
			<div class="hidden">看什么看? 这真的是张伟的付款码<img alt="" src="../static/img/sad.jpg"></div>
        </div>
        
        <div class="ok">已确认付款? 点击刷新页面<a class="btn" href="/bookmanagement/log/payForFine">刷新</a></div>
        
    </div>
</body>
</html>