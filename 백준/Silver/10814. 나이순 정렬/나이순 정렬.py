n = int(input())
members = []

for i in range(n):
    age, name = input().split()
    members.append((int(age), i, name))

members.sort(key=lambda x: (x[0], x[1]))

for age, _, name in members:
    print(age, name)