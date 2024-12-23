-- 코드를 작성해주세요
SELECT SUM(score) AS score, emp_no, emp_name, position, email
  FROM hr_employees
 INNER JOIN hr_grade
 USING (emp_no)
 GROUP BY emp_no, year
HAVING year = 2022
   AND score = (
         SELECT SUM(score) AS score
           FROM hr_grade
          GROUP BY emp_no, year
         HAVING year = 2022
          ORDER BY score DESC
          LIMIT 1
       );