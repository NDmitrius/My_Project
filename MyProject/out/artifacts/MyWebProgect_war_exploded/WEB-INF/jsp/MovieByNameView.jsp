<%--
  Created by IntelliJ IDEA.
  User: DMITRIUS
  Date: 27.01.2017
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Результат поиска</title>
</head>
<jsp:include page="Movie-header.jsp"/>
<body bgcolor="#ffe4c4">
<a href="${pageContext.servletContext.contextPath}all-movies">Все фильмы</a>
<h1>${requestScope.movie.name}</h1>



<%--<c:out value="${param.name}" default="Введите полное название фильма."/>--%>
<%--<p>${requestScope.movie.name}</p>--%>
<%--<c:forEach var="director" items="${requestScope.movie.director}">--%>
    <%--${movie.director.firstName}--%>
<%--</c:forEach>--%>
<a href="search-movie"> Назад</a>
<jsp:include page="Movie-footer.jsp"/>
</body>
</html>
