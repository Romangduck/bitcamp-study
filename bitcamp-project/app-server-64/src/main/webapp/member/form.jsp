<%@ page
    language="java"
    pageEncoding="UTF-8"
    contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>비트병원</title>
</head>
<body>

<jsp:include page="../header.jsp"/>

<h1>회원</h1>
<form action='/member/add.jsp' method='post' enctype='multipart/form-data'>
<table border='1'>
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
        <td>
            <select name='gender'>
                <option value='M'>남자</option>
                <option value='W'>여자</option>
            </select>
        </td>
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

    <tr>
        <th>사진</th> <td><input type='file' name='photo'></td>
    </tr>

</table>
<button>등록</button>
</form>

<jsp:include page="../footer.jsp"/>

</body>
</html>
