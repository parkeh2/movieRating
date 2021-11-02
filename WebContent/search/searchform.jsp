<%--
  Created by IntelliJ IDEA.
  User: jungcomet
  Date: 2021/11/02
  Time: 3:27 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>통합검색</title>
</head>
<body>
<h1>검색</h1>
<form action="/search/moviename" method="post">
    <input type="text" placeholder="영화명 검색어 입력" name="searchname"><input type="submit" value="검색">
</form>
</body>
</html>
