def solution(my_string, letter):
    return ''.join(ch for ch in my_string if ch != letter)