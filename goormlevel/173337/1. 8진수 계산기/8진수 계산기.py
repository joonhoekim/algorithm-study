# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

def conver_to_base_n(decimal, base):
	digits = []
	
	while decimal > 0:
		digits.append(decimal % base)
		decimal //= base
	
	digits.reverse()
	return ''.join(map(str, digits))

input()
target = sum(map(int, input().split()))

base = 8
print(conver_to_base_n(target, base))

