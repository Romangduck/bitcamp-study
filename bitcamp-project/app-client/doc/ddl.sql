create table project_board(
  board_no int not null,
  title varchar(255) not null,
  content text null,
  writer varchar(20) not null,
  password varchar(100) null,
  view_count int default 0,
  created_date datetime default now()
);

alter table project_board
  add constraint primary key (board_no),
  modify column board_no int not null auto_increment;
  
create table project_member(
  member_no int not null,
  name varchar(20) not null,
  age int not null,
  height int not null,
  weight int not null,  
  gender char(1) not null,
  LeftEye float(20) not null,
  RightEye float(20) not null,
  handPhone int not null
  
);

alter table project_member
  add constraint primary key (member_no),
  modify column member_no int not null auto_increment;
  
  
-- 게시판에 카테고리 컬럼 추가
alter table project_board
  add column category int not null;
  
  
  
  
  