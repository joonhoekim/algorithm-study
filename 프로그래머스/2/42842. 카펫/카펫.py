# 미친거냐 Leo...
# 테두리는 1개씩, 가운데는 직사각형 모양
# 가로 >= 세로

# 1-9, 2-10, 3-12 ...
# yellow 는 1, 2, 3... 이렇게 하나씩 높이를 높여가면서 탐색
# brown 은 해당 yellow에서 구하기
# brown 개수 : 양 꼭지점 4개 고정, 높이*2 + 너비*2 이다


# yellow's w, h
def count_brown(w, h):
    return 4+2*(w+h)

def solution(brown, yellow):
    answer = []
    
    for h in range(1, yellow//2+2):
        if yellow%h != 0:
            continue
        
        w = yellow//h
        if brown==count_brown(w,h):
            answer = [w+2, h+2]
            break
    
    return answer