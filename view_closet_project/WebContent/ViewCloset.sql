-- ���̺� ������ ���踦 ����Ͽ� �� ���� �����ص� ������ �߻����� �ʰ� ���ĵǾ����ϴ�. --

-- tbl_member Table Create SQL --
drop table tbl_memberInfo;
drop table tbl_codi;
drop table tbl_clothes;

create table tbl_memberInfo(
    m_id VARCHAR2(20) NOT NULL, 
    m_pw VARCHAR2(20) NOT NULL, 
    m_phone VARCHAR2(20) NOT NULL, 
    m_gender VARCHAR2(20) NOT NULL, 
    m_nick VARCHAR2(20) NOT NULL, 
    m_height VARCHAR2(20) NOT NULL, 
    m_weight VARCHAR2(20) NOT NULL, 
    m_joindate DATE default sysdate not null, 
    PRIMARY KEY (m_id)

);


-- tbl_clothes Table Create SQL --
CREATE TABLE tbl_clothes
(
    m_id      VARCHAR2(20)    NOT NULL, 
    c_id      VARCHAR2(20)    , 
    rgb_id    VARCHAR2(20)    , 
    w_id      VARCHAR2(20)    , 
    a_id      VARCHAR2(20)    , 
    t_id      VARCHAR2(20)    , 
     PRIMARY KEY (c_id)

);

ALTER TABLE tbl_clothes
    ADD CONSTRAINT FK_tbl_clothes_m_id_tbl_member FOREIGN KEY (m_id)
        REFERENCES tbl_member (m_id)


-- tbl_codi Table Create SQL --
CREATE TABLE tbl_codi
(
    m_id      VARCHAR2(20)    NOT NULL, 
    c_date    DATE            default sysdate NOT NULL, 
    c_id      VARCHAR2(20)    NOT NULL
   
);

COMMENT ON TABLE tbl_codi IS '�� ��õ ����'
/

COMMENT ON COLUMN tbl_codi.m_id IS 'ȸ�� ���̵�'
/

COMMENT ON COLUMN tbl_codi.c_date IS '��õ����'
/

COMMENT ON COLUMN tbl_codi.c_id IS '�� ���̵�'
/


ALTER TABLE tbl_codi
    ADD CONSTRAINT FK_tbl_codi_m_id_tbl_member_m_ FOREIGN KEY (m_id)
        REFERENCES tbl_member (m_id)


ALTER TABLE tbl_codi
    ADD CONSTRAINT FK_tbl_codi_c_id_tbl_clothes_c FOREIGN KEY (c_id)
        REFERENCES tbl_clothes (c_id)
        
     
insert into tbl_MEMBERINFO values(1,1,1,1,1,1,1,sysdate)

select * from tbl_memberInfo;
select * from tbl_codi;
select * from tbl_clothes;

delete from tbl_memberInfo where m_id = 'ccc';

        
        