<%--
  Created by IntelliJ IDEA.
  User: jungcomet
  Date: 2021/11/03
  Time: 4:21 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<html>
<head>
    <title>인물 등록</title>
    <script>
        function confirm_msg() {
            confirm("인물을 추가하시겠습니까?");
        }
    </script>
</head>
<body>
<h1>인물 등록</h1>
<form action="${contextPath}/people/add" method="post" onsubmit="confirm_msg();" encType="multipart/form-data">
    <table>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name"></td>
        </tr>
            <td>사진</td>
            <td><input type="file" name="profileImageUrl"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="등록하기"><input type="reset" value="다시입력"></td>
        </tr>
    </table>
</form>
</body>
</html>
