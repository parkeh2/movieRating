<%--
  Created by IntelliJ IDEA.
  User: jungcomet
  Date: 2021/11/02
  Time: 3:27 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<html>
<head>
    <title>검색</title>
    <script>
        function change_type() {
            let searchForm = document.searchform;
            if (searchForm.searchType[0].selected) {
                document.searchform.action = "${contextPath}/search/moviename";
            } else if (searchForm.searchType[1].selected) {
                document.searchform.action = "${contextPath}/search/people";
            }
        }
    </script>
</head>
<body>
<h1>검색</h1>
<form name="searchform" method="post" onsubmit="return change_type();">
    <select name="searchType">
        <option value="movie">영화명</option>
        <option value="people">인물명</option>
    </select>
    <input type="text" placeholder="검색어 입력" name="searchname"><input type="submit" value="검색">
</form>
</body>
</html>
