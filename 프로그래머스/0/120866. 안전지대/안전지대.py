def solution(board):
    def is_in(r, c, r_limit, c_limit):
        return 0 <= r < r_limit and 0 <= c < c_limit
    
    n = len(board)
    m = len(board[0])
    danger = [[0] * m for _ in range(n)]
    
    for i, row in enumerate(board):
        for j, el in enumerate(row):
            if el == 1:
                for r in range(i-1, i+2):
                    for c in range(j-1, j+2):
                        if is_in(r, c, n, m):
                            danger[r][c] = 1
    
    safe_count = sum(row.count(0) for row in danger)
    return safe_count