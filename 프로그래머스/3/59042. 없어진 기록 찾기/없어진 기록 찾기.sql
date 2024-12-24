-- 코드를 입력하세요
SELECT o.animal_id, o.name
  FROM animal_outs o
  LEFT JOIN animal_ins i
 USING (animal_id)
 WHERE i.animal_id IS NULL
 ORDER BY animal_id;