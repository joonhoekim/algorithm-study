def solution(common):
    r = 0
    is_multiplied = False
    if common[2] - common[1] == common[1] - common[0]:
        r = common[1] - common[0]
    elif common[2]//common[1] == common[1]//common[0]:
        r = common[1]//common[0]
        is_multiplied = True
    
        
    if is_multiplied:
        return common[-1] * r
    else:
        return common[-1] + r
    