SELECT * FROM company2.porder;

#查詢名稱
select * from company2.porder where name='Mr.A';

#查詢金額區間
select * from company2.porder where sum>=500 and sum<=1000;