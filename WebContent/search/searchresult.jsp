<%--
  Created by IntelliJ IDEA.
  User: jungcomet
  Date: 2021/11/02
  Time: 4:08 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<html>
<head>
    <title>검색 결과</title>
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
    <h1>검색 결과</h1>
    <form name="searchform" method="post" onsubmit="return change_type();">
        <select name="searchType">
            <option value="movie">영화명</option>
            <option value="people">인물명</option>
        </select>
        <input type="text" placeholder="검색어 입력" name="searchname"><input type="submit" value="검색">
    </form>
    <hr>
    <h2>영화</h2>
    <table>
        <tr>
            <th>번호</th>
            <th>포스터</th>
            <th>이름</th>
            <th>장르</th>
            <th>개봉일</th>
            <th>러닝타임</th>
            <th>별점</th>
        </tr>
        <c:choose>
            <c:when test="${empty movies}">
                <tr>
                    <td colspan="7">검색된 영화가 없습니다.</td>
                </tr>
            </c:when>
            <c:when test="${!empty movies}">
                <c:set var="cnt" value="1" />
                <c:forEach items="${movies}" var="movie">
                    <c:set var="sum" value="${sum+1}" />
                    <tr>
                        <td>${sum}</td>
                        <td><a href="${contextPath}/movie/moviedetail?movieid=${movie.movieNo}"><img src="${contextPath}/images/poster/${movie.posterUrl}" alt="${movie.posterUrl}" width="50"></a></td>
                        <td><a href="${contextPath}/movie/moviedetail?movieid=${movie.movieNo}">${movie.name}</a></td>
                        <td>${movie.genre}</td>
                        <td>${movie.date}</td>
                        <td>${movie.runningTime}</td>
                        <td>${movie.average}</td>
                    </tr>
                </c:forEach>
            </c:when>
        </c:choose>
    </table>
    <h2>인물</h2>
    <table>
        <tr>
            <th>번호</th>
            <th>사진</th>
            <th>이름</th>
            <th>출연작</th>
        </tr>
        <c:choose>
            <c:when test="${empty people}">
                <tr>
                    <td colspan="7">검색된 인물이 없습니다.</td>
                </tr>
            </c:when>
            <c:when test="${!empty people}">
                <c:set var="cnt" value="1" />
                <c:forEach items="${people}" var="people">
                    <c:set var="sum" value="${sum+1}" />
                    <tr>
                        <td>${sum}</td>
                        <td><a href="${contextPath}/people/detail?pid=${people.pid}"><img src="${contextPath}/images/people/${people.profileImageUrl}" alt="${people.profileImageUrl}" width="50"></a></td>
                        <td><a href="${contextPath}/people/detail?pid=${people.pid}">${people.name}</a></td>
                        <td><!-- 출연작 리스트 3개만 출력 --></td>
                    </tr>
                </c:forEach>
            </c:when>
        </c:choose>
    </table>
</body>
</html>
