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

    Member member = new Member();
    member.setNo(Integer.parseInt(request.getParameter("no")));
    member.setName(request.getParameter("name"));
    member.setAge(Integer.parseInt(request.getParameter("age")));
    member.setHeight(Integer.parseInt(request.getParameter("height")));
    member.setWeight(Integer.parseInt(request.getParameter ("weight")));
    member.setLeftEye(Float.parseFloat(request.getParameter("leftEye")));
    member.setRightEye(Float.parseFloat(request.getParameter("rightEye")));
    member.setGender(request.getParameter("gender").charAt(0));
    member.setHandPhone(request.getParameter("handPhone"));
    member.setPassword(request.getParameter("password"));

    Part photoPart = request.getPart("photo");
    if (photoPart.getSize() > 0) {
      String uploadFileUrl = ncpObjectStorageService.uploadFile(
          "bitcamp-nc7-bucket-24", "member2/", photoPart);
      member.setPhoto(uploadFileUrl);
    }

    if (memberDao.update(member) == 0) {
        throw new Exception("회원이 없습니다.");
    } else {
        sqlSessionFactory.openSession(false).commit();
        response.sendRedirect("list.jsp");
    }

%>
