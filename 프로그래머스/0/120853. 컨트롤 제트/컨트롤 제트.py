def solution(s):
    answer = 0
    prev = 0
    for ch in s.split():
        if ch == 'Z':
            answer -= prev
        else:
            num = int(ch)
            answer += num
            prev = num
    return answer