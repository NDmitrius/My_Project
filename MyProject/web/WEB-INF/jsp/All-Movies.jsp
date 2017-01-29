<%--
  Created by IntelliJ IDEA.
  User: DMITRIUS
  Date: 27.01.2017
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Фильмы</title>
</head>
<jsp:include page="Movie-header.jsp"/>
<body bgcolor="#ffe4c4">
<h1>Список фильмов</h1>

<table border="1">
    <thead style="background-color: burlywood">
    <tr>
        <td>Название фильма</td>
        <td>Год релиза</td>
        <td>Страна</td>
    </tr>
    </thead>
    <c:forEach var="movie" items="${sessionScope.movie}">
    <tbody>
    <tr valign="top">
        <td>${movie.name}</td>
        <td>${movie.year}</td>
        <td>${movie.country}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="Movie-footer.jsp"/>
</body>
</html>
