-- 코드를 작성해주세요
SELECT id, 
       (CASE 
          WHEN NTILE(4) OVER(ORDER BY size_of_colony DESC) = 1 THEN 'CRITICAL'
          WHEN NTILE(4) OVER(ORDER BY size_of_colony DESC) = 2 THEN 'HIGH'
          WHEN NTILE(4) OVER(ORDER BY size_of_colony DESC) = 3 THEN 'MEDIUM'
          ELSE 'LOW'
        END) AS colony_name
  FROM ecoli_data
 ORDER BY id;