-- 코드를 입력하세요
SELECT history_id, 
       ROUND(daily_fee * (DATEDIFF(end_date, start_date) + 1) * (
         CASE
           WHEN (DATEDIFF(end_date, start_date) + 1) >= 90
           THEN (100 - (SELECT discount_rate
                   FROM car_rental_company_discount_plan
                  WHERE car_type = '트럭'
                    AND duration_type = '90일 이상')) / 100
           WHEN (DATEDIFF(end_date, start_date) + 1) >= 30
           THEN (100 - (SELECT discount_rate
                   FROM car_rental_company_discount_plan
                  WHERE car_type = '트럭'
                    AND duration_type = '30일 이상')) / 100
           WHEN (DATEDIFF(end_date, start_date) + 1) >= 7
           THEN (100 - (SELECT discount_rate
                   FROM car_rental_company_discount_plan
                  WHERE car_type = '트럭'
                    AND duration_type = '7일 이상')) / 100
           ELSE 1
         END
       )) AS fee
  FROM car_rental_company_rental_history h, car_rental_company_car c
 WHERE h.car_id = c.car_id
   AND car_type = '트럭'
 ORDER BY fee DESC, history_id DESC;