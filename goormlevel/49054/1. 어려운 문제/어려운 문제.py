# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

'''
개요
- 팩토리얼 연산의 결과값을 가지고 해싱(?)하듯 만드는데,
- 최대 (10**4)! 를 계산해야 하는 걸로 보아 진짜 팩토리얼을 구한 다음에, 자릿수 다 더해서 B 만들고 동일하게 작업하라는건지 모르겠음
- 일단 구현 해보고 틀리는 걸 봐야겠음.
입력

동작

구현

'''
import math

N = int(input())
A = math.factorial(N)
while A>10:
	B = sum(map(int, list(str(A))))
	A = B
print(A)
