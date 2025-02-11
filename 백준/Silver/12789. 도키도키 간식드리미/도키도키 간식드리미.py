def check_possible(n, waiting):
    temp_space = []  # 임시 대기 공간 (스택)
    current_number = 1  # 현재 받아야 할 번호표 번호
    
    # 대기열의 사람들을 하나씩 처리
    for person in waiting:
        # 임시 공간에서 가능한 만큼 처리
        while temp_space and temp_space[-1] == current_number:
            temp_space.pop()
            current_number += 1
            
        # 현재 사람이 바로 받을 차례인 경우
        if person == current_number:
            current_number += 1
        # 임시 공간으로 이동
        else:
            temp_space.append(person)
    
    # 남은 임시 공간 처리
    while temp_space and temp_space[-1] == current_number:
        temp_space.pop()
        current_number += 1
    
    # 모든 사람이 순서대로 받았는지 확인
    return "Nice" if current_number > n else "Sad"

# 입력 처리
n = int(input())
waiting = list(map(int, input().split()))

# 결과 출력
print(check_possible(n, waiting))