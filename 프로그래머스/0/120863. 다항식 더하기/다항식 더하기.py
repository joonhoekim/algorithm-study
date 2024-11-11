def solution(polynomial):
    factors = polynomial.split(" + ")
    coefficient = 0
    constant = 0
    
    for factor in factors:
        if "x" in factor:
            coef = factor.replace("x", "")
            coefficient += 1 if coef == "" else int(coef)
        else:
            constant += int(factor)

    if coefficient == 0:
        return str(constant) if constant != 0 else "0"
    
    coef_str = "" if coefficient == 1 else str(coefficient)
    if constant == 0:
        return f"{coef_str}x"
    else:
        return f"{coef_str}x + {constant}"