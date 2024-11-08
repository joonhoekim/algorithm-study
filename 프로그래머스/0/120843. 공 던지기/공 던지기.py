def solution(numbers, k):
    step = 2
    return numbers[(k-1)*step % len(numbers)]
    