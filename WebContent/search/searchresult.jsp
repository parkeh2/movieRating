<%--
  Created by IntelliJ IDEA.
  User: jungcomet
  Date: 2021/11/02
  Time: 4:08 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<html>
<head>
    <title>검색 결과</title>
    <style>
        h1, table {
            align: center;
        }
    </style>
</head>
<body>
    <h1>검색 결과</h1>
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
        <c:choose>
            <c:when test="${empty movies}">
                <tr>
                    <td colspan="7">검색된 영화가 없습니다.</td>
                </tr>
            </c:when>
            <c:when test="${!empty movies}">
                <c:set var="cnt" value="1" />
                <c:forEach items="${movies}" var="movie">
                    <c:set var="sum" value="${sum+1}" />
                    <tr>
                        <td>${sum}</td>
                        <td><a href="${contextPath}/movie/moviedetail?movieid=${movie.movieNo}"><img src="${contextPath}/images/poster/${movie.posterUrl}" alt="${movie.posterUrl}" width="50"></a></td>
                        <td><a href="${contextPath}/movie/moviedetail?movieid=${movie.movieNo}">${movie.name}</a></td>
                        <td>${movie.genre}</td>
                        <td>${movie.date}</td>
                        <td>${movie.runningTime}</td>
                        <td>${movie.average}</td>
                    </tr>
                </c:forEach>
            </c:when>
        </c:choose>
    </table>
</body>
</html>
