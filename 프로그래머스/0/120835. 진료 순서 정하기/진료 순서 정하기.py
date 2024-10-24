def solution(emergency):
    enum_sorted = sorted(enumerate(emergency), key=lambda x: -x[1])
    
    # 정렬된 결과에서 원래 인덱스 위치에 새로운 순서 저장
    result = [0] * len(emergency)
    for new_idx, (old_idx, _) in enumerate(enum_sorted):
        result[old_idx] = new_idx+1

    return result
    