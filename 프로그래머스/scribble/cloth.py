'''
전략:
    키-값 형태로 입력을 가공한 다음에 Combination 구하기
    리스트 안에 들어간 문자열 중 앞은 값, 뒤는 키
'''

def solution(clothes):
    answer = 1
    
    # convert list to hashtalbe
    dictionary = {}
    for item, category in clothes:
        if category not in dictionary:
            dictionary[category] = []
        dictionary[category].append(item)

    # Just count !
    for category in dictionary:
        answer *= (len(dictionary[category])+1)
        print(category)

    return answer - 1




clothes = [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]

print(solution(clothes=clothes))