-- 코드를 입력하세요
SELECT i.animal_id, i.animal_type, i.name
  FROM animal_ins i
 INNER JOIN animal_outs o
 USING (animal_id)
 WHERE i.sex_upon_intake LIKE '%Intact%'
   AND (o.sex_upon_outcome LIKE '%Spayed%'
    OR o.sex_upon_outcome LIKE '%Neutered%')
 ORDER BY animal_id;