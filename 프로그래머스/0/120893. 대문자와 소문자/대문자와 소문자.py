def solution(my_string):
    UPPER_CASE = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    LOWER_CASE = 'abcdefghijklmnopqrstuvwxyz'
    answer = []
    for ch in my_string:
        if ch in UPPER_CASE:
            answer.append(LOWER_CASE[UPPER_CASE.index(ch)])
        elif ch in LOWER_CASE:
            answer.append(UPPER_CASE[LOWER_CASE.index(ch)])
    return ''.join(answer)