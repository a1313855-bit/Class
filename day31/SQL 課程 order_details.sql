SELECT * FROM w3schools.order_details;

#查詢區間
select * from w3schools.order_details where Quantity>=30 and Quantity<=40;

#查詢區間(between)customers
select * from w3schools.order_details where Quantity between 30 and 45;

#查詢排序 order by 預設:小->大
select * from w3schools.order_details order by Quantity;

#查詢排序 order by (desc)大->小
select * from w3schools.order_details order by Quantity desc;

#查詢 修改名稱(但來源不會變) 應用
select * , Quantity*0.9 as 9折 from w3schools.order_details;