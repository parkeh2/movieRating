<%--
  Created by IntelliJ IDEA.
  User: jungcomet
  Date: 2021/10/29
  Time: 2:11 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>영화 등록</title>
</head>
<body>
    <h1>영화 등록</h1>
    <form action="movie/insert" method="post" encType="utf-8">
    <table>
        <tr>
            <td>영화명</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>원제</td>
            <td><input type="text" name="nameorigin"></td>
        </tr>
        <tr>
            <td>개봉일</td>
            <td><input type="text" name="date"></td>
        </tr>
        <tr>
            <td>장르</td>
            <td><input type="text" name="genre"></td>
        </tr>
        <tr>
            <td>러닝타임(분)</td>
            <td><input type="text" name="runningtime"></td>
        </tr>
        <tr>
            <td>연령제한</td>
            <td><input type="text" name="age"></td>
        </tr>
        <tr>
            <td>국가</td>
            <td><input type="text" name="nation"></td>
        </tr>
        <tr>
            <td>상세설명</td>
            <td><input type="text" name="detail"></td>
        </tr>
        <tr>
            <td>포스터</td>
            <td><input type="text" name="poster_url"></td>
        </tr>
        <tr>
           <td colspan="2"><input type="submit" value="등록하기"><input type="reset" value="다시입력"></td>
        </tr>
    </table>
    </form>
</body>
</html>
