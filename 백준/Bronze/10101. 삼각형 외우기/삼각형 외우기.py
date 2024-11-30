angles = []
angles.append(int(input()))
angles.append(int(input()))
angles.append(int(input()))

if sum(angles) != 180:
    print('Error')
    exit()

cnt = 0
for i in range(len(angles)):
    for j in range(i+1, len(angles)):
        if angles[i] == angles[j]:
            cnt += 1

answer = ''
if cnt == 3:
    answer = 'Equilateral'
elif cnt >= 1:
    answer = 'Isosceles'
else:
    answer = 'Scalene'

print(answer)