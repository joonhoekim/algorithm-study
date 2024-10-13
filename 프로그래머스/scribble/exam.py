n = int(input())

# 1 2 3 4 5
arr = list(map(int, input().split(" ")))
[1, 2, 3, 4, 5]

answer = [0, 0, 0, 0, 0, 0, 0, 0, 0]

for element in arr:
    answer[element-1] = answer[element-1] + 1

print(answer)

for element in answer:
    if element == 0:
        continue
    print(element, end=' ')


### 

1 2
1 3
2 2
999 9999
123 321
-12 32
....
....
1 1
1 1 

set()

points = set()
# 튜플 (1) (1, 2) ()
x, y = map(int, input().split())

if (x, y) in points:
    points.remove((x, y))
else:
    points.add((x, y))

print(len(points), end='')

( (1,2), (2,3) ...)

동전 더미
          1
    1     1
1   1     1
1 1 1 0 0 1 1
      
3 + 4 + 