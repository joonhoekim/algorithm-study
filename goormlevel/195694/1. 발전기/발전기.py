# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

'''
발전기의 최소 개수 구하기
- 상하좌우로 인접한 집 중 하나가 전력을 공급받으면 이어서 받을 수 있다
- 모든 집에 전력 공급을 위한 발전기의 최소 개수 구하기
- 풀어보니 sys.setrecursionlimit(10**6) 으로 콜스택제한 늘려도 못푸는 문제
'''

n = int(input())
town = []
for i in range(n):
	town.append(list(map(int, input().split())))

def dfs_iterative(start_x, start_y):
    stack = [(start_x, start_y)]
    while stack:
        x, y = stack.pop()
        if x < 0 or x >= n or y < 0 or y >= n or town[x][y] == 0:
            continue
        town[x][y] = 0
        stack.extend([(x+1, y), (x-1, y), (x, y+1), (x, y-1)])
    return True

answer = 0
for i in range(n):
    for j in range(n):
        if town[i][j] == 1:
            dfs_iterative(i, j)
            answer += 1
						
print(answer)
		
