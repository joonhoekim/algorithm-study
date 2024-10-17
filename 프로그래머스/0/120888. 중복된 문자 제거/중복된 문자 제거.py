def solution(my_string):
    
    return ''.join(dict(zip(my_string, [0]*len(my_string))).keys())