-- 코드를 입력하세요
SELECT i.animal_id, i.name
  FROM animal_ins i
  LEFT JOIN animal_outs o
 USING (animal_id)
 WHERE o.datetime IS NOT NULL
   AND TIMEDIFF(o.datetime, i.datetime) <= 0
 ORDER BY i.datetime;