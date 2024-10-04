'''
명함 두께는 고려하지 않는 문제로,
모두 한 쪽이 길어지게 필요하다면 회전시켜서 풀기
'''

def solution(sizes):
        
    max_width = 0
    max_height = 0
    
    # width > height
    for w,h in sizes:
        if w>h:
            w,h = h,w
        
        max_width=max(max_width, w)
        max_height=max(max_height, h)
    
    return max_width*max_height