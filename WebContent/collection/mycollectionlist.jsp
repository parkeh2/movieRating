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
    <title>컬렉션에 영화 추가</title>
</head>
<body>
    <h1>내 컬렉션 목록</h1>
    <a href="${contextPath}/collection/new">새 컬렉션 만들기</a>
    <table>
        <tr>
            <th>번호</th>
            <th>컬렉션 이름</th>
            <th>컬렉션 설명</th>
        </tr>
        <c:choose>
            <c:when test="${empty collectionList}">
                <tr>
                    <td colspan="3">컬렉션이 없습니다.</td>
                </tr>
                <tr>
                    <td colspan="3"><a href="${contextPath}/collection/new">새 컬렉션 만들기</a></td>
                </tr>
            </c:when>
            <c:when test="${!empty collectionList}">
                <c:set var="cnt" value="1" />
                <c:forEach items="${collectionList}" var="collection">
                    <c:set var="sum" value="${sum+1}" />
                    <tr>
                        <td>${sum}</td>
                        <td><a href="${contextPath}/collection/detail?coll_no=${collection.coll_no}">${collection.coll_name}</a></td>
                        <td>${collection.coll_description}</td>
                    </tr>
                </c:forEach>
            </c:when>
        </c:choose>
    </table>
</body>
</html>
