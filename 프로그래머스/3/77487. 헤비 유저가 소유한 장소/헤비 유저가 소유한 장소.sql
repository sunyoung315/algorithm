-- 코드를 입력하세요
WITH heavy_user AS (
  SELECT host_id
    FROM places
   GROUP BY host_id
  HAVING COUNT(id) >= 2
)
SELECT id, name, p.host_id
  FROM places p
 INNER JOIN heavy_user h
 USING (host_id)
 ORDER BY id;