def solution(sides):
    sides.sort()
    if sum(sides[0:2]) <= sides[2]:
        return 2
    else:
        return 1