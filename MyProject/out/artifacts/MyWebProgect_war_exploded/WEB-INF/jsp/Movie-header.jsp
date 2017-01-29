<%--
  Created by IntelliJ IDEA.
  User: DMITRIUS
  Date: 27.01.2017
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header>
    <p align="center"><strong>Небольшая видеотека</strong></p>
    <a href="${pageContext.servletContext.contextPath}index.jsp">Главная</a><span>  /  </span>
    <a href="${pageContext.servletContext.contextPath}all-movies">Все фильмы</a><span>  /  </span>
    <a href="${pageContext.servletContext.contextPath}search-movie"> Поиск фильма</a><span>  /  </span>
    <a href="${pageContext.servletContext.contextPath}add-movie"> Добавление фильма</a><span>  /  </span>
    <a href="${pageContext.servletContext.contextPath}add-user"> Регистрация пользователя</a>
</header>