-- 코드를 작성해주세요
SELECT a.id, COUNT(b.id) AS child_count
  FROM ecoli_data a
  LEFT JOIN ecoli_data b
    ON a.id = b.parent_id
 GROUP BY a.id
 ORDER BY a.id;