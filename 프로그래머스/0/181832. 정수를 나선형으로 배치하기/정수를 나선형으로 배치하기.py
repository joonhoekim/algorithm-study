def solution(n):
    # 격자 초기화
    answer = [[-1]*n for _ in range(n)]
    
    # 카운터, 시작위치, 현재 방향을 기억하며 풀기
    counter = 1  # 0 대신 1부터 시작
    row, col = 0, 0  # 시작 위치를 (0, 0)으로 변경
    dir_idx = 0

    # 진행방향 정의: 오른쪽 아래 왼쪽 위
    directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    
    # n*n 번 반복 (격자의 모든 칸을 채울 때까지)
    for _ in range(n*n):
        answer[row][col] = counter
        counter += 1
        
        # 다음 위치 계산
        nrow, ncol = row + directions[dir_idx][0], col + directions[dir_idx][1]
        
        # 다음 위치가 유효하지 않거나 이미 채워진 경우 방향 전환
        if nrow < 0 or nrow >= n or ncol < 0 or ncol >= n or answer[nrow][ncol] != -1:
            dir_idx = (dir_idx + 1) % 4
            nrow, ncol = row + directions[dir_idx][0], col + directions[dir_idx][1]
        
        row, col = nrow, ncol

    return answer