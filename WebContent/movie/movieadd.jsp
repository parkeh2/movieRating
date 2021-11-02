<%--
  Created by IntelliJ IDEA.
  User: jungcomet
  Date: 2021/10/29
  Time: 2:11 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<html>
<head>
    <title>영화 등록</title>
    <script>
        function confirm_msg() {
            confirm("영화를 추가하시겠습니까?");
        }
    </script>
</head>
<body>
    <h1>영화 등록</h1>
    <form action="${contextPath}/movie/add" method="post" onsubmit="confirm_msg();" encType="utf-8">
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
            <td><input type="date" name="date"></td>
        </tr>
        <tr>
            <td>장르</td>
            <td><input type="text" name="genre"></td>
        </tr>
        <tr>
            <td>러닝타임(분)</td>
            <td><input type="number" name="runningtime"></td>
        </tr>
        <tr>
            <td>연령제한</td>
            <td>
                <input type="radio" name="age" value="0" id="all"><label for="all">전체</label>
                <input type="radio" name="age" value="12" id="12"><label for="12">12</label>
                <input type="radio" name="age" value="15" id="15"><label for="15">15</label>
                <input type="radio" name="age" value="19" id="19"><label for="19">19</label>
            </td>
        </tr>
        <tr>
            <td>국가</td>
            <td><input type="text" name="nation"></td>
        </tr>
        <tr>
            <td>상세설명</td>
            <td><textarea name="detail" id="detail" cols="30" rows="5"></textarea></td>
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
