def find_primes(M: int, N: int) -> list:
    # 에라토스테네스의 체 배열 초기화
    is_prime = [True] * (N + 1)
    is_prime[0] = is_prime[1] = False
    
    # 에라토스테네스의 체 알고리즘
    for i in range(2, int(N ** 0.5) + 1):
        if is_prime[i]:
            # i의 배수들을 모두 False로 표시
            for j in range(i * i, N + 1, i):
                is_prime[j] = False
    
    # M이상 N이하의 소수 리스트 생성
    primes = [num for num in range(M, N + 1) if is_prime[num]]
    return primes

# 입력 받기
M, N = map(int, input().split())

# 소수 찾기 및 출력
primes = find_primes(M, N)
for prime in primes:
    print(prime)