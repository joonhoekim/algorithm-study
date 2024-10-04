from itertools import permutations

def solution(numbers):
    prime_count = 0
    all_permutations = []
    for i in range(1,len(numbers)+1):
        all_permutations.extend(list(permutations(numbers,i)))
    
    set_ = set()
    for el in all_permutations:
        set_.add(int(''.join(el)))
    
    for el in set_:
        is_prime = True
        
        if el < 2:
            is_prime = False
            
        else:
            for i in range(2, el):
                if el%i==0:
                    is_prime = False
                    break
                    
        if is_prime:
            prime_count+=1
    
    
    return prime_count