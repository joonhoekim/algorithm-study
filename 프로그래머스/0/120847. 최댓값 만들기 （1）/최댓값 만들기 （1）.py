def solution(numbers):
    # numbers는 0과 자연수만 들어온다.
    sorted_numbers = sorted(numbers)
    return sorted_numbers[-1] * sorted_numbers[-2]
    