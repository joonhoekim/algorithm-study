SELECT CAST(ROUND(AVG(LENGTH), 2) AS DECIMAL(10,2)) AS AVERAGE_LENGTH
FROM (SELECT IFNULL(LENGTH, 10) AS LENGTH
FROM FISH_INFO) AS temp
;