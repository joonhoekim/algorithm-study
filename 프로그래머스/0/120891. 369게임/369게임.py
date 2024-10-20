def solution(order):
    seek = ['3', '6', '9']
    answer = 0
    for ch in list(str(order)):
        if ch in seek:
            answer += 1
    return answer