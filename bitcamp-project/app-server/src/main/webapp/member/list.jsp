<%@ page
    language="java"
    pageEncoding="UTF-8"
    contentType="text/html;charset=UTF-8"%> <%-- directive element --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>회원</title>
</head>
<body>

<jsp:include page="../header.jsp"/>

<h1>회원 목록</h1>
<div style='margin:5px;'>
<a href='/member/form.jsp'>회원가입</a>
</div>
<table border='1'>
<thead>
  <tr><th>번호</th> <th>이름</th> <th>핸드폰 번호</th></tr>
</thead>
<tbody>
<jsp:useBean id="memberDao" type="project.myapp.dao.MemberDao" scope="application"/>
<c:set var="list" value="${memberDao.findAll()}" scope="page"/>
<c:forEach items="${list}" var="member">
    <tr>
        <td>${member.no}</td>
        <td>
            <img src='http://bnpxdrusesip19010743.cdn.ntruss.com/member2/${member.photo}?type=f&w=30&h=40&faceopt=true&ttype=jpg'>
            <a href='/member/detail.jsp?no=${member.no}'>${member.name}</a></td>
        <td>${member.handPhone}</td>
    </tr>
</c:forEach>
</tbody>
</table>
<a href='/'>메인</a>

<jsp:include page="../footer.jsp"/>
</body>
</html>