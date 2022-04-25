create table board(
	idx number not null,
	title varchar2(100) not null,
	content varchar2(2000) not null,
	writer varchar2(30) not null,
	indate date default sysdate,
	count number default 0,
	primary key(idx)
);

create sequence board_idx;

insert into board(idx, title, content, writer)
values(board_idx.nextval, '스프링게시판', '스프링게시판', '관리자');
insert into board(idx, title, content, writer)
values(board_idx.nextval, '스프링게시판', '스프링게시판', '박하연');

select * from BOARD;
drop table board;
delete from board;