-- 코드를 작성해주세요
SELECT item_id, item_name
  FROM item_info
 INNER JOIN item_tree
 USING (item_id)
 WHERE parent_item_id IS NULL
 ORDER BY item_id;