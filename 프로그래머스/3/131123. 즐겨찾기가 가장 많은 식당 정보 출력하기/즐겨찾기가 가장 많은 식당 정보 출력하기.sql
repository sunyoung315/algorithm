-- 코드를 입력하세요
SELECT food_type, rest_id, rest_name, favorites
  FROM rest_info r
 WHERE favorites = (SELECT MAX(favorites)
                      FROM rest_info
                     GROUP BY food_type
                    HAVING food_type = r.food_type)
 ORDER BY food_type DESC;