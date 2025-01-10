N = int(input())
cards = set(map(int, input().split()))

M = int(input())
targets = list(map(int, input().split()))

result = [1 if t in cards else 0 for t in targets]
print(' '.join(map(str, result)))