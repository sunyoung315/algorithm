-- 코드를 입력하세요
SELECT animal_type, count(animal_type) AS count
  FROM animal_ins
 GROUP BY animal_type
HAVING animal_type IN ('Dog', 'Cat')
 ORDER BY animal_type;