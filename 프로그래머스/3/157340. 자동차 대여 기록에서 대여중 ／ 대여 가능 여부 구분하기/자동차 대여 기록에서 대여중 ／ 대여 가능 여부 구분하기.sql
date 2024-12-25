-- 코드를 입력하세요
WITH avail_info AS (
  SELECT car_id
    FROM car_rental_company_rental_history
   WHERE start_date <= '2022-10-16'
     AND end_date >= '2022-10-16'
)
SELECT DISTINCT car_id,
       (CASE 
          WHEN car_id = (SELECT car_id 
                           FROM avail_info
                          WHERE car_id = c.car_id)
          THEN '대여중'
          ELSE '대여 가능'
        END) AS availability
  FROM car_rental_company_rental_history c
 ORDER BY car_id DESC;
        