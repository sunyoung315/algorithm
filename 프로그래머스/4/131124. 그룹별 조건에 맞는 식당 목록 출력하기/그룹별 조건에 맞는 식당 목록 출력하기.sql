-- 코드를 입력하세요
WITH best_member AS (
  SELECT member_id
    FROM rest_review
   GROUP BY member_id
   ORDER BY COUNT(member_id) DESC
   LIMIT 1
)
SELECT member_name, review_text, DATE_FORMAT(review_date, '%Y-%m-%d') AS review_date
  FROM rest_review r
 INNER JOIN member_profile m
 USING (member_id)
 WHERE r.member_id = (SELECT member_id
                        FROM best_member)
 ORDER BY review_date, review_text;