'''
아주 유명한 스택 문제
( 는 스택에 넣고
) 는 스택에서 빼주는데
- 없을 때 빼려고 한다거나
- 마지막에 스택에 원소가 남아있으면 잘못된 식
'''

from collections import deque

def solution(s):
    answer = True
    
    stack = deque()
    for ch in s:
        if ch=='(':
            stack.append(1)
        elif ch==')':
            if not stack:
                return False
            else:
                stack.pop()
    
    if stack:
        return False
    
    return True