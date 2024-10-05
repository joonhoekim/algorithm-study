# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

N = int(input())
S = input()

arr = list(S)
def toggle_case(ch):
	if ord('a') <= ord(ch) <= ord('z'):
		return chr(ord(ch)-ord('a')+ord('A'))
	elif ord('A') <= ord(ch) <= ord('Z'):
		return chr(ord(ch)-ord('A')+ord('a'))
	
for i, ch in enumerate(arr):
	arr[i] = toggle_case(arr[i])

print(''.join(arr))