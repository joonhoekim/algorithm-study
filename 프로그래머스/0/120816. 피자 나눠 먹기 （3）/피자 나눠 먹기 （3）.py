def solution(slice, n):
    quotient, dividend = divmod(n, slice)
    if dividend==0:
        return quotient
    else:
        return quotient+1