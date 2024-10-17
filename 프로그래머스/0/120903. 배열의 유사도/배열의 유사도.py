def solution(s1, s2):
    # 중복 없음
    # 같은 원소 개수 리턴
    # 해쉬테이블에 넣고 O(1)로 조회 반복하는 O(n)이 가장 빠를 듯
    answer = 0
    if len(s1) > len(s2):
        long_set = set(s1)
        short_set = set(s2)
    else:
        long_set = set(s2)
        short_set = set(s1)
    for el in short_set:
        if el in long_set:
            answer += 1
            long_set.remove(el)
    return answer
    
    
    
    
        