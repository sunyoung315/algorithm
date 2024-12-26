-- 코드를 입력하세요
WITH max_price AS (
  SELECT category, MAX(price) AS max_price
    FROM food_product
   GROUP BY category
  HAVING category IN ('과자', '국', '김치', '식용유')
)

SELECT f.category, f.price AS max_price, f.product_name
  FROM food_product f, max_price p
 WHERE f.category = p.category
   AND f.price = p.max_price
 ORDER BY max_price DESC;