<%--
  Created by IntelliJ IDEA.
  User: jungcomet
  Date: 2021/10/29
  Time: 11:08 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>영화 상세정보</title>
</head>
<body>
<h1 align="center">영화 상세정보</h1>

<div>
    <!--포스터 이미지 출력-->
    <p><img src="/images/poster/${movie.posterUrl}" alt="${movie.posterUrl}" /></p>
</div>
<div>
    <h2>${movie.name}</h2>
    <p>${movie.date} 개봉 / ${movie.genre} / ${movie.nation}</p>
    <h3>평균⭐️ ${movie.average} (${movie.ratingCount}명 평가)</h3>
</div>
<div>
    <form action="rating">
        <input type="text" size="7" value="평점입력"><input type="submit" value="평가하기">
    </form>
</div>
<div>
    <h3>상세 정보</h3>
    <p>${movie.detail}</p>
</div>
<div>
    <h3>출연/제작</h3>
    <p><!-- 출연/제작자 영역 --></p>
</div>
<div>
    <h3>코멘트</h3>
    <p><!-- 코멘트 영역 --></p>
</div>
<div>
    <h3>컬렉션</h3>
    <p><!-- 컬렉션 영역 --></p>
</div>
<!--
<table align="center">
    <tr>
        <th>번호</th>
        <th>포스터</th>
        <th>이름</th>
        <th>장르</th>
        <th>개봉일</th>
        <th>러닝타임</th>
        <th>별점</th>
    </tr>
    <c:set var="cnt" value="1" />
    <c:forEach items="${movies}" var="movie">
        <c:set var="sum" value="${sum+1}" />
        <tr>
            <td>${sum}</td>
            <td>${movie.posterUrl}</td>
            <td><a href="moviedetail?movieid=${movie.movieNo}">${movie.name}</a></td>
            <td>${movie.genre}</td>
            <td>${movie.date}</td>
            <td>${movie.runningTime}</td>
            <td>${movie.average}</td>
        </tr>
    </c:forEach>
</table>
-->
</body>
</html>
