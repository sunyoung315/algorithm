-- 코드를 입력하세요
SELECT LEFT(product_code, 2) AS category, COUNT(*) AS products
  FROM product
 GROUP BY LEFT(product_code, 2)
 ORDER BY category;