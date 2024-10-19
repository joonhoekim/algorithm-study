def solution(chicken):
    coupons = chicken
    answer = 0
    while coupons >= 10:
        svc, rest = divmod(coupons, 10)
        answer += svc
        rest += svc
        coupons = rest
    return answer