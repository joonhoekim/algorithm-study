'''
명함 두께는 고려하지 않는 문제로,
모두 한 쪽이 길어지게 필요하다면 회전시켜서 풀기
'''

def solution(sizes):
    
    return max(max(x) for x in sizes) * max(min(x) for x in sizes)