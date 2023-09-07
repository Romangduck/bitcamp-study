<%@ page
    language="java"
    pageEncoding="UTF-8"
    contentType="text/html;charset=UTF-8"
    trimDirectiveWhitespaces="true"
    errorPage="/error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="refresh" value="2;url=/auth/form.jsp" scope="request"/>

<jsp:useBean id="m" class="project.myapp.vo.Member" scope="page"/>
<c:set target="${pageScope.m}" property="handPhone" value="${param.handPhone}"/>
<c:set target="${pageScope.m}" property="password" value="${param.password}"/>

<c:if test="${not empty param.saveHandPhone}">
  <%
    Cookie cookie = new Cookie("handPhone", m.getHandPhone());
    response.addCookie(cookie);
  %>
</c:if>

<c:if test="${empty param.handPhone}">
  <%
    Cookie cookie = new Cookie("handPhone", "no");
    cookie.setMaxAge(0);
    response.addCookie(cookie);
  %>
</c:if>

<jsp:useBean id="memberDao" type="project.myapp.dao.MemberDao" scope="application"/>
<c:set var="loginUser" value="${memberDao.findByPhoneNumberAndPassword(m)}" scope="session"/>

<jsp:useBean id="loginUser" type="project.myapp.vo.Member" scope="session"/>
<c:redirect url="/"/>
