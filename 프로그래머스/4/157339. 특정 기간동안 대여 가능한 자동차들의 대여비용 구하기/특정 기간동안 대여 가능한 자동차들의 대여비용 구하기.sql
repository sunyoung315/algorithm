-- 코드를 입력하세요
SELECT c.CAR_ID, c.CAR_TYPE, ROUND(DAILY_FEE * (SELECT (1 - DISCOUNT_RATE / 100) FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN dp WHERE dp.CAR_TYPE = c.CAR_TYPE AND DURATION_TYPE = '30일 이상') * 30) AS FEE
FROM CAR_RENTAL_COMPANY_CAR c LEFT JOIN (SELECT CAR_ID, HISTORY_ID 
                                                 FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                                                 WHERE START_DATE <= '2022-11-01' AND END_DATE >= '2022-11-30'
                                            OR DATE_FORMAT(START_DATE, '%Y-%m') = '2022-11'
                                            OR DATE_FORMAT(END_DATE, '%Y-%m') = '2022-11') h
ON h.CAR_ID = c.CAR_ID
WHERE CAR_TYPE IN ('세단', 'SUV') 
    AND HISTORY_ID IS NULL
    AND ROUND(DAILY_FEE * (SELECT (1 - DISCOUNT_RATE / 100) FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN dp WHERE dp.CAR_TYPE = c.CAR_TYPE AND DURATION_TYPE = '30일 이상') * 30) BETWEEN 500000 AND 1999999
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC

# SELECT c.CAR_ID, c.CAR_TYPE, DAILY_FEE, HISTORY_ID
# FROM CAR_RENTAL_COMPANY_CAR c LEFT JOIN (SELECT CAR_ID, HISTORY_ID
#                                          FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#                                          WHERE START_DATE <= '2022-11-01' AND END_DATE >= '2022-11-30'
#                                             OR DATE_FORMAT(START_DATE, '%Y-%m') = '2022-11'
#                                             OR DATE_FORMAT(END_DATE, '%Y-%m') = '2022-11') h
# ON h.CAR_ID = c.CAR_ID
# WHERE CAR_TYPE IN ('세단', 'SUV') 
# AND HISTORY_ID IS NULL
