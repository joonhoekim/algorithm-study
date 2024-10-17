def solution(numbers, direction):
    net_shift = direction.count('right') - direction.count('left')
    
    if net_shift == 0:
        return numbers
    
    n = len(numbers)
    shift = net_shift % n  # 실제 필요한 이동 횟수
    
    if shift > 0:  # 오른쪽 이동
        return numbers[-shift:] + numbers[:-shift]
    else:  # 왼쪽 이동
        return numbers[-shift:] + numbers[:-shift]