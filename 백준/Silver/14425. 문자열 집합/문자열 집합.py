def solve_string_set():
    # 입력 받기
    N, M = map(int, input().split())
    
    # 집합 S에 문자열들을 저장 (집합 자료구조 사용)
    string_set = set()
    for _ in range(N):
        string_set.add(input())
    
    # 검사할 M개의 문자열들이 집합 S에 몇 개 포함되어 있는지 계산
    count = 0
    for _ in range(M):
        if input() in string_set:
            count += 1
    
    # 결과 출력
    print(count)

solve_string_set()