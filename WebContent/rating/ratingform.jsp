<%--
  Created by IntelliJ IDEA.
  User: jungcomet
  Date: 2021/11/05
  Time: 9:26 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<html>
<head>
    <title>${name} - 별점 평가하기</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        $(function () {
            $('#star').val(${rating.rscore}).prop("selected", true);
            $('#rcomment').val(${rating.rcomment});
        })
    </script>
</head>
<body>
<div>
    <h3>${name}의 별점을 입력합니다.</h3>
    <form action="${contextPath}/rating" method="post">
        <input type="hidden" name="movieid" value="${movieid}">
        <p>별점 <select name="rscore" id="star" value="${rating.rscore}">
            <option value="0">⭐ X 0</option>
            <option value="1">⭐ X 1</option>
            <option value="2">⭐️ X 2</option>
            <option value="3">⭐ X 3</option>
            <option value="4">⭐ X 4</option>
            <option value="5">⭐ X 5</option>
            <option value="6">⭐ X 6</option>
            <option value="7">⭐ X 7</option>
            <option value="8">⭐️ X 8</option>
            <option value="9">⭐️ X 9</option>
            <option value="10">⭐️ X 10</option>
        </select></p>
        <p>코멘트</p>
        <textarea name="rcomment" id="rcomment" value="테스트" cols="30" rows="5"></textarea>
        <input type="submit" value="평가하기">
    </form>
</div>
</body>
</html>
