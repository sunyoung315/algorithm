-- 코드를 작성해주세요
SELECT i.item_id, i.item_name, i.rarity
  FROM item_info i
  LEFT JOIN item_tree t
    ON i.item_id = t.parent_item_id
 WHERE t.item_id IS NULL
 ORDER BY i.item_id DESC;