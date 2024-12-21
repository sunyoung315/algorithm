-- 코드를 입력하세요
SELECT ingredient_type, SUM(total_order) AS total_order
  FROM first_half f
 INNER JOIN icecream_info i
 USING (flavor)
 GROUP BY ingredient_type
 ORDER BY total_order;