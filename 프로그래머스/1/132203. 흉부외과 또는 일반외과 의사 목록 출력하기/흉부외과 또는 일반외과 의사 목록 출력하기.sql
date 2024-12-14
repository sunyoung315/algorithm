-- 코드를 입력하세요
SELECT dr_name, dr_id, mcdp_cd, LEFT(hire_ymd, 10) AS hire_ymd
  FROM doctor
 WHERE mcdp_cd IN ('CS', 'GS')
 ORDER BY hire_ymd DESC, dr_name ASC;