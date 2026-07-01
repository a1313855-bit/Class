SELECT * FROM w3schools.customers;

#查詢
select * from w3schools.customers where Country='Mexico';

#查詢 (not)
select * from w3schools.customers where not Country='Mexico';

#查詢 (or)
select * from w3schools.customers where Country='Mexico' or Country='France';

#查詢 (or)(not)
select * from w3schools.customers where not(Country='Mexico' or Country='France');

#查詢 (in)
select * from w3schools.customers where Country in('Canada','USA');

#查詢 (in)(not)
select * from w3schools.customers where Country not in('Canada','USA','France');

#查詢 (is null)
select * from w3schools.customers where CustomerName is null;

#查詢 (is null)(not)
select * from w3schools.customers where CustomerName is not null;

#查詢 (like %) 字首
select * from w3schools.customers where CustomerName like 'a%';

#查詢 (like %) (not) 字首(不要)
select * from w3schools.customers where CustomerName not like 'a%';

#查詢 (like %n%) 中間有
select * from w3schools.customers where CustomerName like '%a%';

#查詢 (like %n%) (not) 中間有(不要)
select * from w3schools.customers where CustomerName not like '%a%';

#查詢 (like %n) 最後
select * from w3schools.customers where CustomerName like '%a';

#查詢 (like %n) (not) 最後(不要)
select * from w3schools.customers where CustomerName not like '%a';

#查詢 (like _n%) 第n個字 _ *一個底線=一個字
select * from w3schools.customers where CustomerName like '__a%';

#查詢 (like _n%) 第n個字 _(不要) *一個底線=一個字
select * from w3schools.customers where CustomerName not like '__a%';

#查詢 修改名稱(但來源不會變)
select CustomerID as 客戶編號 , Address as 地址 from w3schools.customers;