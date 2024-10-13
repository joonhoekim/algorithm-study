def solution(arr):
    answer = []
    cursor = 0
    answer.append(arr[cursor])
    for i, value in enumerate(arr):
        if i==0:
            continue
        if value != answer[cursor]:
            answer.append(value)
            cursor+=1
    
    return answer