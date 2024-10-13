def solution(phone_book):
    answer = True
    
    # phone_book.sort()
    phone_book = sorted(phone_book, reverse=True)
    
    for i, val_i in enumerate(phone_book):
        for j, val_j in enumerate(phone_book[i+1:]):
            if val_i.startswith(val_j):
                answer = False
                break
                
    return answer


phone_book = ["119", "97674223", "1195524421"]
# phone_book = ["123", "456", "789"]
print(solution(phone_book))
