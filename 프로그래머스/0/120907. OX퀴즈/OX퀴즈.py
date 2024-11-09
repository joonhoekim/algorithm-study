def solution(quiz):
    answer = []
    params = []
    for q in quiz:
        params.append(q.split(" = "))
    for exp, submit in params:
        if eval(exp) == int(submit):
            answer.append("O")
        else: answer. append("X")
    return answer