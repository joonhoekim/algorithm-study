def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

def solution():
    a1, b1 = map(int, input().split())
    a2, b2 = map(int, input().split())
    
    numerator = a1 * b2 + a2 * b1
    denominator = b1 * b2
    g = gcd(numerator, denominator)
    numerator //= g
    denominator //= g
    
    print(numerator, denominator)

solution()