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
INSERT INTO CUSTOMER VALUES('CHOI1','1111','�ֿ���', '1996-08-06', 'AAA111@naver.com', '��⵵ ������ ������', '010-1111-1111', SYSDATE, DEFAULT);

INSERT INTO CUSTOMER VALUES('YOO', '2222', '���̾�', '1999-01-12', 'BBB222@naver.com', '�λ� ������ ���굿', '010-2222-2222', SYSDATE, DEFAULT);

INSERT INTO CUSTOMER VALUES('CHOI2', '3333', '������','08-11-23', 'CCC333@naver.com', '���� �س��� ȭ����', '010-3333-3333', SYSDATE, DEFAULT);

INSERT INTO CUSTOMER VALUES('KIM', '4444', '�����','05-12-25',  'DDD444@naver.com', '��õ ����Ȧ�� �־ȵ�', '010-4444-4444', SYSDATE, DEFAULT);

INSERT INTO CUSTOMER VALUES('HYEON', '5555', '������','02-03-28', 'EEE555@naver.com', '���� ������ ���ϵ�', '010-5555-5555', SYSDATE, DEFAULT);

--���̵� �ߺ� üũ 

select customer_id from customer where customer_id =? ;

--�Ǹ��� �Է�
INSERT INTO CUSTOMER VALUES('ADMIN', '1234', '�Ǹ���','1991-05-15', 'seller@naver.com', '��Ʋ��Ƽ�� �����ͻ�', '010-1111-1111', SYSDATE, 'SELLER');


--���ڵ� ����
DELETE FROM CUSTOMER WHERE CUSTOMER_ID = 'Q';

--Ȯ�ο�
SELECT * FROM CUSTOMER;


--Ŀ��
COMMIT

--�α���

--ȸ������ 
--INSERT INTO CUSTOMER VALUES(?, ?, ? ,? ,? ?, ?, SYSDATE);


--2)��������  �� �ڹٿ��� �������� ���� ����� �ɷ� !!  
--		   ������ �ƴϴ� !! -> DB�� ���� �� �� (���ư�)
--		   �����̴� -> DB���� 



--3) ���̵�/��й�ȣ ã�� 
--���̵�

--��й�ȣ



--4)��������� ����(��й�ȣ, �ּ�, ����ó, �̸���)
--��й�ȣ�� �����ϰ� ������? 2


--�ּҸ� �����ϰ� ���� ��?

--�̸��ϸ� �����ϰ� ������? 

--5)��������� ���� (Ż��)

