<%--
  Created by IntelliJ IDEA.
  User: used
  Date: 28/5/25
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>Login</h2>
<form action="login" method="post">
    Username: <input type="text" name="username" /><br/>
    Password: <input type="password" name="password" /><br/>
    <input type="submit" value="Login" />
</form>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
</body>
</html>
