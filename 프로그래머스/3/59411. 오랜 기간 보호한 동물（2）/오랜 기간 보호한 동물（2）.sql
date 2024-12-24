-- 코드를 입력하세요
SELECT i.animal_id, i.name
  FROM animal_ins i
 INNER JOIN animal_outs o
 USING (animal_id)
 ORDER BY DATEDIFF(o.datetime, i.datetime) DESC
 LIMIT 2;