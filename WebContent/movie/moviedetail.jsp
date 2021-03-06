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
<c:set var="movieid" value="${movie.movieNo}}" />

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
        function addCollection() {
            window.location.replace("${contextPath}/collection/addmovie?movieid=${movie.movieNo}&moviename=${movie.name}");
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
    <form action="${contextPath}/rating/form" method="post">
        <input type="hidden" name="movieid" value="${movie.movieNo}">
        <input type="hidden" name="name" value="${movie.name}">
        <input type="submit" value="별점 평가하기">
    </form>
</div>
<div>
    <h3>상세 정보</h3>
    <p>${movie.detail}</p>
</div>
<div>
    <h3>출연/제작</h3>
    <div>
        <table>
            <c:choose>
                <c:when test="${empty castingList}">
                    <tr>
                        <td colspan="3">출연자가 없습니다.</td>
                    </tr>
                </c:when>
                <c:when test="${!empty castingList}">
                    <c:forEach items="${castingList}" var="casting">
                        <tr>
                            <td><a href="${contextPath}/people/detail?pid=${casting.pid}"><img src="${contextPath}/images/people/${casting.profileImageUrl}" alt="${casting.profileImageUrl}" width="50"></a></td>
                            <td><a href="${contextPath}/people/detail?pid=${casting.pid}">${casting.name}</a></td>
                            <td>${casting.role}</td>
                        </tr>
                    </c:forEach>
                </c:when>
            </c:choose>
        </table>
    </div>
<%--
    <div id="casting">
        <a href="/casting?movieid=${movie.movieNo}">캐스팅 목록</a>
    </div>--%>
</div>
<div>
    <h3>코멘트</h3>
    <div>
        <table>
            <c:choose>
                <c:when test="${empty ratingList}">
                    <tr>
                        <td colspan="3">등록된 별점과 코멘트가 없습니다.</td>
                    </tr>
                </c:when>
                <c:when test="${!empty ratingList}">
                    <c:forEach items="${ratingList}" var="rating">
                        <tr>
                            <td>"${rating.rcomment}"</td>
                            <td> - ⭐${rating.rscore}</td>
                            <td>${rating.mname}(${rating.mid})님</td>
                        </tr>
                    </c:forEach>
                </c:when>
            </c:choose>
        </table>
    </div>
</div>
<div>
    <h3>이 영화가 포함된 컬렉션</h3>
    <div>
        <table>
            <c:choose>
                <c:when test="${empty collectionList}">
                    <tr>
                        <td colspan="2">이 영화가 포함된 컬렉션이 없습니다.</td>
                    </tr>
                </c:when>
                <c:when test="${!empty collectionList}">
                    <c:forEach items="${collectionList}" var="collection">
                        <tr>
                            <td><a href="${contextPath}/collection/detail?coll_no=${collection.coll_no}">${collection.coll_name}</a></td>
                            <td>${collection.coll_description}</td>
                        </tr>
                    </c:forEach>
                </c:when>
            </c:choose>
        </table>
    </div>
    <div>
        <button type="button" onclick="addCollection();">이 영화를 내 컬렉션에 추가하기</button>
    </div>
</div>
<hr>
<div>
    <p><button type="button" onclick="modifyMovie(${movie.movieNo});">수정하기</button>
        <button type="button" onclick="deleteMovie(${movie.movieNo});">삭제하기</button></p>
    <p><button type="button" onclick="window.history.back();">뒤로가기</button></p>
</div>
</body>
</html>
