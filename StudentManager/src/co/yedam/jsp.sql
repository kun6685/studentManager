-- 학생정보(학생번호, 이름, 연락처, 주소, 생년월일, 생성날짜)
-- table_student 테이블명

CREATE TABLE table_student (
  student_number VARCHAR2(10) PRIMARY KEY,
  student_name VARCHAR2(100) NOT NULL,
  student_phone VARCHAR2(20),
  address VARCHAR2(100),
  birth_date DATE,
  creation_date DATE DEFAULT sysdate
);



-- 데이터 입력

INSERT INTO table_student (student_number, student_name, student_phone)
VALUES('s2024-01', '홍길동', '010-1264-5678');

INSERT INTO table_student (student_number, student_name, student_phone, address)
VALUES('s2024-02', '김길동', '010-3333-4444', '서울 100번지');

INSERT INTO table_student (student_number, student_name, student_phone, address)
VALUES('s2024-03', '김민준', '010-3333-4444', '서울 100번지');

INSERT INTO table_student (student_number, student_name, student_phone, address)
VALUES('s2024-04', '김민규', '010-3333-4444', '서울 100번지');



-- 데이터 수정

UPDATE table_student
SET birth_date = to_date('19990705', 'yyyymmdd'),
    address = '대전 100번지'
WHERE student_number = 's2024-01';

UPDATE table_student
SET birth_date = to_date('19960705', 'yyyymmdd')
WHERE student_number = 's2024-02';

UPDATE table_student
SET birth_date = to_date('19960705', 'yyyymmdd'),
    address = '제주 400번지'
WHERE student_number = 's2024-03';

UPDATE table_student
SET birth_date = to_date('17120705', 'yyyymmdd')
WHERE student_number = 's2024-04';

UPDATE table_student
SET student_name = '변경값',
    student_phone = '변경값'
WHERE student_number = 's2024-04';



-- 테이블 삭제

DELETE FROM table_student
WHERE student_number = 's2024-06';

SELECT *
FROM table_student;

SELECT *
FROM tab;