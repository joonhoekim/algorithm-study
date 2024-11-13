def solution(lines):
    # 모든 시작점과 끝점을 기록
    points = []
    for start, end in lines:
        points.append((start, 1))  # 시작점
        points.append((end, -1))   # 끝점
    
    points.sort()  # 좌표 기준으로 정렬
    
    answer = 0
    count = 0
    prev_x = None
    
    for x, diff in points:
        # 이전 위치에서 겹친 부분이 2 이상이면 길이 추가
        if prev_x is not None and count >= 2:
            answer += x - prev_x
            
        count += diff  # 현재 겹치는 선분 수 업데이트
        prev_x = x
    
    return answer