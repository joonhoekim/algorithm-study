def solution(n):
    return sum(2 for i in range(1, int(n**0.5)+1) if n%i == 0) if int(n**0.5)**2 != n else sum(2 for i in range(2, int(n**0.5)+1) if n%i == 0) + 1