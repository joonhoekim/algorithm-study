def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

def find_gcd_array(arr):
    result = arr[0]
    for i in range(1, len(arr)):
        result = gcd(result, arr[i])
    return result

def solution():
    N = int(input())
    trees = [int(input()) for _ in range(N)]
    
    distances = []
    for i in range(1, N):
        distances.append(trees[i] - trees[i-1])
    
    distance_gcd = find_gcd_array(distances)
    
    total_trees = 0
    for dist in distances:
        total_trees += (dist // distance_gcd) - 1
    
    print(total_trees)

solution()