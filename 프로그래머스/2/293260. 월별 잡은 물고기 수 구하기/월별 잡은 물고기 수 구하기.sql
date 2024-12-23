-- 코드를 작성해주세요
SELECT COUNT(id) AS fish_count, MONTH(time) AS month
  FROM fish_info
 GROUP BY month
 ORDER BY month;