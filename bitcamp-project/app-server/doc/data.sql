-- project_member 테이블 예제 데이터
insert into project_member(member_no, name, age, height, weight , gender , leftEye , rightEye,handPhone,password) 
  values(1, '김현덕', '50', '170' , '70','M' ,'2.0' , '2.5','01029553520',sha1('1111') );
insert into project_member(member_no, name, age, height, weight , gender , leftEye , rightEye,handPhone,password) 
  values(2, '홍길동', '10', '171' , '71','M' ,'1.0' , '1.5','01023232322',sha1('1111'));
insert into project_member(member_no, name, age, height, weight , gender , leftEye , rightEye,handPhone,password) 
  values(3, '홍길덕', '12', '172' , '72','W' ,'1.5' , '1.0','01029553233',sha1('1111'));
insert into project_member(member_no, name, age, height, weight , gender , leftEye , rightEye,handPhone,password) 
  values(4, '홍길덩', '13', '173' , '73','M' ,'1.0' , '2.0','01029553222',sha1('1111'));
insert into project_member(member_no, name, age, height, weight , gender , leftEye  , rightEye,handPhone,password) 
values(5, '홍길당', '12', '174' , '74','W' ,'1.0' , '0.5','01029551111',sha1('1111') );
insert into project_member(member_no, name, age, height, weight , gender , leftEye , rightEye,handPhone,password) 
 values(6, '홍길둥', '12', '175' , '75','M' ,'1.0' , '0.0' ,'01029554231',sha1('1111'));

-- project_board 테이블 예제 데이터
insert into project_board(board_no, title, content, writer, category)
  values(11, '홍길동', '답이없음', 1, 1);
insert into project_board(board_no, title, content, writer, category)
  values(12, '홍길덕', '답이없음', 1, 1);
insert into project_board(board_no, title, content, writer, category)
  values(13, '홍길덩', '성실함', 1, 1);
insert into project_board(board_no, title, content, writer, category)
  values(14, '홍길둥', '우등생', 1, 1);
insert into project_board(board_no, title, content, writer, category)
  values(15, '맞짱뜰사람구함', '구라임', 2, 2);
insert into project_board(board_no, title, content, writer, category)
  values(16, '사실 너 좋아해', '거울을보며...', 3, 2);
insert into project_board(board_no, title, content, writer, category)
  values(19, '앗', '뜨거', 4, 3);
insert into project_board(board_no, title, content, writer, category)
  values(20, '독서', '감동적이다', 5, 3);
insert into project_board(board_no, title, content, writer, category)
  values(21, '부모님 일 도와드리기', '너무 좋았다', 6, 3);
insert into project_board(board_no, title, content, writer, category)
  values(22, '대나무헬리콥터만들기', '재밌었다', 6, 3);