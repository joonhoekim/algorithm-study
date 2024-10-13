# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

'''
8
1 2 3 4 -1 -2 -3 -5

스택에 남는 케이스를 구하기
'''
import sys
from collections import defaultdict

input = sys.stdin.readline
N = int(input())

pool = defaultdict(int)
array = list(map(int, input().split()))

for el in array:
	if el > 0:
		pool[el] += 1
	elif el < 0:
		pool[-el] -= 1

total = 0
for k, v in pool.items():
	total += k*v
print(total)