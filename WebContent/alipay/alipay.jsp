<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支付宝支付</title>
</head>
<body>
	<div align="center" style="text-algin:center;"><img src="alipay/alipay.jpg" height="500" width="350"></div>
	<form method="post" action="<c:url value='/OrderServlet?method=back'/>" >
		<div class="button" ><button class="button">支付完成</button></div>
		<input type="hidden" name="oid" value="${order.oid }"/>
		<input type="hidden" name="method" value="back"/>
	</form>
	
	
	 
	
</body>
</html>