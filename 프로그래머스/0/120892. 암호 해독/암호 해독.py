def solution(cipher, code):
    return ''.join(ch for i, ch in enumerate(cipher) if (i+1)%code == 0)