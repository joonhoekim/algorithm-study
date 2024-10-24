def solution(my_string):
    answer = []
    current = ''
    for ch in my_string:
        if ch.isdigit(): current += ch
        elif current: 
            answer.append(int(current))
            current = ''
    if current:
        answer.append(int(current))
            
    # print(answer)
    return sum(answer)
    
        
            