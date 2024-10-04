from collections import deque

def solution(progresses, speeds):
    answer = []
    queue = deque(zip(progresses, speeds))
    
    while queue:
        # 모든 기능의 진행 상황을 업데이트
        for i in range(len(queue)):
            progress, speed = queue[i]
            queue[i] = (min(progress + speed, 100), speed)
        
        # 완료된 기능 카운트 및 릴리스
        count = 0
        while queue and queue[0][0] >= 100:
            count += 1
            queue.popleft()
        
        if count > 0:
            answer.append(count)
    
    return answer