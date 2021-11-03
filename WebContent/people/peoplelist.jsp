<%--
  Created by IntelliJ IDEA.
  User: jungcomet
  Date: 2021/11/03
  Time: 3:12 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<html>
<head>
    <title>감독/배우 목록</title>
</head>
<body>
<h1 align="center">감독/배우 목록</h1>
<p align="center"><a href="${contextPath}/people/add">인물 추가</a></p>
<table align="center">
    <tr>
        <th>번호</th>
        <th>사진</th>
        <th>이름</th>
        <th>출연작</th>
    </tr>
    <c:choose>
        <c:when test="${empty peopleList}">
            <tr>
                <td colspan="4">인물이 없습니다.</td>
            </tr>
        </c:when>
        <c:when test="${!empty peopleList}">
            <c:set var="cnt" value="1" />
            <c:forEach items="${peopleList}" var="people">
                <c:set var="sum" value="${sum+1}" />
                <tr>
                    <td>${sum}</td>
                    <td><a href="${contextPath}/people/detail?pid=${people.pid}"><img src="/images/poster/${people.profileImageUrl}" alt="${people.profileImageUrl}" width="50"></a></td>
                    <td><a href="${contextPath}/people/detail?pid=${people.pid}">${people.name}</a></td>
                    <td><!-- 출연작 리스트 3개만 출력 --></td>
                </tr>
            </c:forEach>
        </c:when>
    </c:choose>

</table>
</body>
</html>
