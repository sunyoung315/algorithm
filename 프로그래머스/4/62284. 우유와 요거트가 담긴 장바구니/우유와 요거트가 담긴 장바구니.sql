-- 코드를 입력하세요
WITH my_cart AS (
  SELECT DISTINCT cart_id, name
    FROM cart_products
   WHERE name = 'Milk'
      OR name = 'Yogurt'
)
SELECT cart_id
  FROM my_cart
 GROUP BY cart_id
HAVING COUNT(cart_id) >= 2
 ORDER BY cart_id;