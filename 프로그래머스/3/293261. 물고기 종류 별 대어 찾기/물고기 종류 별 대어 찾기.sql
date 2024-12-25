-- 코드를 작성해주세요
WITH max_len AS (
  SELECT fish_type, MAX(length) AS length
    FROM fish_info
   GROUP BY fish_type
)
SELECT id, fish_name, length
  FROM fish_info i
 INNER JOIN fish_name_info n
 USING (fish_type)
 WHERE length = (SELECT length
                   FROM max_len
                  WHERE fish_type = i.fish_type)
 ORDER BY id;