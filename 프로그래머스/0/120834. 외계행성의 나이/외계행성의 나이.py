def solution(age):
    age_str = list(map(int, str(age)))
    transcodes = list('abcdefghij')
    return ''.join(transcodes[i] for i in age_str)