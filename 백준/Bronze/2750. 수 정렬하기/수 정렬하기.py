n = int(input())
set_number = set()
for i in range(n):
    set_number.add(int(input()))

list_number = list(set_number)
list_number.sort()


for i in list_number:
    print(i)