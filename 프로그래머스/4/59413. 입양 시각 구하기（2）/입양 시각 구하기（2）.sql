-- 코드를 입력하세요
WITH RECURSIVE hour_tb AS (
    SELECT 0 AS hour
     UNION ALL
    SELECT hour + 1
      FROM hour_tb
     WHERE hour < 23
)
SELECT hour, COUNT(animal_id) AS count
  FROM animal_outs o
 RIGHT JOIN hour_tb h
    ON HOUR(datetime) = hour
 GROUP BY hour
 ORDER BY hour

