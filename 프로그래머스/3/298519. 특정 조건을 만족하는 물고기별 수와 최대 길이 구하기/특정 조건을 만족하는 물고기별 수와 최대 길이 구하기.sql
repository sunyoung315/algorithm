-- 코드를 작성해주세요
SELECT COUNT(id) AS fish_count, MAX(LENGTH) AS max_length, fish_type
  FROM fish_info
 GROUP BY fish_type
HAVING SUM(IFNULL(length, 10)) / COUNT(id) >= 33
 ORDER BY fish_type;