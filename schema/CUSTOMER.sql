--ȸ������
CREATE TABLE CUSTOMER (
	CUSTOMER_ID VARCHAR2(30) PRIMARY KEY,
	PWD VARCHAR2(30) NOT NULL,
	CUSTOMER_NAME VARCHAR2(12) NOT NULL,
	BIRTH DATE NOT NULL,
	EMAIL VARCHAR2(30),
	ADDR VARCHAR2(50),
	CONTACT VARCHAR2(15),
	SIGN_DATE DATE DEFAULT SYSDATE,
	SELLER VARCHAR2(6) DEFAULT NULL
);

--ȸ�� ���� �Է� 
INSERT INTO CUSTOMER VALUES('CHOI1','1111','�ֿ���', '1996-08-06', 'AAA111@naver.com', '��⵵ ������ ������', '010-1111-1111', SYSDATE);

INSERT INTO CUSTOMER VALUES('YOO', '2222', '���̾�', '1999-01-12', 'BBB222@naver.com', '�λ� ������ ���굿', '010-2222-2222', SYSDATE);

INSERT INTO CUSTOMER VALUES('CHOI2', '3333', '������','08-11-23', 'CCC333@naver.com', '���� �س��� ȭ����', '010-3333-3333', SYSDATE);

INSERT INTO CUSTOMER VALUES('KIM', '4444', '�����','05-12-25',  'DDD444@naver.com', '��õ ����Ȧ�� �־ȵ�', '010-4444-4444', SYSDATE);

INSERT INTO CUSTOMER VALUES('HYEON', '5555', '������','02-03-28', 'EEE555@naver.com', '���� ������ ���ϵ�', '010-5555-5555', SYSDATE);

--�Ǹ��� �Է�
INSERT INTO CUSTOMER VALUES('ADMIN', '1234', '�Ǹ���','1991-05-15', 'seller@naver.com', '��Ʋ��Ƽ�� �����ͻ�', '010-1111-1111', SYSDATE, 'SELLER');

--Ȯ�ο�
SELECT * FROM CUSTOMER;

INSERT INTO CUSTOMER VALUES(?, ?, ? ,? ,? ?, ?, SYSDATE);


--2)��������  �� �ڹٿ��� �������� ���� ����� �ɷ� !!  
--		   ������ �ƴϴ� !! -> DB�� ���� �� �� (���ư�)
--		   �����̴� -> DB���� 



--3) ���̵�/��й�ȣ ã�� 
--���̵�
SELECT CUSTOMER_ID FROM USER WHERE EMAIL = ?;

--��й�ȣ
SELECT USER SET PWD = ? WHERE ID = CUSTOMER_ID, CUSTOMER_NAME = ?; 


--4)��������� ����(��й�ȣ, �ּ�, ����ó, �̸���)
--��й�ȣ�� �����ϰ� ������? 2
UPDATE CUSTOMER SET  PWD = ? WHERE COSTOMER_NO = ? ; 

--�ּҸ� �����ϰ� ���� ��?
UPDATE CUSTOMER SET ADDR =? WHERE COSTOMER_NO= ? ;

--�̸��ϸ� �����ϰ� ������? 
UPDATE CUSTOMER SET EMAIL =? WHERE CUSTOMER_NO = ? ;


--5)��������� ���� (Ż��)
DELETE FROM CUSTOMER_ID WHERE CUSTOMER_NO =? ;

