def solution(n):
    UNIT = 7
    quotient, dividend = divmod(n, UNIT)
    if dividend > 0:
        answer = quotient + 1
    else:
        answer = quotient
    
    return answer
        