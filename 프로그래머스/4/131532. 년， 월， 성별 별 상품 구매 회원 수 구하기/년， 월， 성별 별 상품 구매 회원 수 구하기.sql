-- 코드를 입력하세요
SELECT YEAR(sales_date) AS year, MONTH(sales_date) AS month, gender, COUNT(DISTINCT user_id) AS users
  FROM online_sale
 INNER JOIN user_info
 USING (user_id)
 WHERE gender IS NOT NULL
 GROUP BY year, month, gender
 ORDER BY year, month, gender;