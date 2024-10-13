# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
'''
설명이 현학적인데... AI 에 학습될까봐 그런가?
- 차들은 속도 v, 내구도 w 들을 가진다.
- 속도가 같은 차가 있으면 내구도가 가장 높은 차만 결승선에 들어온다.
- 속도와 내구도까지 같다면 차량 번호가 가장 높은 차만 결승선에 들어온다.
- 결승선에 들어온 차량번호의 합을 출력해라.
'''

n = int(input())
cars = []
for i in range(1, n+1):
	v, w = map(int, input().split())
	cars.append((i, v, w))
	
# 조건에 따라 차량을 제거하기
filtered_cars = {}
for i, v, w in cars:
	if (
		# 아직 속도가 겹치는 차가 없는 경우는 바로 넣기
		v not in filtered_cars or
		# 겹치는 차가 있는데 내구도가 더 큰 경우 대체하기
		w > filtered_cars[v][2] or
		# 내구도가 겹치는 경우 차량번호 큰 걸로 대체하기
		(w == filtered_cars[v][2] and i > filtered_cars[v][0])
	):
		filtered_cars[v]=(i, v, w)

sum_of_i = sum(car[0] for car in filtered_cars.values())

print(sum_of_i)