def solution(numbers, target):
    def dfs(index, current_sum):
        if index==len(numbers):
            return 1 if current_sum == target else 0
        
        plus = dfs(index+1, current_sum+numbers[index])
        minus = dfs(index+1, current_sum-numbers[index])
        
        return plus+minus
    return dfs(0,0)



