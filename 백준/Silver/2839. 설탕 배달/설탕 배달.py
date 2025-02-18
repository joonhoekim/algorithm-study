N = int(input())

def sugar_delivery(N):
    for five_bags in range(N // 5, -1, -1):
        remaining = N - (five_bags * 5)
        if remaining % 3 == 0:
            three_bags = remaining // 3
            return five_bags + three_bags
    return -1

print(sugar_delivery(N))