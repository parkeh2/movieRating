<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jungcomet
  Date: 2021/11/05
  Time: 12:20 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<html>
<head>
    <title>캐스팅 리스트</title>
</head>
<body>
<p>
<table>
    <tr>
        <th>사진</th>
        <th>이름</th>
        <th>배역</th>
    </tr>
    <c:choose>
        <c:when test="${empty castingList}">
            <tr>
                <td colspan="3">출연자가 없습니다.</td>
            </tr>
        </c:when>
        <c:when test="${!empty castingList}">
            <c:forEach items="${castingList}" var="casting">
                <tr>
                    <td><a href="${contextPath}/people/pid=${casting.pid}"><img src="${contextPath}/images/casting/${casting.profileImageUrl}" alt="${casting.profileImageUrl}" width="50"></a></td>
                    <td><a href="${contextPath}/people/pid=${casting.pid}">${casting.name}</a></td>
                    <td>${casting.role}</td>
                </tr>
            </c:forEach>
        </c:when>
    </c:choose>
</table>
</p>
</body>
</html>
