# 해당 키에 속한 값의 개수 + 1(선택안함) 을 계속 곱해주고, 전부 선택하지 않는 경우 하나를 빼기

def solution(clothes):
    answer = 1
    
    dictionary = {}
    for item, category in clothes:
        if category not in dictionary:
            dictionary[category] = []
        dictionary[category].append(item)
        
    for category in dictionary:
        answer *= len(dictionary[category])+1
    
    return answer - 1