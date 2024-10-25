def solution(array, n):
    answer = []
    min_diff = 100
    for i in array:
        diff = abs(i-n)
        if min_diff > diff:
            min_diff = diff
            answer = []
            answer.append(i)
        elif min_diff == diff:
            answer.append(i)
        
    return min(answer)
            
        