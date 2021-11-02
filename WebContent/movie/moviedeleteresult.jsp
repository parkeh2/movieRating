<%--
  Created by IntelliJ IDEA.
  User: jungcomet
  Date: 2021/11/02
  Time: 11:18 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<html>
<head>
    <title>영화 삭제 결과</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
    <c:choose>
        <c:when test="${msg=='delete_success'}">
            <script>
                alert("영화 삭제에 성공했습니다.");
                window.location.replace("${contextPath}/movie/list");
            </script>
        </c:when>
        <c:when test="${msg=='delete_fail'}">
            <script>
                alert("영화 삭제에 실패했습니다.");
                window.location.replace("${contextPath}/movie/detail?movieid="+${movieid});
            </script>
        </c:when>
    </c:choose>
</body>
</html>
