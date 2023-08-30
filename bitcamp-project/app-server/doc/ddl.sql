
  
create table project_member(
  member_no int not null,
  name varchar(20) not null,
  age int not null,
  height int not null,
  weight int not null,  
  gender char(1) not null,
  leftEye float(20) not null,
  rightEye float(20) not null,
  handPhone varchar(20) not null,
  password varchar(100) not null,
  created_date date default (current_date())
);

alter table project_member
  add constraint primary key (member_no),
  modify column member_no int not null auto_increment;

alter table project_member
  add constraint project_member_uk unique (handPhone);
  
CREATE TABLE project_board (
  board_no     INTEGER      NOT NULL COMMENT '번호', -- 번호
  title        VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
  content      MEDIUMTEXT   NOT NULL COMMENT '내용', -- 내용
  view_count   INTEGER      NOT NULL DEFAULT 0 COMMENT '조회수', -- 조회수
  created_date DATETIME     NOT NULL DEFAULT now() COMMENT '등록일', -- 등록일
  writer       INTEGER      NOT NULL COMMENT '작성자', -- 작성자
  category     INTEGER      NOT NULL COMMENT '게시판' -- 게시판
)
COMMENT '게시글';

-- 게시글
ALTER TABLE project_board
  ADD CONSTRAINT PK_project_board -- 게시글 기본키
  PRIMARY KEY (
  board_no -- 번호
  );

ALTER TABLE project_board
  MODIFY COLUMN board_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '번호';

-- 게시판유형
CREATE TABLE project_board_category (
  board_category_no INTEGER     NOT NULL COMMENT '번호', -- 번호
  name              VARCHAR(50) NOT NULL COMMENT '게시판이름' -- 게시판이름
)
COMMENT '게시판유형';

-- 게시판유형
ALTER TABLE project_board_category
  ADD CONSTRAINT PK_project_board_category -- 게시판유형 기본키
  PRIMARY KEY (
  board_category_no -- 번호
  );

-- 게시판유형 유니크 인덱스
CREATE UNIQUE INDEX UIX_project_board_category
  ON project_board_category ( -- 게시판유형
    name ASC -- 게시판이름
  );

ALTER TABLE project_board_category
  MODIFY COLUMN board_category_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '번호';

-- 게시글첨부파일
CREATE TABLE project_board_file (
  board_file_no INTEGER      NOT NULL COMMENT '번호', -- 번호
  filepath      VARCHAR(255) NOT NULL COMMENT '파일경로', -- 파일경로
  board_no      INTEGER      NOT NULL COMMENT '게시글번호' -- 게시글번호
)
COMMENT '게시글첨부파일';

-- 게시글첨부파일
ALTER TABLE project_board_file
  ADD CONSTRAINT PK_project_board_file -- 게시글첨부파일 기본키
  PRIMARY KEY (
  board_file_no -- 번호
  );

ALTER TABLE project_board_file
  MODIFY COLUMN board_file_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '번호';

-- 게시글
ALTER TABLE project_board
  ADD CONSTRAINT FK_project_member_TO_project_board -- 회원 -> 게시글
  FOREIGN KEY (
  writer -- 작성자
  )
  REFERENCES project_member ( -- 회원
  member_no -- 번호
  );

-- 게시글
ALTER TABLE project_board
  ADD CONSTRAINT FK_project_board_category_TO_project_board -- 게시판유형 -> 게시글
  FOREIGN KEY (
  category -- 게시판
  )
  REFERENCES project_board_category ( -- 게시판유형
  board_category_no -- 번호
  );

-- 게시글첨부파일
ALTER TABLE project_board_file
  ADD CONSTRAINT FK_project_board_TO_project_board_file -- 게시글 -> 게시글첨부파일
  FOREIGN KEY (
  board_no -- 게시글번호
  )
  REFERENCES project_board ( -- 게시글
  board_no -- 번호
  );


  
  
  
  
  