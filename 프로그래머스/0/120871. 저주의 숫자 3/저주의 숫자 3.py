def is_prohibited(n):
    if n % 3 == 0 or "3" in str(n):
        return True
    else:
        return False
    
def solution(n):
    answer = 0
    for _ in range(n):
        answer += 1
        while(is_prohibited(answer)):
            answer += 1
    return answer