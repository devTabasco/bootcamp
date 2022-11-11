/* DDL(Data Definition Language)
    : 관계형 데이터베이스 객체를 생성, 수정, 삭제
    : CREATE > ALTER, DROP
    Syntex
    [CREATE | ALTER | DROP] [OBJRCT-TYPE] [OBJECT-NAME]
*/
/* ACCOUNT 
    Syntex
    CREATE USER [ID] IDENTIFIED BY "[PW]"//사용
    (DEFAULT TABLESPACE [TABLESPACE-NAME]); --users로 배정//사용
    (TEMPORARY TABLESPACE [TABLESPACE-NAME]);
    (QUOTA [INT][Kb | Mb | Gb | UNLIBITED] ON [TABLESPACE-NAME]);//사용
    (ACCOUNT [UNLOCK | LOCK])
*/

/* 계정 운영 프로세스
    TEAM : DBA, DEV * 4
    DBA : changyong <-- SYS
        : CREATE SESSION : CONNECT ROLE : 
        : DBA ROLE
    DEV : mk, ej, gh, cy <-- DBA
        : CREATE SESSION : CONNECT ROLE :
        : RESOURCE ROLE
*/
select sr_name
from (
select stores.sr_name, stores.sr_locate, owners.ow_name as ownersName
from stores, owners
where stores.sr_owcode = owners.ow_code and owners.ow_name = '임창용')
;

select *
from stores, owners
where stores.sr_owcode = owners.ow_code and owners.ow_name = '임창용'

-- 계정생성
create user dba1
IDENTIFIED BY "123"
default tablespace users
quota UNLIMITED on users;

-- 권한주기
GRANT CREATE SESSION, DBA TO dba1;

-- 계정생성2
create user changyongdev
IDENTIFIED BY "1234"
default tablespace users
quota 20M on users;

-- 권한주기2
GRANT CREATE SESSION, resource TO changyongdev;
grant alter any table to keonho;

grant create any table to keonho;
revoke create view from changyong;
drop table keonho.members;
grant select on changyong.members to keonho;
/* Constraint 제약조건 : DML 구문에 적용
    1. Not null
    2. Unique
    3. PRIMARY KEY : 하나의 테이블에 1개의 PK만 존재
                    레코드의 유일성을 확보하며 Null을 허용X
    4. FK
    5. DF
    6. 

*/

select * from privs to keonho;

update mr
set password = '4321'
where member_id = 'KEONHO';

commit;

alter table changyong.members
ADD constraint MR_ID_PK primary key(member_id)
add constraint MR_PHONE_UK UNIQUE(phone_number);

grant select, insert, update on dba1.stores to mingyu;
grant select, insert, update on dba1.stores to changyongdev;
grant select, insert, update on dba1.stores to keonho;
grant select, insert, update on dba1.stores to eunjin18;

select * from SESSION_PRIVS;
select * from user_tab_privs;

delete
from products;

ALTER TABLE products DROP CONSTRAINT pr_cgcode_fk;
ALTER TABLE products DROP CONSTRAINT pr_status_fk;

commit;

/* ACCESSHISTORY :: AH */
--TABLE
create table ACCESSHISTORY(
AH_MRID   NVARCHAR(20),
AH_DATE    DATE,
AH_STATE   NUMBER(1,0)
)tablespace users;

create public synonym AH for changyong.ACCESSHISTORY;

create table categories(
AH_MRID   NVARCHAR(20),
AH_DATE    DATE,
AH_STATE   NUMBER(1,0)
)tablespace users;

create public synonym AH for changyong.ACCESSHISTORY;

--CONSTRAINT(add constraint)
add constraint foreign key () references ();

--GRANT :: alter any table
grant alter any table to MINGYU;
--CONSTRAINT(modify)
alter table changyong.ACCESSHISTORY
modify AH_DATE DEFAULT sysdate
modify AH_STATE not null;

alter table changyong.TODO
modify TD_FEEDBACK DEFAULT 'NONE'
modify TD_STATE DEFAULT 'B'
modify TD_ACTIVATION DEFAULT 'A';
commit;

select sysdate from dual;
--insert
insert into dba1.categories(cg_code, cg_name) values ('SN','스낵류');
insert into dba1.categories(cg_code, cg_name) values ('BV','음료');
insert into dba1.categories(cg_code, cg_name) values ('BK','베이커리');
insert into dba1.categories(cg_code, cg_name) values ('DN','생필품');
insert into dba1.categories(cg_code, cg_name) values ('AC','주류');
insert into dba1.categories(cg_code, cg_name) values ('EX','단종');
insert into dba1.categories(cg_code, cg_name) values ('SO','품절');
insert into dba1.categories(cg_code, cg_name) values ('AS','판매가능');
insert into dba1.categories(cg_code, cg_name) values ('BS','판매예정');

select * from dba1.categories;

alter table dba1.products
modify pr_name NVARCHAR2(20);

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



-----------------------
insert into dba1.products(pr_code, pr_name) values ('LPA01','롯데 아몬드 빼빼로');
insert into dba1.products(pr_code, pr_name) values ('LPB01','롯데 빼빼로');
insert into dba1.products(pr_code, pr_name) values ('LPN01','롯데 누드 빼빼로');
insert into dba1.products(pr_code, pr_name) values ('LPM01','롯데 민트 빼빼로');
insert into dba1.products(pr_code, pr_name) values ('LPC01','롯데 쿠앤크 빼빼로');
insert into dba1.products(pr_code, pr_name) values ('SBP01','포켓몬 피카츄빵');
insert into dba1.products(pr_code, pr_name) values ('SBP02','포켓몬 라이츄빵');
insert into dba1.products(pr_code, pr_name) values ('SBP03','포켓몬 파이리빵');
insert into dba1.products(pr_code, pr_name) values ('SBP04','포켓몬 꼬부기빵');
insert into dba1.products(pr_code, pr_name) values ('SBP05','포켓몬 버터플빵');
insert into dba1.products(pr_code, pr_name) values ('MMC01','매일 초코우유');
insert into dba1.products(pr_code, pr_name) values ('MMS01','매일 딸기우유');
insert into dba1.products(pr_code, pr_name) values ('MMB01','매일 바나나우유');
insert into dba1.products(pr_code, pr_name) values ('MMM01','매일 민트초코우유');
insert into dba1.products(pr_code, pr_name) values ('MMC02','매일 초코바나나우유');

insert into dba1.products(pr_code, pr_name) values ('AC001','참이슬');
insert into dba1.products(pr_code, pr_name) values ('AC002','처음처럼');
insert into dba1.products(pr_code, pr_name) values ('AC003','진로이즈백');
insert into dba1.products(pr_code, pr_name) values ('AC004','청하');
insert into dba1.products(pr_code, pr_name) values ('AC005','백화수복');

insert into dba1.storeproducts(sp_prcode,sp_owcode,sp_purchase_price,sp_sales_price,sp_status,sp_cgcode,sp_stock) values();

commit;
insert into dba1.owners(ow_code,ow_name) values('001','김민규');
insert into dba1.owners(ow_code,ow_name) values('002','임창용');
insert into dba1.owners(ow_code,ow_name) values('003','염은진');
insert into dba1.owners(ow_code,ow_name) values('004','박건호');

insert into dba1.customers(cm_code,cm_name,cm_phone) values('0000','비회원','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0001','정현우','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0002','송은혜','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0003','김호원','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0004','황영호','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0005','이정한','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0006','홍준택','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0007','김하늘','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0008','이예림','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0009','훈짱','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0010','윤지수','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0011','김지웅','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0012','박초롱','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0013','곽대훈','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0014','정영준','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0015','이규환','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0016','주성현','01000000000');
insert into dba1.customers(cm_code,cm_name,cm_phone) values('0017','김준석','01000000000');

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
/*상품분류코드
- 과자(SN)
- 음료(BV)
- 베이커리(BK)
- 생필품(DN)
- 주류(AC)

상품상태코드
- 단종(EX)
- 품절(SO)
- 판매가능(AS)
- 판매예정(BS)
*/

update AH
set AH_state = -1
where ah_mrid = 'KEONHO';
commit;