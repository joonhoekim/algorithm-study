import sys
input = sys.stdin.readline

def is_valid_parenthesis(s):
    stack = []
    
    # 문자열의 각 문자를 순회
    for char in s:
        if char == '(':
            # 여는 괄호는 스택에 추가
            stack.append(char)
        else:  # char == ')'
            # 닫는 괄호를 만났을 때
            if not stack:  # 스택이 비어있다면 잘못된 경우
                return False
            # 스택의 top에서 여는 괄호를 제거
            stack.pop()
    
    # 모든 검사가 끝난 후 스택이 비어있어야 올바른 괄호 문자열
    return len(stack) == 0

def process_test_cases():
    # 테스트 케이스 개수 입력
    T = int(input())
    
    # 각 테스트 케이스 처리
    for _ in range(T):
        ps = input().strip()  # 괄호 문자열 입력
        print("YES" if is_valid_parenthesis(ps) else "NO")

# 메인 실행
process_test_cases()