-- 코드를 작성해주세요
WITH grade_table AS (
  SELECT (CASE 
            WHEN skill_code & (SELECT code
                                 FROM skillcodes
                                WHERE name = 'Python') <> 0
             AND skill_code & (SELECT SUM(code)
                                FROM skillcodes
                               WHERE category = 'Front End') <> 0 THEN 'A'
            WHEN skill_code & (SELECT code
                                 FROM skillcodes
                                WHERE name = 'C#') <> 0 THEN 'B'
            WHEN skill_code & (SELECT SUM(code)
                                 FROM skillcodes
                                WHERE category = 'Front End') <> 0 THEN 'C'
         END) AS grade,
         id,
         email
    FROM developers
)
SELECT *
  FROM grade_table
 WHERE grade IS NOT NULL
 ORDER BY grade, id;