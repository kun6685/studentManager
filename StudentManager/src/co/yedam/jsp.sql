-- �л�����(�л���ȣ, �̸�, ����ó, �ּ�, �������, ������¥)
-- table_student ���̺��

CREATE TABLE table_student (
  student_number VARCHAR2(10) PRIMARY KEY,
  student_name VARCHAR2(100) NOT NULL,
  student_phone VARCHAR2(20),
  address VARCHAR2(100),
  birth_date DATE,
  creation_date DATE DEFAULT sysdate
);



-- ������ �Է�

INSERT INTO table_student (student_number, student_name, student_phone)
VALUES('s2024-01', 'ȫ�浿', '010-1264-5678');

INSERT INTO table_student (student_number, student_name, student_phone, address)
VALUES('s2024-02', '��浿', '010-3333-4444', '���� 100����');

INSERT INTO table_student (student_number, student_name, student_phone, address)
VALUES('s2024-03', '�����', '010-3333-4444', '���� 100����');

INSERT INTO table_student (student_number, student_name, student_phone, address)
VALUES('s2024-04', '��α�', '010-3333-4444', '���� 100����');



-- ������ ����

UPDATE table_student
SET birth_date = to_date('19990705', 'yyyymmdd'),
    address = '���� 100����'
WHERE student_number = 's2024-01';

UPDATE table_student
SET birth_date = to_date('19960705', 'yyyymmdd')
WHERE student_number = 's2024-02';

UPDATE table_student
SET birth_date = to_date('19960705', 'yyyymmdd'),
    address = '���� 400����'
WHERE student_number = 's2024-03';

UPDATE table_student
SET birth_date = to_date('17120705', 'yyyymmdd')
WHERE student_number = 's2024-04';

UPDATE table_student
SET student_name = '���氪',
    student_phone = '���氪'
WHERE student_number = 's2024-04';



-- ���̺� ����

DELETE FROM table_student
WHERE student_number = 's2024-06';

SELECT *
FROM table_student;

SELECT *
FROM tab;