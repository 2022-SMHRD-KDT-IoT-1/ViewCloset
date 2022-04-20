select * from memberInfo;

create table memberInfo(
	id varchar2(20),
	pw varchar2(20),
	nick varchar2(20)
);

delete from memberInfo where id is NULL;

select * from tbl_memberInfo;