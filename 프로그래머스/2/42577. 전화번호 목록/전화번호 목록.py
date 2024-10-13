def solution(phone_book):
    answer = True
    
    phone_book = sorted(phone_book, reverse=True)
    
    for i, val_i in enumerate(phone_book):
        if i == len(phone_book)-1:
            break
        if val_i.startswith(phone_book[i+1]):
            answer = False
            break
        
                
    return answer