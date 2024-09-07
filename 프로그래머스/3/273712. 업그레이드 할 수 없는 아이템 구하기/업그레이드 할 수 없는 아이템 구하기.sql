SELECT t1.item_id,  t1.item_name, t1.rarity
FROM item_info t1
WHERE NOT EXISTS (
    SELECT 1
    FROM item_tree t2
    WHERE t2.parent_item_id = t1.item_id
)
ORDER BY item_id DESC
;