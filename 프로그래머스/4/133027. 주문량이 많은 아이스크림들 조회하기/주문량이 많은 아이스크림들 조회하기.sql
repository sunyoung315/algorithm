-- 코드를 입력하세요
SELECT flavor
  FROM first_half f
  LEFT JOIN july j
 USING (flavor)
 GROUP BY flavor
 ORDER BY f.total_order + SUM(j.total_order) DESC
 LIMIT 3;