def solution(slice, n):
    # 1을 뺀 상태에서 나누고 1을 더하면 올림의 효과와 동일하다
    return ((n - 1) // slice) + 1
