<%--
  Created by IntelliJ IDEA.
  User: DMITRIUS
  Date: 29.01.2017
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Регистрация</title>
</head>
<body bgcolor="#ffe4c4">
<jsp:include page="Movie-header.jsp"/>
<h1>Регистрация нового пользователя</h1><br><br>
<form action="${pageContext.servletContext.contextPath}add-user" method="post">
    <label for="lastName" > Фамилия </label><br>
    <input type="text" style="width: 300px" name="lastName" id="lastName"><br>
    <label for="firstName" > Имя </label><br>
    <input type="text" style="width: 300px" name="firstName" id="firstName"><br>
    <label for="middleName" >  Отчество </label><br>
    <input type="text" style="width: 300px" name="middleName" id="middleName"><br>
    <label for="email" > Email </label><br>
    <input type="text" style="width: 300px" name="email" id="email"><br>
    <label for="password" > Пароль </label><br>
    <input type="text" style="width: 300px" name="password" id="password"><br>
    <br>
    <input type="submit" style="width: 300px" value="Регистрация"><br>
</form>

<jsp:include page="Movie-footer.jsp"/>
</body>
</html>
