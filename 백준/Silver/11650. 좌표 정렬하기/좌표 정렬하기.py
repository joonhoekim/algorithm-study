n = int(input())
points = []
for _ in range(n):
    x, y = map(int, input().split())
    points.append((x, y))

points.sort(key=lambda p: (p[0], p[1]))

for x, y in points:
    print(x, y)