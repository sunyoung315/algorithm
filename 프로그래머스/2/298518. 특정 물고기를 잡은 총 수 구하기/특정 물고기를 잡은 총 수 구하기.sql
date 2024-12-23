-- 코드를 작성해주세요
SELECT COUNT(id) AS fish_count
  FROM fish_info
 INNER JOIN fish_name_info
 USING (fish_type)
 WHERE fish_name IN ('BASS', 'SNAPPER');