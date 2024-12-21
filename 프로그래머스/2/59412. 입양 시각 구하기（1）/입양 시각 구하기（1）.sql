-- 코드를 입력하세요
SELECT HOUR(datetime) AS hour,
       COUNT(animal_id) AS count
  FROM animal_outs
 WHERE HOUR(datetime) BETWEEN 09 AND 20
 GROUP BY HOUR(datetime)
 ORDER BY hour;