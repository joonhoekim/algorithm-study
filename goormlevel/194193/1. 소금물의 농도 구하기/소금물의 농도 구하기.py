# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

import math

def math_floor(x, n):
	multiplier = 10**n
	return math.floor(x*multiplier) / multiplier	

N, M = map(int, input().split())

DENSITY = 7

salt = DENSITY * N / 100
water = N - salt

answer = math_floor(salt / (N+M) * 100, 2)
print(f'{answer:.2f}')