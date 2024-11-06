def solution(dots):
    x_list = [p[0] for p in dots]
    y_list = [p[1] for p in dots]
    return (max(x_list)-min(x_list))*(max(y_list)-min(y_list))