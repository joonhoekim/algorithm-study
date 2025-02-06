import sys

# 입력을 더 빠르게 받기 위해 sys.stdin.readline 사용
input = sys.stdin.readline

def process_stack_commands():
    # 스택을 리스트로 구현
    stack = []
    
    # 명령어 수 입력 받기
    N = int(input())
    
    # N개의 명령어 처리
    for _ in range(N):
        # 명령어 입력 받기
        command = list(map(int, input().split()))
        
        # 명령어 처리
        if command[0] == 1:  # push
            stack.append(command[1])
            
        elif command[0] == 2:  # pop
            if stack:
                print(stack.pop())
            else:
                print(-1)
                
        elif command[0] == 3:  # size
            print(len(stack))
            
        elif command[0] == 4:  # empty
            print(1 if not stack else 0)
            
        elif command[0] == 5:  # top
            if stack:
                print(stack[-1])
            else:
                print(-1)

# 메인 함수 실행
process_stack_commands()