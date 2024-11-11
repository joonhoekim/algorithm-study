def solution(num, total):
    start = (total - (num - 1) * num // 2) // num
    return [i for i in range(start, start + num)]