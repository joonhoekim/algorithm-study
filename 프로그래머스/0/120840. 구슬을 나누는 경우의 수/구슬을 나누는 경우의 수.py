def solution(balls, share):
    answer = 1
    for i in range(share):
        answer *= (balls - i)
        answer //= (i + 1)
    return answer