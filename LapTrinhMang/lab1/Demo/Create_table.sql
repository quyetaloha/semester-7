create table DEPARTMENT (
   DEPT_ID integer not null,
   DEPT_NAME varchar(255) not null,
   DEPT_NO varchar(20) not null,
   LOCATION varchar(255),
   primary key (DEPT_ID),
   unique (DEPT_NO)
);
 
create table EMPLOYEE (
   EMP_ID bigint not null,
   EMP_NAME varchar(50) not null,
   EMP_NO varchar(20) not null,
   HIRE_DATE date not null,
   IMAGE longblob,
   JOB varchar(30) not null,
   SALARY float not null,
   DEPT_ID integer not null,
   MNG_ID bigint,
   primary key (EMP_ID),
   unique (EMP_NO)
);
 
create table SALARY_GRADE (
   GRADE integer not null,
   HIGH_SALARY float not null,
   LOW_SALARY float not null,
   primary key (GRADE)
);
 
create table TIMEKEEPER (
   Timekeeper_Id varchar(36) not null,
   Date_Time datetime not null,
   In_Out char(1) not null,
   EMP_ID bigint not null,
   primary key (Timekeeper_Id)
);
 
alter table EMPLOYEE
   add index FK75C8D6AE269A3C9 (DEPT_ID),
   add constraint FK75C8D6AE269A3C9
   foreign key (DEPT_ID)
   references DEPARTMENT (DEPT_ID);
 
alter table EMPLOYEE
   add index FK75C8D6AE6106A42 (EMP_ID),
   add constraint FK75C8D6AE6106A42
   foreign key (EMP_ID)
   references EMPLOYEE (EMP_ID);
 
alter table EMPLOYEE
   add index FK75C8D6AE13C12F64 (MNG_ID),
   add constraint FK75C8D6AE13C12F64
   foreign key (MNG_ID)
   references EMPLOYEE (EMP_ID);
 
alter table TIMEKEEPER
   add index FK744D9BFF6106A42 (EMP_ID),
   add constraint FK744D9BFF6106A42
   foreign key (EMP_ID)
   references EMPLOYEE (EMP_ID);

insert into Department (DEPT_ID, DEPT_NAME, DEPT_NO, LOCATION)
values (10, 'ACCOUNTING', 'D10', 'NEW YORK');
insert into Department (DEPT_ID, DEPT_NAME, DEPT_NO, LOCATION)
values (20, 'RESEARCH', 'D20', 'DALLAS');

insert into Department (DEPT_ID, DEPT_NAME, DEPT_NO, LOCATION)
values (30, 'SALES', 'D30', 'CHICAGO');

insert into Department (DEPT_ID, DEPT_NAME, DEPT_NO, LOCATION)
values (40, 'OPERATIONS', 'D40', 'BOSTON');
-------------------------------------------------------------------------------------------------
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7839, 'KING', 'E7839', ('17-11-1981'), 'PRESIDENT', 5000, 10, null);
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7566, 'JONES', 'E7566', ('02-04-1981'), 'MANAGER', 2975, 20, 7839);
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7902, 'FORD', 'E7902', ('03-12-1981'), 'ANALYST', 3000, 20, 7566);
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7369, 'SMITH', 'E7369', ('17-12-1980'), 'CLERK', 800, 20, 7902);
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7698, 'BLAKE', 'E7698', ('01-05-1981'), 'MANAGER', 2850, 30, 7839);
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7499, 'ALLEN', 'E7499', ('20-02-1981'), 'SALESMAN', 1600, 30, 7698);
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7521, 'WARD', 'E7521', ('22-02-1981'), 'SALESMAN', 1250, 30, 7698);
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7654, 'MARTIN', 'E7654', ('28-09-1981'), 'SALESMAN', 1250, 30, 7698);
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7782, 'CLARK', 'E7782', ('09-06-1981'), 'MANAGER', 2450, 30, 7839);
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7788, 'SCOTT', 'E7788', ('19-04-1987'), 'ANALYST', 3000, 20, 7566);
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7844, 'TURNER', 'E7844', ('08-09-1981'), 'SALESMAN', 1500, 30, 7698);
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7876, 'ADAMS', 'E7876', ('23-05-1987'), 'CLERK', 1100, 20, 7698);
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7900, 'ADAMS', 'E7900', ('03-12-1981'), 'CLERK', 950, 30, 7698);
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7934, 'MILLER', 'E7934', ('23-01-1982'), 'CLERK', 1300, 10, 7698);
-------------------------------------------------------------------------------------------------
insert into Salary_Grade (GRADE, HIGH_SALARY, LOW_SALARY)
values (1, 9999, 3001);