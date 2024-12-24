-- 코드를 입력하세요
SELECT user_id, 
       nickname, 
       CONCAT(city, ' ', street_address1, ' ', street_address2) AS '전체주소',
       CONCAT(LEFT(tlno, 3), '-', SUBSTR(tlno, 4, 4), '-', RIGHT(tlno, 4)) AS '전화번호'
  FROM used_goods_board b
 INNER JOIN used_goods_user u
    ON b.writer_id = u.user_id
 GROUP BY writer_id
HAVING COUNT(board_id) >= 3
 ORDER BY user_id DESC;