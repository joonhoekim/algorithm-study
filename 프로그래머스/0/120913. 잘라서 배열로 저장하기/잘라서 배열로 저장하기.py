def solution(my_str, n):
    answer = []
    cursor = 0
    for _ in range(0, len(my_str)):
        cursor += n
        if cursor < len(my_str):
            answer.append(my_str[cursor-n:cursor])
        else:
            answer.append(my_str[cursor-n:])
            break
    return answer