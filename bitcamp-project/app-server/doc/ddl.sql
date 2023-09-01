-- 게시글 첨부 파일 테이블 삭제
DROP TABLE IF EXISTS project_board_file;

-- 게시판 유형 테이블 삭제
DROP TABLE IF EXISTS project_board_category;

-- 게시글 테이블 삭제
DROP TABLE IF EXISTS project_board;

-- 회원 테이블 삭제
DROP TABLE IF EXISTS project_member;

CREATE TABLE project_member (
  member_no INT AUTO_INCREMENT NOT NULL COMMENT '번호',
  name VARCHAR(20) NOT NULL,
  age INT NOT NULL,
  height INT NOT NULL,
  weight INT NOT NULL,
  gender CHAR(1) NOT NULL,
  leftEye FLOAT(20) NOT NULL,
  rightEye FLOAT(20) NOT NULL,
  handPhone VARCHAR(11) NOT NULL,
  password VARCHAR(100) NOT NULL,
  created_date DATE DEFAULT current_date() NOT NULL,
  PRIMARY KEY (member_no),
  UNIQUE INDEX UIX_project_member (handPhone ASC)
);

-- 게시글 테이블 생성
CREATE TABLE project_board (
  board_no INT AUTO_INCREMENT NOT NULL COMMENT '번호',
  title VARCHAR(255) NOT NULL,
  content MEDIUMTEXT NOT NULL,
  view_count INT DEFAULT 0 NOT NULL,
  created_date DATETIME DEFAULT NOW() NOT NULL,
  writer INT NOT NULL,
  category INT NOT NULL,
  PRIMARY KEY (board_no),
  FOREIGN KEY (writer) REFERENCES project_member (member_no),
  FOREIGN KEY (category) REFERENCES project_board_category (board_category_no)
);

-- 게시판 유형 테이블 생성
CREATE TABLE project_board_category (
  board_category_no INT AUTO_INCREMENT NOT NULL COMMENT '번호',
  name VARCHAR(50) NOT NULL,
  PRIMARY KEY (board_category_no),
  UNIQUE INDEX UIX_project_board_category (name ASC)
);

-- 게시글 첨부 파일 테이블 생성
CREATE TABLE project_board_file (
  board_file_no INT AUTO_INCREMENT NOT NULL COMMENT '번호',
  filepath VARCHAR(255) NOT NULL,
  board_no INT NOT NULL,
  PRIMARY KEY (board_file_no),
  FOREIGN KEY (board_no) REFERENCES project_board (board_no)
);