def is_prime(n):
    if n < 2:
        return False
    if n == 2:
        return True
    if n % 2 == 0:
        return False
    
    for i in range(3, int(n ** 0.5) + 1, 2):
        if n % i == 0:
            return False
    return True

def next_prime(n):
    if n <= 2:
        return 2
        
    num = n if n % 2 == 1 else n + 1
    
    while not is_prime(num):
        num += 2
    return num

T = int(input())

for _ in range(T):
    n = int(input())
    print(next_prime(n))