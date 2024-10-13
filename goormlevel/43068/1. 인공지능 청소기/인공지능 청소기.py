# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

T = int(input())

for _ in range(T):
	X, Y, N = map(int, input().split())
	m_dist = abs(X) + abs(Y)
	answer = False
	if N < m_dist:
		answer = False
		
	elif m_dist % 2 == 0 and N % 2 == 0:
		answer = True
	elif m_dist % 2 == 1 and N % 2 == 1:
		answer = True
		
	if answer:
		print('YES')
	else:
		print('NO')
		
	# 재방문 가능하므로 결정적으로 풀기
	# m_dist 가 1인 경우
	# N=1 O, N=2 X, N=3 OK, N=4 X, N=5 OK... = 홀수 거리만 가능
	# m_dist 가 2인 경우
	# N=1 X, N=2 O, N=3 X... = 짝수 거리만 가능