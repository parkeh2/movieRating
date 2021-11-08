<%--
  Created by IntelliJ IDEA.
  User: jungcomet
  Date: 2021/11/07
  Time: 11:04 오후
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
    <h1>컬렉션에 <${movie_name}> 영화를 추가합니다.</h1>
    <h2>담고 싶은 컬렉션을 선택하세요.</h2>
    <p>컬렉션 이름을 클릭하면 상세정보를 새 창으로 볼 수 있습니다.</p>
    <table>
        <tr>
            <th>선택</th>
            <th>이름</th>
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
                    <form action="${contextPath}/collection/addmovie/submit">
                <c:forEach items="${collectionList}" var="collection">
                        <tr>
                            <input type="hidden" name="movie_id" value="${movie_id}">
                            <td><input type="radio" name="coll_no" value="${collection.coll_no}"></td>
                            <td><a href="${contextPath}/collection/detail?coll_no=${collection.coll_no}" target="_blank">${collection.coll_name}</a></td>
                            <td>${collection.coll_description}</td>
                        </tr>
                </c:forEach>
                        <tr>
                            <td colspan="3"><input type="submit" value="추가하기"><input type="reset" value="다시선택"></td>
                        </tr>
                    </form>
            </c:when>
        </c:choose>
    </table>
</body>
</html>
