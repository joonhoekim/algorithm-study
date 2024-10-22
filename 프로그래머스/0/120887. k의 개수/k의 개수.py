def solution(i, j, k):
    str_k = str(k)
    cnt = 0
    for x in range(i, j+1):
        cnt += str(x).count(str_k)
    return cnt