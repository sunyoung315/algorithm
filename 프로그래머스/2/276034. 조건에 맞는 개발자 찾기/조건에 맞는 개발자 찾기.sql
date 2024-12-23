-- 코드를 작성해주세요
SELECT id, email, first_name, last_name
  FROM developers
 WHERE skill_code & (
         SELECT code
           FROM skillcodes
          WHERE name = 'Python'
       ) = (
         SELECT code
           FROM skillcodes
          WHERE name = 'Python'
       )
    OR skill_code & (
         SELECT code
           FROM skillcodes
          WHERE name = 'C#'
       ) = (
         SELECT code
           FROM skillcodes
          WHERE name = 'C#'
       )
 ORDER BY id;