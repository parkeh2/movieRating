<%--
  Created by IntelliJ IDEA.
  User: jungcomet
  Date: 2021/11/03
  Time: 4:36 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<html>
<head>
    <title>인물 수정</title>
    <script>
        function confirm_msg() {
            confirm("인물 정보를 수정하시겠습니까?");
        }
    </script>
</head>
<body>
<h1>인물 수정</h1>
<form action="${contextPath}/people/modify/submit" method="post" onsubmit="confirm_msg();">
    <table>
        <tr>
            <td>인물ID</td>
            <td><input type="hidden" name="pid" value="${people.pid}">${people.pid}</td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name" value="${people.name}"/></td>
        </tr>
        <tr>
            <td>사진</td>
            <td><input type="text" name="profileImageUrl" value="${people.profileImageUrl}"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="수정하기"><button onclick="window.history.back()">뒤로가기</button></td>
        </tr>
    </table>
</form>
</body>
</html>
