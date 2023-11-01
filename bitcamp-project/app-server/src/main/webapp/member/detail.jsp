<%@ page
    language="java"
    pageEncoding="UTF-8"
    contentType="text/html;charset=UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="memberDao" type="project.myapp.dao.MemberDao" scope="application"/>
<c:set var="member" value="${memberDao.findBy(param.no)}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>회원</title>
</head>
<body>

<jsp:include page="../header.jsp"/>

<h1>회원</h1>
<c:if test="${empty member}">
    <p>해당 번호의 회원이 없습니다!</p>
</c:if>
<c:if test="${not empty member}">
  <form action='/member/update.jsp' method='post' enctype='multipart/form-data'>
  <table border='1'>
  <tr>
      <th style='width:120px;'>사진</th>
      <td style='width:300px;'>
        <c:if test="${empty member.photo}">
          <img style='height:80px' src='/images/avatar.png'>
        </c:if>
        <c:if test="${not empty member.photo}">
          <a href='https://kr.object.ncloudstorage.com/bitcamp-nc7-bucket-24/member2/${member.photo}'>
            <img src='http://bnpxdrusesip19010743.cdn.ntruss.com/member/${member.photo}?type=f&w=60&h=80&faceopt=true&ttype=jpg'>
          </a>
        </c:if>
          <input type='file' name='photo'></td></tr>
  <tr>
      <th style='width:120px;'>번호</th>
      <td style='width:300px;'><input type='text' name='no' value='${member.no}' readonly></td></tr>
  <tr>
      <th>이름</th>
      <td><input type='text' name='name' value='${member.name}'></td>
  </tr>

  <tr>
      <th>생년월일</th>
      <td><input type='age' name='age' value='${member.age}'></td>
  </tr>

  <tr>
      <th>성별</th>
      <td><select name='gender'>
          <option value='M' ${String.valueOf(member.getGender()) == 'M' ? "selected" : ""}>남자</option>
          <option value='W' ${String.valueOf(member.getGender()) == 'W' ? "selected" : ""}>여자</option></select></td>
  </tr>

  <tr>
      <th>키</th>
      <td><input type='height' name='height' value='${member.height}'></td>
  </tr>

  <tr>
      <th>몸무게</th>
      <td><input type='weight' name='weight' value='${member.weight}'></td>
  </tr>

 <tr>
     <th>왼쪽 시력</th>
     <td><input type='leftEye' step='0.1' name='leftEye' value='${member.leftEye}'></td>
 </tr>

      <tr>
          <th>오른쪽 시력</th>
          <td><input type='rightEye' step='0.1' name='rightEye' value='${member.rightEye}'></td>
      </tr>

  <tr>
      <th>핸드폰 번호</th>
      <td><input type='handPhone' name='handPhone' value='${member.handPhone}'></td>
  </tr>

  <tr>
      <th>비밀 번호</th>
      <td><input type='password' name='password'></td>
  </tr>

  </table>
  <div>
  <button>변경</button>
  <button type='reset'>초기화</button>
      <a href='/member/delete.jsp?no=${member.no}'>삭제</a>
  <a href='/member/list.jsp'>목록</a>
  </div>
  </form>
</c:if>
<jsp:include page="../footer.jsp"/>

</body>
</html>