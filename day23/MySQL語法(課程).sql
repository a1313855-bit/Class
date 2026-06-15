SELECT * FROM company.porder;

#=單行註解
/*多行註解*/

#查詢
select name,sum from company.porder;

#修改
update company.porder set name="abc",ruler="3",sum=250 where id=2;

#刪除
delete from company.porder where id=6;