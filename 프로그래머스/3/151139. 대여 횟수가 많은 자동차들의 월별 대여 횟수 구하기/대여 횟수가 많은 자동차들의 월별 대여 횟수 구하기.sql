-- 코드를 입력하세요
WITH total_cnt AS (
    SELECT MONTH(start_date) AS month, car_id, COUNT(history_id) AS records
      FROM car_rental_company_rental_history
     WHERE start_date >= '2022-08-01'
       AND start_Date <= '2022-10-31'
     GROUP BY car_id, month
)

SELECT *
  FROM total_cnt t
 WHERE (SELECT SUM(records)
          FROM total_cnt
         GROUP BY car_id
        HAVING car_id = t.car_id) >= 5
 ORDER BY month, car_id DESC;