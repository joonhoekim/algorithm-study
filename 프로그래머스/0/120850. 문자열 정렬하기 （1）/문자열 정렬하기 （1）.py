def solution(my_string):
    return sorted(list(int(el) for el in my_string if el.isdigit()))