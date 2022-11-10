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

-- 계정생성
create user changyong
IDENTIFIED BY "ckddydWkd"
default tablespace users
quota UNLIMITED on users;

-- 권한주기
GRANT CREATE SESSION, DBA TO changyong;

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
ALTER TABLE changyong OWNER TO keonho;
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

grant select, insert, update on changyong.accesshistory to changyongdev;

select * from SESSION_PRIVS;
select * from user_tab_privs;

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
modify AH_DATE DEFAULT sysdate;
modify AH_STATE not null;

select sysdate from dual;
--insert
insert into AH(AH_MRID, AH_DATE, AH_STATE) values ('changyongdev',default,1);

update AH
set AH_state = -1
where ah_mrid = 'KEONHO';
commit;