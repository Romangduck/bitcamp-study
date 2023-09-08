<%@ page
    language="java"
    pageEncoding="UTF-8"
    contentType="text/html;charset=UTF-8"
    trimDirectiveWhitespaces="true"
    errorPage="/error.jsp"%>
<%@ page import="project.myapp.vo.Member"%>

<jsp:useBean id="memberDao" type="project.myapp.dao.MemberDao" scope="application"/>
<jsp:useBean id="sqlSessionFactory" type="org.apache.ibatis.session.SqlSessionFactory" scope="application"/>
<jsp:useBean id="ncpObjectStorageService" type="project.util.NcpObjectStorageService" scope="application"/>
<%
    request.setAttribute("refresh", "2;url=list.jsp");

    Member m = new Member();
    m.setName(request.getParameter("name"));
    m.setHandPhone(request.getParameter("handPhone"));
    m.setPassword(request.getParameter("password"));
    m.setGender(request.getParameter("gender").charAt(0));
    m.setAge(Integer.parseInt(request.getParameter("age")));
    m.setHeight(Integer.parseInt(request.getParameter("height")));
    m.setWeight(Integer.parseInt(request.getParameter("weight")));
    m.setLeftEye(Float.parseFloat(request.getParameter("leftEye")));
    m.setRightEye(Float.parseFloat(request.getParameter("rightEye")));

    Part photoPart = request.getPart("photo");
    if (photoPart.getSize() > 0) {
      String uploadFileUrl = ncpObjectStorageService.uploadFile(
          "bitcamp-nc7-bucket-24", "member2/", photoPart);
      m.setPhoto(uploadFileUrl);
    }

    memberDao.insert(m);
    sqlSessionFactory.openSession(false).commit();
    response.sendRedirect("list.jsp");

%>