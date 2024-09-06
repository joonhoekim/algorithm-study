-- dynamic
WITH searched_code AS (
SELECT CODE
    FROM SKILLCODES
    WHERE NAME IN ('Python', 'C#')
)
SELECT
    d.ID, d.EMAIL, d.FIRST_NAME, d.LAST_NAME
FROM DEVELOPERS d
WHERE EXISTS (
    SELECT 1
    FROM searched_code
    WHERE (d.SKILL_CODE & CODE) > 0
)
ORDER BY d.ID ASC;