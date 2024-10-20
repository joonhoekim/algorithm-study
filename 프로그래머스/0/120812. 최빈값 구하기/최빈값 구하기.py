def solution(array):
    if not array:
        return -1

    counter = {}
    for el in array:
        counter[el] = counter.get(el, 0) + 1

    sorted_counter = sorted(counter.items(), key=lambda x: (-x[1], x[0]))

    if len(sorted_counter) == 1:
        return sorted_counter[0][0]
    
    if sorted_counter[0][1] == sorted_counter[1][1]:
        return -1
    else:
        return sorted_counter[0][0]