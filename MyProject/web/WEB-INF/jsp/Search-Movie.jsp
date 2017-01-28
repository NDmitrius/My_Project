<%--
  Created by IntelliJ IDEA.
  User: DMITRIUS
  Date: 28.01.2017
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Найти фильм</title>
</head>
<jsp:include page="Movie-header.jsp"/>
<body bgcolor="#ffe4c4">
<a href="${pageContext.servletContext.contextPath}all-movies">Все фильмы</a>
<h1>Поиск по названию фильма</h1>
<form action="${pageContext.servletContext.contextPath}search-movie" method="post">
    <label for="name">Название фильма: </label>
    <input type="text" name="nameMovie" id="name">
    <input type="submit" value="Найти">
</form>
<jsp:include page="Movie-footer.jsp"/>
</body>
</html>
