def solution(rsp):
    wins = []
    for x in rsp:
        if x == '2':
            wins.append('0')
        elif x == '0':
            wins.append('5')
        elif x == '5':
            wins.append('2')
        # 예외처리
        else:
            wins.append('-')
    return ''.join(wins)