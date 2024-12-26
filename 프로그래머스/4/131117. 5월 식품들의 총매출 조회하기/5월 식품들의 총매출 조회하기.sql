-- 코드를 입력하세요
SELECT o.product_id, product_name, SUM(price * amount) AS total_sales
  FROM food_order o
 INNER JOIN food_product p
 USING (product_id)
 WHERE DATE_FORMAT(produce_date, '%Y-%m') = '2022-05'
 GROUP BY product_id
 ORDER BY total_sales DESC, product_id ASC;