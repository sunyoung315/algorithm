-- 코드를 입력하세요
SELECT b.book_id, a.author_name, DATE_FORMAT(b.published_date, '%Y-%m-%d') AS published_date
  FROM book b
 INNER JOIN author a
 USING (author_id)
 WHERE category = '경제'
 ORDER BY published_date;