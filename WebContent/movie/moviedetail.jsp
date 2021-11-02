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
    <h3>평균⭐️ ${movie.average} (${movie.ratingCount}명 평가)</h3>
</div>
<div>
    <form action="rating">
        <input type="text" size="7" value="평점입력"><input type="submit" value="평가하기">
    </form>
</div>
<div>
    <h3>상세 정보</h3>
    <p>${movie.detail}</p>
</div>
<div>
    <h3>출연/제작</h3>
    <p><!-- 출연/제작자 영역 --></p>
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
    <p><a href="${contextPath}/movie/list">목록보기</a></p>
</div>
</body>
</html>
