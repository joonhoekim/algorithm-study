# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
'''
개요
- N*N 보드이며, 모든 자리에 단풍나무들이 심어져 있다.
- 보드 내의 값은, 해당 자리의 '물들지 않은 단풍나무의 수'를 의미한다.
- 보드 내의 값이 0 이면, 해당 자리의 모든 단풍나무들이 물들었다는 의미이다.
- 단풍나무가 물드는 조건은, 상하좌우 인접지에 값이 0인 자리가 있는 것이다. 0인 인접지의 수만큼 물든다. (자리의 값은 음수 쓰지 말고 0 이상으로 하자.)
- 하루마다 물드는 조건을 적용할 경우, 며칠이 걸릴 지 출력하면 된다.
입출력
- N 은 보드의 가로/세로 길이를 나타낸다.
- S_ij 는 공백으로 구분되어 여러 줄로 들어온다. 각 값은 보드의 현재 물들지 않은 단풍나무 개수를 나타낸다.
- 며칠이 걸려야 보드의 모든 값이 0 이 되는지를 출력하면 된다.
동작
- 각 보드 원소를 순차적으로 검사한다.
- 원소가 0이 아닌 경우, 상하좌우가 0인지 검사한다.
	- 이 때 보드 내부에 들어오는지 먼저 검사한다.
- 상하좌우 0의 개수에 따라 변경 여부를 저장한다. (바로 변경하면 안된다. 마스크처럼 저장하고 한번에 적용해야 한다.)
- 모든 원소 검사가 끝나면 저장된 마스크를 이용해 물들었음을 처리한다.
- 이 작업이 몇번 이루어졌는지를 카운트하고, 모든 원소가 0이 되기까지 반복한다.
- 작업 횟수를 출력한다.
구현
- 입력을 처리한다. 보드와 마스크를 이차원 리스트로 만들자.
- 상하좌우는 dxdy 를 사용하거나 여러 라인으로 구현하자
'''

def solve():
    answer = 0
    
    # 상하좌우
    dxs = [0, 0, -1, 1]
    dys = [1, -1, 0, 0]
    
    while True:
        # 보드가 전부 0 이면 종료한다.
        if sum(sum(row) for row in board) == 0:
            return answer
        
        answer += 1
        
        # 마스크 초기화
        mask = [[0] * N for _ in range(N)]
        
        for i in range(N):
            for j in range(N):
                # 이미 0 이면 넘긴다.
                if board[i][j] == 0:
                    continue

                # 인접지 검사
                for dx, dy in zip(dxs, dys):
                    ny, nx = i + dy, j + dx
                    if 0 <= ny < N and 0 <= nx < N and board[ny][nx] == 0:
                        mask[i][j] += 1  # 현재 위치의 값을 감소시킬 양을 누적.

        # 마스크를 적용한다.
        for i in range(N):
            for j in range(N):
                board[i][j] = max(0, board[i][j] - mask[i][j])  # 음수가 되지 않아야 함

N = int(input())
board = []

for i in range(N):
	board.append(list(map(int, input().split())))
	
print(solve())
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	