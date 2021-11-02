<%--
  Created by IntelliJ IDEA.
  User: jungcomet
  Date: 2021/11/02
  Time: 3:14 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<html>
<head>
    <title>Movie Rating</title>
    <style>
        h1, ul {
            align: center;
        }
    </style>
</head>
<body>
    <h1>Movie Rating</h1>
    <ul>
        <li><a href="${contextPath}/movie/list">영화 목록 조회</a></li>
        <li><a href="${contextPath}/search">검색</a></li>
    </ul>
</body>
</html>
