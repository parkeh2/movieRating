<%--
  Created by IntelliJ IDEA.
  User: jungcomet
  Date: 2021/11/01
  Time: 9:17 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<html>
<head>
    <title>영화 수정</title>
</head>
<body>
    <h1>영화 수정</h1>
    <form action="${contextPath}/movie/modify" method="post">
        <table>
            <tr>
                <td>영화ID</td>
                <td><input type="hidden" name="movieid" value="${movie.movieNo}">${movie.movieNo}</td>
            </tr>
            <tr>
                <td>영화명</td>
                <td><input type="text" name="name" value="${movie.name}"/></td>
            </tr>
            <tr>
                <td>원제</td>
                <td><input type="text" name="nameorigin" value="${movie.nameOrigin}"></td>
            </tr>
            <tr>
                <td>개봉일</td>
                <td><input type="text" name="date" value="${movie.date}"></td>
            </tr>
            <tr>
                <td>장르</td>
                <td><input type="text" name="genre" value="${movie.genre}"></td>
            </tr>
            <tr>
                <td>러닝타임(분)</td>
                <td><input type="text" name="runningtime" value="${movie.runningTime}"></td>
            </tr>
            <tr>
                <td>연령제한</td>
                <td><input type="text" name="age" value="${movie.ageLimit}"></td>
            </tr>
            <tr>
                <td>국가</td>
                <td><input type="text" name="nation" value="${movie.nation}"></td>
            </tr>
            <tr>
                <td>상세설명</td>
                <td><input type="text" name="detail" value="${movie.detail}"></td>
            </tr>
            <tr>
                <td>포스터</td>
                <td><input type="text" name="poster_url" value="${movie.posterUrl}"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="수정하기"><input type="reset" value="다시입력"></td>
            </tr>
        </table>
    </form>
</body>
</html>
