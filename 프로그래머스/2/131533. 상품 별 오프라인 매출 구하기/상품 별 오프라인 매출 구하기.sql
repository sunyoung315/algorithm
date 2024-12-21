-- 코드를 입력하세요
SELECT product_code, SUM(sales_amount) * price AS sales
  FROM product p
 INNER JOIN offline_sale o
 USING (product_id)
 GROUP BY product_code
 ORDER BY sales DESC, product_code ASC;