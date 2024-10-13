def solution(nums):
    answer = 0

    max = len(nums)//2
    set_pkm = set()
    # 일단 중복 없는 개수를 세보기
    for el in nums:
        set_pkm.add(el)
    if len(set_pkm)>=max:
      answer=max
    else:
      answer=len(set_pkm)
    
    return answer