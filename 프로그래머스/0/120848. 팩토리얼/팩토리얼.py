import math

def solution(n):
    # 1 부터 x 까지 하나씩 늘려보면서 처리하는 건 너무 비효율적인 것 같고...
    # factorial의 대략적인 값을 유추할 수 있나?
    max = 1
    for i in range(2, n+1):
        if math.factorial(i) > n:
            break
        else:
            max = i
    return max