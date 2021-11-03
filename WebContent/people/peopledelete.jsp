<%--
  Created by IntelliJ IDEA.
  User: jungcomet
  Date: 2021/11/03
  Time: 5:27 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<html>
<head>
    <title>인물 삭제</title>
</head>
<body>
<c:choose>
  <c:when test="${msg=='delete_success'}">
    <script>
      alert("인물 삭제에 성공했습니다.");
      window.location.replace("${contextPath}/people/list");
    </script>
  </c:when>
  <c:when test="${msg=='delete_fail'}">
    <script>
      alert("인물 삭제에 실패했습니다.");
      window.location.replace("${contextPath}/people/detail?pid="+${pid});
    </script>
  </c:when>
</c:choose>
</body>
</html>
