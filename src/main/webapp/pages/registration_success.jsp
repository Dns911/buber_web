<%--
  Created by IntelliJ IDEA.
  User: vds15
  Date: 19-Dec-22
  Time: 4:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Registration was success</title>
</head>
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
<body>

<form class="form" action="${pageContext.request.contextPath}/controller" method="post">
    Registration was success!
    <input type="hidden" name="command" value="default">
    <input class="btn" type="submit" name="but" value="Back to login"/>
</form>
</body>
</html>
