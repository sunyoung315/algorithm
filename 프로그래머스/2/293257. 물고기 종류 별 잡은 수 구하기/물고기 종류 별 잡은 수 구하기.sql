-- 코드를 작성해주세요
SELECT COUNT(fish_type) AS fish_count, fish_name
  FROM fish_info
 INNER JOIN fish_name_info
 USING (fish_type)
 GROUP BY fish_name
 ORDER BY fish_count DESC;