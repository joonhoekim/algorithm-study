import sys
input = sys.stdin.readline

def calculate_final_sum():
    # K개의 숫자를 입력받음
    K = int(input())
    
    # 숫자를 저장할 스택
    numbers = []
    
    # K번 반복하면서 입력 처리
    for _ in range(K):
        num = int(input())
        
        if num == 0:
            # 0이 입력되면 가장 최근 숫자를 제거
            numbers.pop()
        else:
            # 0이 아닌 숫자는 스택에 추가
            numbers.append(num)
    
    # 최종적으로 남은 수들의 합을 반환
    return sum(numbers)

# 결과 출력
print(calculate_final_sum())