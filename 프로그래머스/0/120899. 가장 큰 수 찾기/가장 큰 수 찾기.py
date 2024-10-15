def solution(array):
    max_val = max(array)
    return [max_val, array.index(max_val)]