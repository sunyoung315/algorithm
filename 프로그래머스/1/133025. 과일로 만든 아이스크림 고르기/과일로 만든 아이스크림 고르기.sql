-- 코드를 입력하세요
SELECT f.flavor
  FROM first_half AS f
  LEFT JOIN icecream_info as i
    ON f.flavor = i.flavor
 WHERE total_order > 3000
   AND ingredient_type = 'fruit_based'
 ORDER BY total_order DESC;