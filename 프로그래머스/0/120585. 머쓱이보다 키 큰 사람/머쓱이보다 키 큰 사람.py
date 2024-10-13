def solution(array, height):
    answer = len([x for x in array if x > height])
    return answer