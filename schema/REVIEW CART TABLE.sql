CREATE TABLE REVIEW(
REVIEW_NO VARCHAR2(10) PRIMARY KEY,
LIQUOR_NO NUMBER REFERENCES LIQUOR(LIQUOR_NO) ,
CUSTOMER_ID VARCHAR2(30) REFERENCES CUSTOMER(CUSTOMER_ID),
WRITE_DATE DATE,
CONTENT VARCHAR2(50)
); 
