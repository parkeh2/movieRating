<%--
  Created by IntelliJ IDEA.
  User: jungcomet
  Date: 2021/10/29
  Time: 11:08 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<html>
<head>
    <title>영화 상세정보</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        function modifyMovie(movieNo) {
            let confirmflag = confirm("영화 정보를 수정하시겠습니까?");
            if (confirmflag) {
                window.location.replace("${contextPath}/movie/modify?movieid=" + movieNo);
            }
        }
        function deleteMovie(movieNo) {
            let confirmflag = confirm("삭제하면 복구할 수 없습니다.\n정말로 이 영화를 삭제하시겠습니까?");
            if (confirmflag) {
                window.location.replace("${contextPath}/movie/delete?movieid=" + movieNo);
            } else {
                alert("영화 삭제를 취소했습니다.");
            }
        }
    </script>
</head>
<body>
<c:choose>
    <c:when test="${msg=='update_success'}">
        <script>
            $(function () {
               alert("영화 정보를 수정했습니다.");
            });
        </script>
    </c:when>
    <c:when test="${msg=='update_fail'}">
        <script>
            $(function () {
                alert("영화 정보를 수정하지 못했습니다.");
            });
            window.location.replace("${contextPath}/movie/modify?movieid=${movie.movieNo}");
        </script>-
    </c:when>
    <c:when test="${msg=='add_success'}">
        <script>
            $(function () {
                alert("영화를 추가했습니다.");
            });
        </script>
    </c:when>
    <c:when test="${msg=='add_fail'}">
        <script>
            $(function () {
                alert("영화를 추가하지 못했습니다.");
            });
            window.location.replace("${contextPath}/movie/add");
        </script>
    </c:when>
</c:choose>

<h1 align="center">영화 상세정보</h1>

<div>
    <!--포스터 이미지 출력-->
    <p><img src="${contextPath}/images/poster/${movie.posterUrl}" alt="${movie.posterUrl}" /></p>
</div>
<div>
    <h2>${movie.name}</h2>
    <input type="hidden" value="${movie.movieNo}">
    <p>${movie.date} 개봉 / ${movie.genre} / ${movie.nation}</p>
    <p>원제 ${movie.nameOrigin} / 상영시간 ${movie.runningTime}분</p>
    <h3>평균별점 ⭐️ ${movie.average} (${movie.ratingCount}명 평가)</h3>
</div>
<div>
    <h3>별점 입력</h3>
    <form action="${contextPath}/rating" method="post">
        <input type="hidden" name="movieid" value="${movie.movieNo}">
        <p>별점 <select name="rscore" id="star">
            <option value="0">⭐ X 0</option>
            <option value="1">⭐ X 1</option>
            <option value="2">⭐️ X 2</option>
            <option value="3">⭐ X 3</option>
            <option value="4">⭐ X 4</option>
            <option value="5">⭐ X 5</option>
            <option value="6">⭐ X 6</option>
            <option value="7">⭐ X 7</option>
            <option value="8">⭐️ X 8</option>
            <option value="9">⭐️ X 9</option>
            <option value="10">⭐️ X 10</option>
        </select></p>
        <p>코멘트</p>
        <textarea name="rcomment" id="rcomment" cols="30" rows="5"></textarea>
        <input type="submit" value="평가하기">
    </form>
</div>
<div>
    <h3>상세 정보</h3>
    <p>${movie.detail}</p>
</div>
<div>
    <h3>출연/제작</h3>
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
</div>
<div>
    <h3>코멘트</h3>
    <p><!-- 코멘트 영역 --></p>
</div>
<div>
    <h3>컬렉션</h3>
    <p><!-- 컬렉션 영역 --></p>
</div>
<div>
    <p><button type="button" onclick="modifyMovie(${movie.movieNo})">수정하기</button>
        <button type="button" onclick="deleteMovie(${movie.movieNo})">삭제하기</button></p>
    <p><button type="button" onclick="window.history.back();">뒤로가기</button></p>
</div>
</body>
</html>
