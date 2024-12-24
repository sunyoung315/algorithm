-- 코드를 작성해주세요
SELECT a.id, a.genotype, b.genotype AS parent_genotype
  FROM ecoli_data a
 INNER JOIN ecoli_data b
    ON a.parent_id = b.id
 WHERE a.genotype & b.genotype = b.genotype
 ORDER BY id;