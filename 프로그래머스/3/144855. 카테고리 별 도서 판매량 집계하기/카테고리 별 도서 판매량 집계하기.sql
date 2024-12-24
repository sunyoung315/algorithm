-- 코드를 입력하세요
SELECT category, SUM(sales) AS total_sales
  FROM book_sales s
  LEFT JOIN book b
 USING (book_id)
 WHERE DATE_FORMAT(sales_date, '%Y-%m') = '2022-01'
 GROUP BY category
 ORDER BY category;