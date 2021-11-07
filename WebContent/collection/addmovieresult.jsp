<%--
  Created by IntelliJ IDEA.
  User: jungcomet
  Date: 2021/11/07
  Time: 11:40 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<html>
<head>
    <title>컬렉션에 영화 추가 결과</title>
    <script>
        <c:choose>
            <c:when test="${msg=='insert_success'}">
                    alert("컬렉션에 영화를 추가했습니다.");
                    window.location.replace("${contextPath}/collection/detail?coll_no="+${coll_no});
            </c:when>
            <c:when test="${msg=='insert_fail'}">
                    alert("컬렉션에 영화를 추가하지 못했습니다.");
                    window.location.replace("${contextPath}/movie/moviedetail?movieid="+${movieid});
            </c:when>
        </c:choose>
    </script>
</head>
<body>

</body>
</html>
