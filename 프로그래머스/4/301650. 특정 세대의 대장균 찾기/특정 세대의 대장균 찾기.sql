-- 코드를 작성해주세요
WITH RECURSIVE gen_info AS (
  SELECT id, parent_id, 1 AS gen
    FROM ecoli_data
   WHERE parent_id IS NULL
    
   UNION ALL
  
  SELECT e.id, e.parent_id, gen + 1 AS gen
    FROM ecoli_data e
   INNER JOIN gen_info g
      ON e.parent_id = g.id
)
SELECT id
  FROM gen_info
 WHERE gen = 3
 ORDER BY id;