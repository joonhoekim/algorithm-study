# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

'''
용어 정의
- 연결요소 : 상하좌우로 인접한 칸에 같은 문자가 적힌 경우, 해당 두 요소는 서로 연결요소임. 이런 식으로 큰 연결요소의 구성이 가능하다.
- 연결요소의 크기 : 연결요소의 개수
- 빈 연결 요소는 . 으로 나타낸다.
- 지운다는 것은 . 으로 바꾸는 것이다.

작업수행방법
- board[y][x] 에 di 적음. 여기서 주어지는 x, y 는 . 문자가 적힌 칸임
- 연결요소 크기 계산하는데, 만약 크기가 K 이상이면 모든 연결요소를 지운다.
- 크기 조건에 걸리지 않은 연결요소들은 그냥 두면 된다.

전략
- 처음엔 지울 요소가 없다고 하니, 지우고 시작해야 한다는 조건은 없음. 
- 따라서 문자열 적은 부분에서만 연결요소가 발생 가능함. 적은 부분만 검사하면 된다는 이야기.
- DFS 혹은 BFS로 풀 수 있는데 크기가 커지면 스택오버플로 발생할 것으로 보이므로 반복으로 풀기
'''
from collections import deque

def bfs(board, start_x, start_y, N, K):
    char = board[start_x][start_y]
    queue = deque([(start_x, start_y)])
    visited = set([(start_x, start_y)])
    connected = [(start_x, start_y)]

    while queue:
        x, y = queue.popleft()
        for dx, dy in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
            nx, ny = x + dx, y + dy
            if 0 <= nx < N and 0 <= ny < N and board[nx][ny] == char and (nx, ny) not in visited:
                queue.append((nx, ny))
                visited.add((nx, ny))
                connected.append((nx, ny))

    if len(connected) >= K:
        for x, y in connected:
            board[x][y] = '.'

def solve():
    N, K, Q = map(int, input().split())
    board = [list(input().strip()) for _ in range(N)]

    for _ in range(Q):
        x, y, char = input().split()
        x, y = int(x) - 1, int(y) - 1  # 1-indexed to 0-indexed
        board[x][y] = char
        bfs(board, x, y, N, K)

    for row in board:
        print(''.join(row))

solve()