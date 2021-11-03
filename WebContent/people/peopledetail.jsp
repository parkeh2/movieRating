<%--
  Created by IntelliJ IDEA.
  User: jungcomet
  Date: 2021/11/03
  Time: 3:30 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<html>
<head>
    <title>인물 상세정보</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        function modifyPeople(pid) {
            let confirmflag = confirm("인물 정보를 수정하시겠습니까?");
            if (confirmflag) {
                window.location.replace("${contextPath}/people/modify?pid=" + pid);
            }
        }
        function deletePeople(pid) {
            let confirmflag = confirm("삭제하면 복구할 수 없습니다.\n정말로 이 인물을 삭제하시겠습니까?");
            if (confirmflag) {
                window.location.replace("${contextPath}/people/delete?pid=" + pid);
            } else {
                alert("인물 삭제를 취소했습니다.");
            }
        }
    </script>
</head>
<body>
<c:choose>
    <c:when test="${msg=='update_success'}">
        <script>
            $(function () {
                alert("인물 정보를 수정했습니다.");
            });
        </script>
    </c:when>
    <c:when test="${msg=='update_fail'}">
        <script>
            $(function () {
                alert("인물 정보를 수정하지 못했습니다.");
            });
            window.location.replace("${contextPath}/people/modify?pid=${people.pid}");
        </script>-
    </c:when>
    <c:when test="${msg=='add_success'}">
        <script>
            $(function () {
                alert("인물을 추가했습니다.");
            });
        </script>
    </c:when>
    <c:when test="${msg=='add_fail'}">
        <script>
            $(function () {
                alert("인물을 추가하지 못했습니다.");
            });
            window.location.replace("${contextPath}/people/add");
        </script>
    </c:when>
</c:choose>
<h1 align="center">인물 상세정보</h1>

<div>
    <!--포스터 이미지 출력-->
    <p><img src="${contextPath}/images/people/${people.profileImageUrl}" alt="${people.profileImageUrl}" /></p>
</div>
<div>
    <h2>${people.name}</h2>
    <input type="hidden" value="${people.pid}">
</div>
<div>
    <h3>출연/제작</h3>
    <p><!-- 출연/제작자 영역 --></p>
</div>
<div>
    <p><button type="button" onclick="modifyPeople(${people.pid})">수정하기</button>
        <button type="button" onclick="deletePeople(${people.pid})">삭제하기</button></p>
    <p><button type="button" onclick="window.history.back();">뒤로가기</button></p>
</div>
</body>
</html>
