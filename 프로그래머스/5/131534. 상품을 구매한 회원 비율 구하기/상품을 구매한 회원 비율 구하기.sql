-- 코드를 입력하세요
WITH join_cnt AS (
  SELECT COUNT(user_id) AS cnt
    FROM user_info
   WHERE YEAR(joined) = 2021
)
SELECT YEAR(sales_date) AS year, 
       MONTH(sales_date) AS month,
       COUNT(DISTINCT user_id) AS purchased_users,
       ROUND(COUNT(DISTINCT user_id) / (SELECT cnt FROM join_cnt), 1) AS puchased_ratio
  FROM online_sale
 INNER JOIN user_info
 USING (user_id)
 WHERE YEAR(joined) = 2021
 GROUP BY year, month
       