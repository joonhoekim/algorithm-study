def solution(num, k):
    if str(num).count(str(k)):
        return str(num).index(str(k))+1
    else:
        return -1