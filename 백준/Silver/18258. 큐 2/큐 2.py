from collections import deque
import sys

# For faster input
input = sys.stdin.readline

# Initialize queue
queue = deque()
N = int(input())

# Process commands
for _ in range(N):
    command = input().split()
    
    if command[0] == 'push':
        queue.append(int(command[1]))
        
    elif command[0] == 'pop':
        if queue:
            print(queue.popleft())
        else:
            print(-1)
            
    elif command[0] == 'size':
        print(len(queue))
        
    elif command[0] == 'empty':
        print(1 if not queue else 0)
        
    elif command[0] == 'front':
        if queue:
            print(queue[0])
        else:
            print(-1)
            
    elif command[0] == 'back':
        if queue:
            print(queue[-1])
        else:
            print(-1)