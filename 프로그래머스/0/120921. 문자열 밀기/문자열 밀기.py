def solution(A, B):
    for i in range(0, len(A)):
        if A == B:
            return i
        A = A[-1] + A[0:-1]
        # print(A)
    return -1
    
    