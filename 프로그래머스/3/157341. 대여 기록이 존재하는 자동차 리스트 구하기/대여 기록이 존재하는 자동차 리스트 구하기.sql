-- 코드를 입력하세요
SELECT DISTINCT c.car_id
  FROM car_rental_company_rental_history h
 INNER JOIN car_rental_company_car c
 USING (car_id)
 WHERE car_type = '세단'
   AND MONTH(start_date) = 10
 ORDER BY car_id DESC;
 