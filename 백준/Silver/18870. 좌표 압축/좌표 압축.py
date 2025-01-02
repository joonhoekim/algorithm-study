def compress_coordinates(N, coords):
    sorted_unique = sorted(set(coords))
    rank_dict = {val: rank for rank, val in enumerate(sorted_unique)}    
    return [rank_dict[x] for x in coords]

N = int(input())
coords = list(map(int, input().split()))

result = compress_coordinates(N, coords)
print(*result)