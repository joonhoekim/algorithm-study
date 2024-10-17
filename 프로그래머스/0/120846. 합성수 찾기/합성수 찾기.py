def solution(n):
    
    answer = 0
    
    for i in range(1, n+1):
        
        cnt_divisor = 0
        for j in range(1, i+1):
            if i%j == 0:
                cnt_divisor += 1
            if cnt_divisor == 3:
                answer += 1
                break
    
    return answer