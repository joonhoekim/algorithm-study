def solution(price):
    discount_ratio = 0
    if price >= 500_000:
        discount_ratio = 0.2
    elif price >= 300_000:
        discount_ratio = 0.1
    elif price >= 100_000:
        discount_ratio = 0.05
    elif price >= 0:
        discount_ratio = 0
    else:
        return -1
    
    return int(price*(1-discount_ratio))