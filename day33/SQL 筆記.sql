SELECT * FROM company3.porder;

select #要找的欄位
porder.order_no, 
employee.name,
customer.name,
product.name,
porder.amount,
porder.amount*product.price
from #資料存在的欄位
company3.porder
#inner join 和現在這張表比對相同的才會留下 on 這兩張表相同的部分(接線)
inner join company3.employee on company3.porder.employee_no=company3.employee.employee_no
inner join company3.customer on company3.porder.customer_no=company3.customer.customer_no
inner join company3.product on company3.porder.product_no=company3.product.product_no;




