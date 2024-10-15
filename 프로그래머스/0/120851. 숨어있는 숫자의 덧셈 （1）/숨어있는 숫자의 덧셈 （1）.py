def is_int(ch):
    try:
        int(ch)
        return True
    except ValueError:
        return False

def solution(my_string):
    return sum([int(x) for x in my_string if is_int(x)])
        