#include <iostream>
#include <vector>
using namespace std;

vector<int> findPrimes(int M, int N) {
    // 에라토스테네스의 체 배열 초기화
    vector<bool> isPrime(N + 1, true);
    isPrime[0] = isPrime[1] = false;
    
    // 에라토스테네스의 체 알고리즘
    for (int i = 2; i * i <= N; i++) {
        if (isPrime[i]) {
            // i의 배수들을 모두 false로 표시
            for (int j = i * i; j <= N; j += i) {
                isPrime[j] = false;
            }
        }
    }
    
    // M이상 N이하의 소수만 결과 벡터에 담기
    vector<int> primes;
    for (int i = M; i <= N; i++) {
        if (isPrime[i]) {
            primes.push_back(i);
        }
    }
    
    return primes;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int M, N;
    cin >> M >> N;
    
    vector<int> primes = findPrimes(M, N);
    
    // 결과 출력
    for (int prime : primes) {
        cout << prime << '\n';
    }
    
    return 0;
}