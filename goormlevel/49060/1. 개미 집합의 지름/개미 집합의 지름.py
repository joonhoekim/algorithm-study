# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

'''
개입동구
개요
- 수직선
- 개미집합의 지름이란?
	- 개미 집합에 들어있는 임의의 두 개미 사이의 거리 중 가장 긴 거리
	- 즉 가장 왼쪽 개미와 가장 오른쪽 개미 사이의 거리이다. 계산은 위치 차이의 절대값으로 구하면 된다.
- 개미 집합의 지름을 D 이하로 만들어야 한다.
- 최소한의 개미를 제거해서 조건을 만족시키려고 할 때, 제거해야 하는 개미 수는?

>> ...      ...............
이런 상황이 있다고 가정하면, 왼쪽 3개를 제거하는 게 좋은 선택일 것이다.

>> ......     ....                     .......
이런 상황에서는 왼쪽이나 오른쪽을 다 제거하는 게 좋은 선택일 것이다.
즉 시뮬레이션으로 풀 수 없는 문제다. DP 로 풀어야 할 것이다.

입출력
- N = 개미 마릿수
- D = 목표 개미집합 지름
- P_i = 개미 좌표 리스트
동작
- 최댓값과 최솟값이 중요하므로, 개미 좌표 리스트를 정렬한다.

구현
'''


from collections import Counter

def solve_ant_colony(N, D, points):
    # 각 위치의 개미 수를 세고, 위치를 정렬
    ant_counts = Counter(points)
    unique_points = sorted(ant_counts.keys())
    M = len(unique_points)
    
    # dp[i]: i번째 unique_point를 오른쪽 끝으로 하는 구간에서 제거해야 할 최소 개미 수
    dp = [float('inf')] * M
    
    # 왼쪽 포인터
    left = 0
    total_ants = 0
    
    for right in range(M):
        total_ants += ant_counts[unique_points[right]]
        
        while unique_points[right] - unique_points[left] > D:
            total_ants -= ant_counts[unique_points[left]]
            left += 1
        
        # 현재 구간의 모든 개미를 유지하는 경우
        dp[right] = total_ants
        
        # 이전 구간의 결과를 이용하는 경우
        if left > 0:
            dp[right] = min(dp[right], dp[left-1] + total_ants)
    
    return N - max(dp)

# 입력 받기
N, D = map(int, input().split())
points = list(map(int, input().split()))

# 결과 출력
removed_ants = solve_ant_colony(N, D, points)
print(removed_ants)