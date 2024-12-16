-- 코드를 작성해주세요
SELECT COUNT(*) AS COUNT
  FROM ecoli_data
 WHERE genotype & 2 = 0
   AND (genotype & 4 = 4 OR genotype & 1 = 1);