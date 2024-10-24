import math

def solution(n):
    answer = 0
    acc = 1
    
    if n == 0:
        return 0
    elif n == 1:
        return 1
    
    for i in range(2, 12):
        acc *= i
        if acc > n:
            answer = i-1
            break
    return answer