def solution(my_string, num1, num2):
    l = list(my_string)
    l[num1], l[num2] = l[num2], l[num1]
    return ''.join(l)