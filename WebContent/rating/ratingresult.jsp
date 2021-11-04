<%--
  Created by IntelliJ IDEA.
  User: jungcomet
  Date: 2021/11/04
  Time: 11:38 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<html>
<head>
    <title>별점 추가 결과</title>
</head>
<body>
<c:choose>
    <c:when test="${msg=='insert_success'}">
        <script>
            alert("별점 평가에 성공했습니다.");
            window.location.replace("${contextPath}/movie/moviedetail?movieid="+${movieid});
        </script>
    </c:when>
    <c:when test="${msg=='insert_fail'}">
        <script>
            alert("별점 평가에 실패했습니다.");
            window.location.replace("${contextPath}/movie/moviedetail?movieid="+${movieid});
        </script>
    </c:when>
</c:choose>
</body>
</html>
