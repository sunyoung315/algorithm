-- 코드를 입력하세요
WITH car_list AS (
  SELECT car_id
    FROM car_rental_company_rental_history
   WHERE MONTH(start_date) = 11
      OR MONTH(end_date) = 11
      OR (start_date < '2022-11-01' AND end_date > '2022-11-30')
)
SELECT DISTINCT car_id, c.car_type, ROUND(daily_fee * (100 - discount_rate) / 100 * 30) AS fee
  FROM car_rental_company_rental_history h
 INNER JOIN car_rental_company_car c
 USING (car_id)
 INNER JOIN car_rental_company_discount_plan p
    ON c.car_type = p.car_type
   AND duration_type = '30일 이상'
 WHERE car_id NOT IN (SELECT car_id FROM car_list)
   AND ROUND(daily_fee * (100 - discount_rate) / 100 * 30) >= 500000
   AND ROUND(daily_fee * (100 - discount_rate) / 100 * 30) < 2000000
 ORDER BY fee DESC, car_type ASC, car_id DESC;