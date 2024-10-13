# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

'''
땅 높이
- i 번째 집은 k_i 라는 높이를 가진다.
- 땅 높이는 음수가 될 수 있다.

장마는 M 일 동안 오고
i 일이 되는 날에는 s_i to e_i 까지 비가 내린다
비는 내린 집의 '물높이'를 1 증가시킨다.
배수시스템으로 제거되지 못한 물은 최종적으로 '땅 높이'에 합해진다. = 땅이 높아진다.

배수시스템
- 장마가 시작된 지 3의 배수가 되는 날마다
- 비가 내리고 난 뒤 작동
- 작동날짜 기준2일이내 비가 내린 위치에서만 작동 
- 배수 시스템은 집집마다 있음
- 비가 내렸던 기록 기준으로 3일마다 동작함. (규칙에 따라 단발적으로 여러번 동작함)
- 장마 시작 후 3일, 6일, 9일, 12일 ... 3의 배수마다 동작할 수 있고,
- 동작하려면 1,2,3 에 비 내린 적 있어야 동작, 4,5,6 에 비 내린적 있어야 동작하는 식이다.
- 동작하면 '물높이' 1을 낮춘다.
'''

# 집 개수 N, 장마 일수 M
N, M = map(int, input().split())
# 땅 높이 k_i
k = list(map(int, input().split()))
# 장마 정보
flood = {}
# 물 높이
water = [0] * N

# 장마 정보 입력
for i in range(1, M+1):  # 1일차부터 시작
    start, end = map(int, input().split())
    flood[i] = (start-1, end-1)

# 비 내림 및 배수 시스템 작동
for day in range(1, M+1):  # 1일차부터 시작
    # 비 내림
    if day in flood:
        start, end = flood[day]
        for i in range(start, end+1):
            water[i] += 1
    
    # 배수 시스템
    if day % 3 == 0:
        for i in range(N):
            affected = False
            for d in range(day-2, day+1):  # 최근 2일 내 비가 내린 위치 확인
                if d in flood:
                    start, end = flood[d]
                    if start <= i <= end:
                        affected = True
                        break
            if affected:
                water[i] = max(0, water[i] - 1)

# 최종 결과 계산
result = [k[i] + water[i] for i in range(N)]
print(' '.join(map(str, result)))