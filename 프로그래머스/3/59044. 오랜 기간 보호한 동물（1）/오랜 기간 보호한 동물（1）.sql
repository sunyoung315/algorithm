-- 코드를 입력하세요
SELECT i.name, i.datetime
  FROM animal_ins i
  LEFT JOIN animal_outs o
 USING (animal_id)
 WHERE o.datetime IS NULL
 ORDER BY i.datetime
 LIMIT 3;