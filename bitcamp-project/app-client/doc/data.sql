-- project_member 테이블 예제 데이터
insert into project_member(member_no, name, age, height, weight , gender , LeftEye , RightEye) 
  values(1, '홍길동', '23', '170' , '70','M' ,'2.0' , '2.5' );
insert into project_member(member_no, name, age, height, weight , gender , LeftEye , RightEye) 
  values(2, '홍길도', '33', '171' , '71','M' ,'1.0' , '1.5' );
insert into project_member(member_no, name, age, height, weight , gender , LeftEye , RightEye) 
  values(3, '홍길덕', '43', '172' , '72','W' ,'1.5' , '1.0' );
insert into project_member(member_no, name, age, height, weight , gender , LeftEye , RightEye) 
  values(4, '홍길덩', '53', '173' , '73','M' ,'1.0' , '2.0' );
insert into project_member(member_no, name, age, height, weight , gender , LeftEye , RightEye) 
values(5, '홍길당', '63', '174' , '74','W' ,'1.0' , '0.5' );
insert into project_member(member_no, name, age, height, weight , gender , LeftEye , RightEye) 
 values(6, '홍길둥', '73', '175' , '75','M' ,'1.0' , '0.0' );

-- project_board 테이블 예제 데이터
insert into project_board(board_no, title, content, writer, password, category)
  values(11, '제목1', '내용', '홍길동', '1111', 1);
insert into project_board(board_no, title, content, writer, password, category)
  values(12, '제목2', '내용', '임꺽정', '1111', 1);
insert into project_board(board_no, title, content, writer, password, category)
  values(13, '제목3', '내용', '유관순', '1111', 1);
insert into project_board(board_no, title, content, writer, password, category)
  values(14, '제목4', '내용', '이순신', '1111', 1);
insert into project_board(board_no, title, content, writer, password, category)
  values(15, '제목5', '내용', '윤봉길', '1111', 2);
insert into project_board(board_no, title, content, writer, password, category)
  values(16, '제목6', '내용', '안중근', '1111', 2);
insert into project_board(board_no, title, content, writer, password, category)
  values(17, '제목7', '내용', '김구', '1111', 2);