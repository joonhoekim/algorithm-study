import math

def solution(a, b):
    a = a % b
    gcd = math.gcd(a,b)
    b //= gcd
    
    divisor = 2
    while b > 1:
        if b % divisor == 0:
            b //= divisor
            if divisor != 2 and divisor != 5:
                return 2
        else: divisor += 1
    return 1
    
    