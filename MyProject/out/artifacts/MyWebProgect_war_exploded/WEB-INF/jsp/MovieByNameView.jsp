<%--
  Created by IntelliJ IDEA.
  User: DMITRIUS
  Date: 27.01.2017
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Результат поиска</title>
</head>
<jsp:include page="Movie-header.jsp"/>
<body bgcolor="#ffe4c4">

<h1>${sessionScope.movie.name}</h1>
<p><b>Релиз: </b>${sessionScope.movie.year}</p><br>
<p><b>Страна:</b> ${sessionScope.movie.country}</p><br>
<p><b>Режиссер: </b> ${sessionScope.movie.director} </p><br>

<p><b>Актеры: </b> ${sessionScope.movie.actors}</p><br>
<%--<c:forEach var="actor" items="${sessionScope.movie.actors}">--%>
    <%--${actor.firstName}${" "}${actor.lastName}<br>--%>
<%--</c:forEach>--%>
<p><b>Отзыв: </b> ${sessionScope.movie.reviews} </p><br>
<a href="${pageContext.servletContext.contextPath}search-movie"> Назад к поиску</a>
<jsp:include page="Movie-footer.jsp"/>
</body>
</html>
