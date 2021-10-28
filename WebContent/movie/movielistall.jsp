<%--
  Created by IntelliJ IDEA.
  User: jungcomet
  Date: 2021/10/28
  Time: 3:23 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>영화 목록</title>
</head>
<body>
    <h1>영화 목록</h1>
    <table>
        <tr>
            <th>번호</th>
            <th>포스터</th>
            <th>이름</th>
            <th>장르</th>
            <th>개봉일</th>
            <th>러닝타임</th>
            <th>별점</th>
        </tr>
        <c:forEach items="${movies}" var="movie">
        <tr>
            <td>${movie.movieNo}</td>
            <td>${movie.posterUrl}</td>
            <td>${movie.name}</td>
            <td>${movie.genre}</td>
            <td>${movie.date}</td>
            <td>${movie.runningTime}</td>
            <td>${movie.average}</td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
