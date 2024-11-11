def solution(numlist, n):
    diffs = []
    for num in numlist:
        diffs.append((abs(n - num), num))
    diffs = sorted(diffs, key = lambda x:(x[0], -x[1]))
    return [origin for diff, origin in diffs]
