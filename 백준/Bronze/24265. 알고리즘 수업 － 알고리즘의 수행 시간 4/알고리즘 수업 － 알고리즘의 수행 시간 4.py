def count_men_of_passion(n):
    executions = (n * (n-1)) // 2
    highest_degree = 2
    return executions, highest_degree

n = int(input())

executions, highest_degree = count_men_of_passion(n)

print(executions)
print(highest_degree)