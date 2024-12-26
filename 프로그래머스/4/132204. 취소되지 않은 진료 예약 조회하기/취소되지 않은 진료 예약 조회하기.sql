-- 코드를 입력하세요
SELECT apnt_no, pt_name, pt_no, a.mcdp_cd, dr_name, apnt_ymd
  FROM appointment a
 INNER JOIN patient p
 USING (pt_no)
 INNER JOIN doctor d
    ON a.mddr_id = d.dr_id
 WHERE DATE_FORMAT(apnt_ymd, '%Y-%m-%d') = '2022-04-13'
   AND apnt_cncl_yn = 'N'
   AND a.mcdp_cd = 'CS'
 ORDER BY apnt_ymd;