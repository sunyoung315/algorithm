-- 코드를 작성해주세요
SELECT dept_id, dept_name_en, ROUND(AVG(sal)) AS avg_sal
  FROM hr_employees
 INNER JOIN hr_department
 USING (dept_id)
 GROUP BY dept_id
 ORDER BY avg_sal DESC;