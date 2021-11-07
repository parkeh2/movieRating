<%--
  Created by IntelliJ IDEA.
  User: jungcomet
  Date: 2021/11/07
  Time: 10:00 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<html>
<head>
    <title>컬렉션 생성 결과</title>
  <script>
    function coll_add_success() {
      alert("컬렉션 생성에 성공했습니다.");
      window.location.replace("${contextPath}/collection/list");
    }
    
    function coll_add_fail() {
      alert("컬렉션 생성에 실패했습니다.");
      window.location.back();
    }
  </script>
</head>
<body>
    <c:choose>
      <c:when test="${!empty collection}">
        <script>
          coll_add_success();
        </script>
      </c:when>
      <c:when test="${empty collection}">
        <script>
          coll_add_fail();
        </script>
      </c:when>
    </c:choose>
</body>
</html>
