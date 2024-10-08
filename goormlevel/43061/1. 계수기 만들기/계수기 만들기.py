# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

'''
계수기 만들기

개요
- 일반 십진법과 다르게, 각 자리마다 최댓값이 다른, 이상한 계수기를 만들어야 한다.
- 진법의 베이스에 도달하면 그 자리는 0으로 두고, 왼쪽 자리에 1을 더하는 자리올림 개념은 그대로다.
- 단, 계수기에 물리적 제한이 있는 것처럼, 가장 왼쪽 숫자는 자리올림 전파가 없다. 단순히 0이 된다. (오버플로)
- 계수기에는 버튼이 있는데, 이를 누르면 가장 오른쪽 자리에서 1이 증가한다.

입력
- 숫자판 개수 N (이 계수기가 다룰 수 있는 자리수의 개수)
- 각 숫자판의 최댓값 (해당 최댓값을 넘어가는 경우 자리올림)
- 각 숫자판의 초기값 (0으로 세팅되지 않을수 있다.)
- 버튼을 누르는 횟수 K

동작
- 가장 오른쪽 자리를 1 올린다.
- 해당 자리의 자리 올림을 검사한다.
	- 자리 올림이 발생하지 않으면 반복을 중단한다.
	- 자리 올림이 발생했으면 해당 자리 값을 0으로 바꾸고 왼쪽 자리에 1을 더해준다. (왼쪽 자리가 있다면)

구현
- 숫자판 최댓값 리스트가 필요하다
- 숫자판 값을 나타내는 리스트가 필요하다
- 초기값을 통해 숫자판 값을 나타내는 리스트 값을 설정해준다.
'''

# 입력처리
N = int(input())
max_values = list(map(int, input().split()))
curr_values = list(map(int, input().split()))
K = int(input())

# 계수기는 별도로 구현하지 않고, curr_values 를 쓰기로 한다.
for _ in range(K):
	# 버튼 동작인 가장 오른쪽 자리 +1 을 처리한다.
	curr_values[-1] += 1
	
	# 자리 올림이 연쇄적으로 발생할 수 있다.
	# 가장 오른쪽부터 왼쪽까지 반복문을 돌린다.
	# 자리올림이 발생하지 않으면 중단시킨다.
	for i in range(N-1, -1, -1):
		if curr_values[i] <= max_values[i]:
			break
		# 자리 올림이 발생했다.
		else: 
			# 만약 가장 왼쪽 자리라면, 0으로 만들기만 한다.
			if i==0:
				curr_values[i] = 0
				break
			# 아니라서 자리 올림이 가능하면, 0으로 만들고 왼쪽 자리를 1 올린다.
			else: 
				curr_values[i] = 0
				curr_values[i - 1] += 1
			
# 계수기의 숫자를 공백없이 출력한다.
print(''.join(map(str, curr_values)))