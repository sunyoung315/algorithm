-- 코드를 작성해주세요
WITH RECURSIVE gen_data AS (
  SELECT id, parent_id, 1 AS generation
    FROM ecoli_data
   WHERE parent_id IS NULL
   
   UNION ALL
  
  SELECT e.id, e.parent_id, generation + 1 AS generation
    FROM ecoli_data e
   INNER JOIN gen_data g
      ON e.parent_id = g.id
)
SELECT COUNT(id) AS count, generation
  FROM gen_data
 WHERE id NOT IN (SELECT DISTINCT parent_id 
                    FROM ecoli_data 
                   WHERE parent_id IS NOT NULL)
 GROUP BY generation
 ORDER BY generation;