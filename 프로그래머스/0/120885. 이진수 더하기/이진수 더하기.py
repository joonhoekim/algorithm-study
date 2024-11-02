def solution(bin1, bin2):
    bin1_list = list(bin1)
    bin2_list = list(bin2)
    bin1_list.reverse()
    bin2_list.reverse()
    
    dec1 = 0
    dec2 = 0
    BASE = 2
    
    for digit, bit1 in enumerate(bin1_list):
        dec1 += int(bit1) * (BASE**digit)
    for digit, bit2 in enumerate(bin2_list):
        dec2 += int(bit2) * (BASE**digit)
        
    dec_sum = dec1 + dec2
    
    if dec_sum == 0:
        return "0"
    
    answer = []
    while dec_sum > 0:
        answer.append(str(dec_sum % BASE))
        dec_sum //= BASE
    
    answer.reverse()
    return ''.join(answer)