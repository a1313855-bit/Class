SELECT p.productline, COUNT(*) 
FROM classicmodels.products as p
GROUP BY p.productline