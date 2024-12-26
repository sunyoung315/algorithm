-- 코드를 입력하세요
SELECT author_id, author_name, category, SUM(sales * price) AS total_sales
  FROM book b
 INNER JOIN author a
 USING (author_id)
 RIGHT JOIN book_sales s
 USING (book_id)
 WHERE DATE_FORMAT(sales_date, '%Y-%m') = '2022-01'
 GROUP BY author_id, category
 ORDER BY author_id, category DESC;