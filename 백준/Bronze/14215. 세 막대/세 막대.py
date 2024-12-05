def max_perimeter(a, b, c):
    sides = sorted([a, b, c], reverse=True)
    
    if sides[0] >= sides[1] + sides[2]:
        sides[0] = sides[1] + sides[2] - 1
    
    return sum(sides)

a,b,c = list(map(int,input().split()))
print(max_perimeter(a,b,c))