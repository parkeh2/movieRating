<%--
  Created by IntelliJ IDEA.
  User: jungcomet
  Date: 2021/11/07
  Time: 5:38 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<html>
<head>
    <title>새 컬렉션 만들기</title>
</head>
<body>
    <h1>새 컬렉션을 만듭니다.</h1>
    <form action="${contextPath}/collection/new/submit" method="post">
        <table>
            <tr>
                <td>이름</td>
                <td><input type="text" name="coll_name" size="35"></td>
            </tr>
            <tr>
                <td>설명</td>
                <td><textarea name="coll_description" id="desc" cols="30" rows="5"></textarea></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="만들기"></td>
            </tr>
        </table>
    </form>
</body>
</html>
