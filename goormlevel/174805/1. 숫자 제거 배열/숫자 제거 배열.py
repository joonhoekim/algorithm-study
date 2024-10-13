# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

N, K = map(str, input().split())
arr = list(map(str, input().split()))

answer = 0
for el in arr:
	if K not in el:
		answer += 1
		
print(answer)