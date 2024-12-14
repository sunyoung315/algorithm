-- 코드를 입력하세요
SELECT factory_id, factory_name, address
  FROM food_factory
 WHERE SUBSTR(address, 1, 3) = '강원도'
 ORDER BY factory_id;