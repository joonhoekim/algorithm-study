# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

'''
블록게임
커맨드라인에 따라서 블록을 상하좌우 인접위치에 배치하는데,
만약 이미 블록이 있는 경우, 이전에 놓았던 기록을 순차적으로 따라가면서 배치를 취소해야 한다.
마지막 커맨드 끝난 뒤, 존재하는 블럭들의 점수 총합을 출력한다. (블럭마다 점수가 다를 수 있다)
LIFO 이므로 pop 을 사용하는 스택에 블럭 놓은 순서를 기록해야 한다.
- 블럭을 놓는 평면에 음수 좌표가 불가능하다는 조건이 없다.
- 2차원 평면을 직접 구성하는 것도 가능하겠지만, (x, y, score) 형태의 튜플로 쓰는게 더 간단할 듯

입력
5
RRULD
5 2 4 3 2
'''

N = int(input())
commands = list(input())
scores = list(map(int, input().split()))

blocks = {
	(0,0): 1
}
stack = []

x,y = 0,0
directions = {
	'R': (1, 0),
	'L': (-1, 0),
	'U': (0, 1),
	'D': (0, -1)
}

for i, command in enumerate(commands):
	dx, dy = directions[command]
	nx, ny = x+dx, y+dy
	
	if (nx, ny) in blocks:
		while stack:
			prev_x, prev_y = stack.pop()
			del blocks[(prev_x, prev_y)]
			if (prev_x, prev_y) == (nx, ny):
				break
	blocks[(nx, ny)] = scores[i]
	stack.append((nx, ny))
	
	# update cursor
	x, y = nx, ny
	
print(sum(blocks.values()))
	
