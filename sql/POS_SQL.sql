/* CREATE FORM
CREATE TABLE [TABLE_NAME](
[COLUMN_NAME] [DOLUMN_DATA_TYPE],
[COLUMN_NAME] [DOLUMN_DATA_TYPE]
)TABLESPACE [DBF_NAME];
*/

/* ADD CONSTRAINT FORM
=ALTER TABLE FORM=
ALTER TABLE [OWNER.TABLE_NAME]
=PRIMARY KEY=
ADD CONSTRAINT [CONSTRAINT_NAME] PRIMARY KEY  ([THIS_TABLE's_COLUMN]) 
=FOREIGN KEY=
ADD CONSTRAINT [CONSTRAINT_NAME] FOREIGN KEY  ([THIS_TABLE's_COLUMN]) REFERENCES [OWNER_TABLE_NAME].([THIS_TABLE's_COLUMN])
=MODIFY FORM=
MODIFY [THIS_TABLE's_COLUMN_NAME] [DEFAULT [DEFAULT_VALUE] , NOT NULL , DEFAULT [DEFAULT_VALUE] NOT NULL]
*/
/* CREATE SYNONYM FORM
CREATE [PUBLIC OR (BLANK)] SYNONYM [SYNONYM_NAME] FOR [REFERENCE_]

*/

---------------------------------------
-----------CREATE TABLE-------------
---------------------------------------

--CATEGORY CREATE
CREATE TABLE CATEGORIES(
 CG_CODE NCHAR(2),
 CG_NAME NVARCHAR2(20)
 )TABLESPACE USERS;
 
 --synonym
 CREATE PUBLIC SYNONYM CG FOR DBA1.CATEGORIES;
 
 --make constraint
 ALTER TABLE DBA1.CATEGORIES
 ADD CONSTRAINT CG_CODE_PK PRIMARY KEY(CG_CODE)
 MODIFY CG_NAME NOT NULL;
 
 --PRODUCTS CREATE
 CREATE TABLE PRODUCTS(
 PR_CODE NCHAR(5),
 PR_NAME NVARCHAR2(5),
 PR_PURCHASE_PRICE NVARCHAR2(10),
 PR_SALES_PRICE NVARCHAR2(10),
 PR_STATUS NCHAR(2),
 PR_CGCODE NCHAR(2),
 PR_STOCK NVARCHAR2(10)
 )TABLESPACE USERS;
 
 insert into 테이블명(컬럼명s) values(해당 컬럼의 값);

-- drop columns 
 ALTER TABLE PRODUCTS  DROP  COLUMN PR_PURCHASE_PRICE ;
 ALTER TABLE PRODUCTS  DROP  COLUMN PR_SALES_PRICE;
 ALTER TABLE PRODUCTS  DROP  COLUMN PR_STATUS;
 ALTER TABLE PRODUCTS  DROP  COLUMN PR_CGCODE ;
 ALTER TABLE PRODUCTS  DROP  COLUMN PR_STOCK;
 
 CREATE PUBLIC SYNONYM PR FOR PRODUCTS;
 
 --make constraint
 ALTER TABLE DBA1.PRODUCTS
 ADD CONSTRAINT PR_CODE_PK PRIMARY KEY(PR_CODE)
 ADD CONSTRAINT PR_STATUS_FK FOREIGN KEY(PR_STATUS) REFERENCES CATEGORIES(CG_CODE)
 ADD CONSTRAINT PR_CGCODE_FK FOREIGN KEY(PR_CGCODE) REFERENCES CATEGORIES(CG_CODE)
 MODIFY PR_NAME NOT NULL
 MODIFY PR_PURCHASE_PRICE DEFAULT '0' NOT NULL
 MODIFY PR_SALES_PRICE DEFAULT '0' NOT NULL
 MODIFY PR_STOCK DEFAULT '0' NOT NULL;
 
 --STOREPRODUCTS CREATE
 CREATE TABLE STOREPRODUCTS(
 SP_PRCODE NCHAR(5),
 SP_OWCODE NCHAR(3),
 SP_PURCHASE_PRICE NVARCHAR2(10),
 SP_SALES_PRICE NVARCHAR2(10),
 SP_STATUS NCHAR(2),
 SP_CGCODE NCHAR(2),
 SP_STOCK NVARCHAR2(10)
 )TABLESPACE USERS;
 
 --make constraint
 ALTER TABLE DBA1.STOREPRODUCTS
 ADD CONSTRAINT SP_PRCODE_OWCODE_PK PRIMARY KEY(SP_PRCODE, SP_OWCODE)
 ADD CONSTRAINT SP_PRCODE_FK FOREIGN KEY (SP_PRCODE) REFERENCES PRODUCTS(PR_CODE)
 ADD CONSTRAINT SP_OWCODE_FK FOREIGN KEY (SP_OWCODE) REFERENCES OWNERS(OW_CODE)
 ADD CONSTRAINT SP_STATUS_FK FOREIGN KEY (SP_STATUS) REFERENCES CATEGORIES(CG_CODE)
 ADD CONSTRAINT SP_CGCODE_FK FOREIGN KEY (SP_CGCODE) REFERENCES CATEGORIES(CG_CODE);
 
 --make constraint
 ALTER TABLE DBA1.STOREPRODUCTS
 MODIFY SP_STATUS NOT NULL
 MODIFY SP_CGCODE NOT NULL
 MODIFY SP_PURCHASE_PRICE DEFAULT '0' NOT NULL
 MODIFY SP_SALES_PRICE DEFAULT '0' NOT NULL
 MODIFY SP_STOCK DEFAULT '0' NOT NULL;
 
 --Grant select, insert, update on dba1.tables
 GRANT SELECT, INSERT, UPDATE ON DBA1.STOREPRODUCTS TO MINGYU;
 GRANT SELECT, INSERT, UPDATE ON DBA1.STOREPRODUCTS TO CHANGYONGDEV;
 GRANT SELECT, INSERT, UPDATE ON DBA1.STOREPRODUCTS TO KEONHO;
 GRANT SELECT, INSERT, UPDATE ON DBA1.STOREPRODUCTS TO EUNJIN18;
 
 --CUSTOMERS CREATE
 CREATE TABLE CUSTOMERS(
 CM_CODE NCHAR(4),
 CM_NAME NVARCHAR2(10),
 CM_PHONE NVARCHAR2(11)
 )TABLESPACE USERS;
 
 --make constraint
 ALTER TABLE DBA1.CUSTOMERS
 ADD CONSTRAINT CM_CODE_PK PRIMARY KEY(CM_CODE)
 MODIFY CM_NAME NOT NULL
 MODIFY CM_PHONE DEFAULT 'NONE' NOT NULL;
 
 --OWNERS CREATE
 CREATE TABLE OWNERS(
 OW_CODE NCHAR(3),
 OW_NAME NVARCHAR2(10)
 )TABLESPACE USERS;
 
 --make constraint
 ALTER TABLE DBA1.OWNERS
 ADD CONSTRAINT OW_CODE PRIMARY KEY(OW_CODE)
 MODIFY OW_NAME NOT NULL;
 
 --MEMBER CREATE
 CREATE TABLE MEMBER(
 ME_CMCODE NCHAR(4),
 ME_OWCODE NCHAR(3)
 )TABLESPACE USERS;
 
 --make constraint
 ALTER TABLE DBA1.MEMBER
 ADD CONSTRAINT ME_CMCODE_OWCODE_PK PRIMARY KEY(ME_CMCODE, ME_OWCODE)
 ADD CONSTRAINT ME_CMCODE_FK FOREIGN KEY(ME_CMCODE) REFERENCES CUSTOMERS(CM_CODE)
 ADD CONSTRAINT ME_OWCODE_FK FOREIGN KEY(ME_OWCODE) REFERENCES OWNERS(OW_CODE);
 
 --STORES CREATE
 CREATE TABLE STORES(
 SR_OWCODE NCHAR(3),
 SR_CODE NCHAR(10),
 SR_NAME NVARCHAR2(20),
 SR_LOCATE NVARCHAR2(50),
 SR_PHONE NVARCHAR2(11)
 )TABLESPACE USERS;
 
 --make constraint
 ALTER TABLE DBA1.STORES
 ADD CONSTRAINT SR_OWCODE_CODE_PK PRIMARY KEY(SR_OWCODE,SR_CODE)
 ADD CONSTRAINT SR_OWCODE_FK FOREIGN KEY(SR_OWCODE) REFERENCES OWNERS(OW_CODE)
 MODIFY SR_NAME NOT NULL
 MODIFY SR_LOCATE NOT NULL
 MODIFY SR_PHONE NOT NULL;
 
 --ORDERS CREATE
 CREATE TABLE ORDERS(
 OS_OWCODE NCHAR(3), 
 OS_SRCODE NCHAR(10),
 OS_CMCODE NCHAR(4),
 OS_ORDER_DATE DATE,
 OS_ORDER_STATUS NUMBER(1,0)
 )TABLESPACE USERS;
 
 --make constraint
 ALTER TABLE DBA1.ORDERS
 ADD CONSTRAINT OS_ORDERS_PK PRIMARY KEY (OS_OWCODE, OS_SRCODE, OS_CMCODE, OS_ORDER_DATE)
 ADD CONSTRAINT OS_OWCODE_SRCODE_FK FOREIGN KEY(OS_OWCODE, OS_SRCODE) REFERENCES STORES(SR_OWCODE, SR_CODE)
 ADD CONSTRAINT OS_OWCODE_CMCODE_FK FOREIGN KEY(OS_OWCODE, OS_CMCODE) REFERENCES MEMBER(ME_OWCODE, ME_CMCODE)
 MODIFY OS_ORDER_DATE DEFAULT SYSDATE
 MODIFY OS_ORDER_STATUS DEFAULT '0';

--ORDERDETAILS CREATE
CREATE TABLE ORDERDETAILS(
OD_OWCODE NCHAR(3),
OD_SRCODE NCHAR(10),
OD_CMCODE NCHAR(4),
OD_ORDER_DATE DATE,
OD_PRCODE NCHAR(5),
OD_ORDER_COUNT NUMBER(3,0)
)TABLESPACE USERS;
 
 --make constraint
 ALTER TABLE DBA1.ORDERDETAILS
ADD CONSTRAINT OD_ORDER_DETAILS_PK PRIMARY KEY (OD_OWCODE, OD_SRCODE, OD_CMCODE, OD_ORDER_DATE, OD_PRCODE)
ADD CONSTRAINT OD_ORDER_DETAILS_FK FOREIGN KEY (OD_OWCODE, OD_SRCODE, OD_CMCODE, OD_ORDER_DATE) REFERENCES ORDERS(OS_OWCODE, OS_SRCODE, OS_CMCODE, OS_ORDER_DATE)
ADD CONSTRAINT OD_PRCODE_FK FOREIGN KEY (OD_PRCODE) REFERENCES PRODUCTS(PR_CODE)
MODIFY OD_ORDER_COUNT DEFAULT 0 NOT NULL; 

-- TABLES SYNONYM
CREATE PUBLIC SYNONYM CM FOR DBA1.CUSTOMERS;
CREATE PUBLIC SYNONYM OW FOR DBA1.OWNERS;
CREATE PUBLIC SYNONYM ME FOR DBA1.MEMBER;
CREATE PUBLIC SYNONYM SR FOR DBA1.STORES;
CREATE PUBLIC SYNONYM OS FOR DBA1.ORDERS;
CREATE PUBLIC SYNONYM OD FOR DBA1.ORDERDETAILS;

---------------------------------------
-----------INSERT DATA--------------
---------------------------------------
--STORE DATA INSERT
INSERT INTO DBA1.STORES(SR_OWCODE, SR_CODE, SR_NAME, SR_LOCATE, SR_PHONE)
VALUES('001', '2022111001', '���� �����', '��õ�� ����Ȧ�� ����Ե�', '01045454545');

INSERT INTO DBA1.STORES(SR_OWCODE, SR_CODE, SR_NAME, SR_LOCATE, SR_PHONE)
VALUES('002', '2022111002', '���� ���ι�', '��õ�� ����Ȧ�� �����Ե�', '01074747474');

INSERT INTO DBA1.STORES(SR_OWCODE, SR_CODE, SR_NAME, SR_LOCATE, SR_PHONE)
VALUES('003', '2022111003', '������ �����ǹ�', '��õ�� ����Ȧ�� ���� ����', '01082828282');

INSERT INTO DBA1.STORES(SR_OWCODE, SR_CODE, SR_NAME, SR_LOCATE, SR_PHONE)
VALUES('004', '2022111004', '���� �����', '��õ�� ���� ����͵�', '01026262626');

COMMIT;
-------------------------------------------------------��뾲,�ִr��
select sysdate from dual;

/*CATEGORIES TABLE's VALUES*/
insert into dba1.categories(cg_code, cg_name) values ('SN','������');
insert into dba1.categories(cg_code, cg_name) values ('BV','����');
insert into dba1.categories(cg_code, cg_name) values ('BK','����Ŀ��');
insert into dba1.categories(cg_code, cg_name) values ('DN','����ǰ');
insert into dba1.categories(cg_code, cg_name) values ('AC','�ַ�');
insert into dba1.categories(cg_code, cg_name) values ('EX','����');
insert into dba1.categories(cg_code, cg_name) values ('SO','ǰ��');
insert into dba1.categories(cg_code, cg_name) values ('AS','�ǸŰ���');
insert into dba1.categories(cg_code, cg_name) values ('BS','�Ǹſ���');

select * from dba1.categories;

-----------------------------------------------------------------------------------------------------------------------------------
/*TABLE PRODUCTS MODIFY COLUMN DATA TYPE */
alter table dba1.products
modify pr_name NVARCHAR2(20);

-----------------------------------------------------------------------------------------------------------------------------------
/*STOREPRODUCTS TABLE's VALUES*/
insert into dba1.storeproducts(sp_prcode,sp_owcode,sp_purchase_price,sp_sales_price,sp_status,sp_cgcode,sp_stock) values ('LPA01','004','500','1200','AS','SN','30');
insert into dba1.storeproducts(sp_prcode,sp_owcode,sp_purchase_price,sp_sales_price,sp_status,sp_cgcode,sp_stock) values ('LPB01','004','500','1200','AS','SN','30');
insert into dba1.storeproducts(sp_prcode,sp_owcode,sp_purchase_price,sp_sales_price,sp_status,sp_cgcode,sp_stock) values ('LPN01','004','500','1200','AS','SN','30');
insert into dba1.storeproducts(sp_prcode,sp_owcode,sp_purchase_price,sp_sales_price,sp_status,sp_cgcode,sp_stock) values ('LPM01','004','500','1200','AS','SN','30');
insert into dba1.storeproducts(sp_prcode,sp_owcode,sp_purchase_price,sp_sales_price,sp_status,sp_cgcode,sp_stock) values ('LPC01','004','500','1200','AS','SN','30');
insert into dba1.storeproducts(sp_prcode,sp_owcode,sp_purchase_price,sp_sales_price,sp_status,sp_cgcode,sp_stock) values ('SBP01','004','400','1000','AS','BK','30');
insert into dba1.storeproducts(sp_prcode,sp_owcode,sp_purchase_price,sp_sales_price,sp_status,sp_cgcode,sp_stock) values ('SBP02','004','500','1400','AS','BK','30');
insert into dba1.storeproducts(sp_prcode,sp_owcode,sp_purchase_price,sp_sales_price,sp_status,sp_cgcode,sp_stock) values ('SBP03','004','600','1250','AS','BK','30');
insert into dba1.storeproducts(sp_prcode,sp_owcode,sp_purchase_price,sp_sales_price,sp_status,sp_cgcode,sp_stock) values ('SBP04','004','450','1300','AS','BK','30');
insert into dba1.storeproducts(sp_prcode,sp_owcode,sp_purchase_price,sp_sales_price,sp_status,sp_cgcode,sp_stock) values ('SBP05','004','700','1500','AS','BK','30');
insert into dba1.storeproducts(sp_prcode,sp_owcode,sp_purchase_price,sp_sales_price,sp_status,sp_cgcode,sp_stock) values ('MMC01','004','400','1000','AS','BV','30');
insert into dba1.storeproducts(sp_prcode,sp_owcode,sp_purchase_price,sp_sales_price,sp_status,sp_cgcode,sp_stock) values ('MMS01','004','500','1400','AS','BV','30');
insert into dba1.storeproducts(sp_prcode,sp_owcode,sp_purchase_price,sp_sales_price,sp_status,sp_cgcode,sp_stock) values ('MMB01','004','600','1250','AS','BV','30');
insert into dba1.storeproducts(sp_prcode,sp_owcode,sp_purchase_price,sp_sales_price,sp_status,sp_cgcode,sp_stock) values ('MMM01','004','450','1300','AS','BV','30');
insert into dba1.storeproducts(sp_prcode,sp_owcode,sp_purchase_price,sp_sales_price,sp_status,sp_cgcode,sp_stock) values ('MMC02','004','700','1500','AS','BV','30');
insert into dba1.storeproducts(sp_prcode,sp_owcode,sp_purchase_price,sp_sales_price,sp_status,sp_cgcode,sp_stock) values ('AC001','004','400','1000','AS','AC','30');
insert into dba1.storeproducts(sp_prcode,sp_owcode,sp_purchase_price,sp_sales_price,sp_status,sp_cgcode,sp_stock) values ('AC002','004','500','1400','AS','AC','30');
insert into dba1.storeproducts(sp_prcode,sp_owcode,sp_purchase_price,sp_sales_price,sp_status,sp_cgcode,sp_stock) values ('AC003','004','600','1250','AS','AC','30');
insert into dba1.storeproducts(sp_prcode,sp_owcode,sp_purchase_price,sp_sales_price,sp_status,sp_cgcode,sp_stock) values ('AC004','004','450','1300','AS','AC','30');
insert into dba1.storeproducts(sp_prcode,sp_owcode,sp_purchase_price,sp_sales_price,sp_status,sp_cgcode,sp_stock) values ('AC005','004','700','1500','AS','AC','30');
commit;

-----------------------------------------------------------------------------------------------------------------------------------
/*PRODUCTS TABLE's VALUES*/
insert into dba1.products(pr_code, pr_name) values ('LPA01','�Ե� �Ƹ�� ������');
insert into dba1.products(pr_code, pr_name) values ('LPB01','�Ե� ������');
insert into dba1.products(pr_code, pr_name) values ('LPN01','�Ե� ���� ������');
insert into dba1.products(pr_code, pr_name) values ('LPM01','�Ե� ��Ʈ ������');
insert into dba1.products(pr_code, pr_name) values ('LPC01','�Ե� ���ũ ������');
insert into dba1.products(pr_code, pr_name) values ('SBP01','���ϸ� ��ī��');
insert into dba1.products(pr_code, pr_name) values ('SBP02','���ϸ� ������');
insert into dba1.products(pr_code, pr_name) values ('SBP03','���ϸ� ���̸���');
insert into dba1.products(pr_code, pr_name) values ('SBP04','���ϸ� ���α⻧');
insert into dba1.products(pr_code, pr_name) values ('SBP05','���ϸ� �����û�');
insert into dba1.products(pr_code, pr_name) values ('MMC01','���� ���ڿ���');
insert into dba1.products(pr_code, pr_name) values ('MMS01','���� �������');
insert into dba1.products(pr_code, pr_name) values ('MMB01','���� �ٳ�������');
insert into dba1.products(pr_code, pr_name) values ('MMM01','���� ��Ʈ���ڿ���');
insert into dba1.products(pr_code, pr_name) values ('MMC02','���� ���ڹٳ�������');

insert into dba1.products(pr_code, pr_name) values ('AC001','���̽�');
insert into dba1.products(pr_code, pr_name) values ('AC002','ó��ó��');
insert into dba1.products(pr_code, pr_name) values ('AC003','���������');
insert into dba1.products(pr_code, pr_name) values ('AC004','û��');
insert into dba1.products(pr_code, pr_name) values ('AC005','��ȭ����');

commit;

-----------------------------------------------------------------------------------------------------------------------------------
/*OWNERS TABLE's VALUES*/
insert into dba1.owners(ow_code,ow_name) values('001','��α�');
insert into dba1.owners(ow_code,ow_name) values('002','��â��');
insert into dba1.owners(ow_code,ow_name) values('003','������');
insert into dba1.owners(ow_code,ow_name) values('004','�ڰ�ȣ');

-----------------------------------------------------------------------------------------------------------------------------------
/*CUSTOMERS TABLE's VALUES*/
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0000','��ȸ��','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0001','������','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0002','������','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0003','��ȣ��','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0004','Ȳ��ȣ','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0005','������','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0006','ȫ����','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0007','���ϴ�','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0008','�̿���','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0009','��¯','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0010','������','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0011','������','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0012','���ʷ�','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0013','������','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0014','������','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0015','�̱�ȯ','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0016','�ּ���','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0017','���ؼ�','01000000000');

-----------------------------------------------------------------------------------------------------------------------------------
/*MEMBER TABLE's VALUES*/
insert into dba1.member(me_cmcode,me_owcode) values('0000','001');
insert into dba1.member(me_cmcode,me_owcode) values('0000','002');
insert into dba1.member(me_cmcode,me_owcode) values('0000','003');
insert into dba1.member(me_cmcode,me_owcode) values('0000','004');
insert into dba1.member(me_cmcode,me_owcode) values('0001','001');
insert into dba1.member(me_cmcode,me_owcode) values('0002','001');
insert into dba1.member(me_cmcode,me_owcode) values('0003','001');
insert into dba1.member(me_cmcode,me_owcode) values('0004','001');
insert into dba1.member(me_cmcode,me_owcode) values('0005','002');
insert into dba1.member(me_cmcode,me_owcode) values('0006','002');
insert into dba1.member(me_cmcode,me_owcode) values('0007','002');
insert into dba1.member(me_cmcode,me_owcode) values('0008','002');
insert into dba1.member(me_cmcode,me_owcode) values('0009','003');
insert into dba1.member(me_cmcode,me_owcode) values('0010','003');
insert into dba1.member(me_cmcode,me_owcode) values('0011','003');
insert into dba1.member(me_cmcode,me_owcode) values('0012','003');
insert into dba1.member(me_cmcode,me_owcode) values('0013','004');
insert into dba1.member(me_cmcode,me_owcode) values('0014','004');
insert into dba1.member(me_cmcode,me_owcode) values('0015','004');
insert into dba1.member(me_cmcode,me_owcode) values('0016','004');

commit;

-----------------------------------------------------------------------------------------------------------------------------------

/*��ǰ�з��ڵ�
- ����(SN)
- ����(BV)
- ����Ŀ��(BK)
- ����ǰ(DN)
- �ַ�(AC)

��ǰ�����ڵ�
- ����(EX)
- ǰ��(SO)
- �ǸŰ���(AS)
- �Ǹſ���(BS)
*/

-----------------------------------------------------------------------------------------------------------------------------------
/*HOW TO UPDATE(FORM)*/
update AH set AH_state = -1 where ah_mrid = 'KEONHO';

commit;
