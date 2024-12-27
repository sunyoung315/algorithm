-- 코드를 작성해주세요
SELECT g.emp_no, 
       emp_name, 
       (CASE
          WHEN SUM(score) / 2 >= 96 THEN 'S'
          WHEN SUM(score) / 2 >= 90 THEN 'A'
          WHEN SUM(score) / 2 >= 80 THEN 'B'
          ELSE 'C'          
        END) AS grade,
       (CASE
          WHEN SUM(score) / 2 >= 96 THEN sal * 0.2
          WHEN SUM(score) / 2 >= 90 THEN sal * 0.15
          WHEN SUM(score) / 2 >= 80 THEN sal * 0.1
          ELSE 0
        END) AS bonus
  FROM hr_grade g
 INNER JOIN hr_employees e
 USING (emp_no)
 GROUP BY emp_no
 ORDER BY emp_no;