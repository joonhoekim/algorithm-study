'''
명함 두께는 고려하지 않는 문제로,
모두 한 쪽이 길어지게 필요하다면 회전시켜서 풀기
'''

def solution(sizes):
    max_w = 0
    max_h = 0
    for w, h in sizes:
        big, small = max(w,h), min(w,h)
        max_w = max(max_w, big)
        max_h = max(max_h, small)
    
    return max_w * max_h
        
    
    
    
    
    
    
    
    
    
    
    # return max(max(x) for x in sizes) * max(min(x) for x in sizes)