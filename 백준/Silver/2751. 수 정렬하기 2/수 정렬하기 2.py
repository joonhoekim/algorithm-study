import sys

n = int(sys.stdin.readline())
nums = [int(sys.stdin.readline()) for _ in range(n)]
nums.sort()

for i in nums:
    sys.stdout.write(str(i) + '\n')