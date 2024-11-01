def solution(n):
    answer = set()
    cursor = 2
    
    while n > 1:  # while문 사용으로 변경
        if n % cursor == 0:
            answer.add(cursor)
            n //= cursor
        else:
            cursor += 1
    
    return sorted(list(answer))  # 정렬 추가