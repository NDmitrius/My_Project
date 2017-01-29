<%--
  Created by IntelliJ IDEA.
  User: DMITRIUS
  Date: 30.01.2017
  Time: 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление фильма</title>
</head>
<body bgcolor="#ffe4c4">
<jsp:include page="Movie-header.jsp"/>
<h1>Добавление нового фильма</h1>
<form action="${pageContext.servletContext.contextPath}add-movie" method="post">
    <label for="movieName" > Название </label><br>
    <input type="text" style="width: 300px" name="movieName" id="movieName"><br>
    <label for="year" > Год </label><br>
    <input type="text" style="width: 300px" name="year" id="year"><br>
    <label for="country" >  Страна </label><br>
    <input type="text" style="width: 300px" name="country" id="country"><br>
    <br>
    <input type="submit" style="width: 300px" value="Добавить"><br>
</form>


<jsp:include page="Movie-footer.jsp"/>
</body>
</html>
