SELECT COUNT(DISTINCT NAME)
FROM ANIMAL_INS
WHERE NAME IS NOT NULL

// 중복 제거하기

// DISTINCT 사용 시 주의할 점]

// DISTINCT 키워드는 옆에 온 모든 컬럼을 고려하여 중복 제거를 진행합니다.

// 즉, SELECT DISTINCT COL1, COL2 …를 진행할 경우

// COL1과 COL2 값이 모두 동일한 row들을 1개로 칩니다.
// 다시 말하면, DISTINCT 는 SELECT 구문에 여러 컬럼명이 올 때, 그 중 한 개에 대해서만 적용할 수 없다는 말이 됩니다.

// SELECT (DISTINCT COL1), COL2 FROM …는 오류입니다.

// COL1 의 중복된 데이터를 제거한 뒤 COL2를 가져와야 할 텐데, 이 중 어떤 COL2 값을 가져와야 하는지 알 수 없기 때문입니다.


// COUNT 는 SQL 문법에 존재하는 집계함수입니다.
// 함수 내에 들어간 컬럼에 존재하는 데이터의 갯수를 출력합니다.