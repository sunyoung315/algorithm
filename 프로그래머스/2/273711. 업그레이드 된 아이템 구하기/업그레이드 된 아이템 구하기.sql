-- 코드를 작성해주세요
SELECT item_id, item_name, rarity
  FROM item_info i
 INNER JOIN item_tree t
 USING (item_id)
 WHERE parent_item_id IN (
         SELECT item_id
           FROM item_info 
          WHERE rarity = 'RARE'
       )
 ORDER BY item_id DESC;
    