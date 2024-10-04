from collections import deque

def solution(progresses, speeds):
    
    answer = []
    queue = deque(zip(progresses, speeds))
    
    while queue:
        for i, (progress, speed) in enumerate(queue):
            queue[i] = ((progress+speed), speed)
        
        count = 0
        while queue and queue[0][0] >= 100:
            count+=1
            queue.popleft()
        
        if count>0:
            answer.append(count)
            
    
    return answer