-- 코드를 작성해주세요
WITH fe AS (
  SELECT code
    FROM skillcodes
   WHERE category = 'Front End'
)
SELECT DISTINCT id, email, first_name, last_name
  FROM developers, fe
 WHERE skill_code & code = code
 ORDER BY id;