from collections import Counter
import time
import random

def count_with_counter(data):
    return Counter(data)

def count_with_loop(data):
    count_dict = {}
    for item in data:
        if item in count_dict:
            count_dict[item] += 1
        else:
            count_dict[item] = 1
    return count_dict

# 테스트 데이터 생성
data = [random.randint(1, 1000) for _ in range(1_000_000)]

# Counter 성능 측정
start = time.time()
counter_result = count_with_counter(data)
counter_time = time.time() - start

# 반복문 성능 측정
start = time.time()
loop_result = count_with_loop(data)
loop_time = time.time() - start

print(f"Counter 시간: {counter_time:.6f} 초")
print(f"반복문 시간: {loop_time:.6f} 초")
print(f"Counter가 {loop_time / counter_time:.2f}배 더 빠름")

'''
Apple Macbook Air M1

try1
Counter 시간: 0.062698 초
반복문 시간: 0.122346 초
Counter가 1.95배 더 빠름

try2
Counter 시간: 0.063365 초
반복문 시간: 0.119993 초
Counter가 1.89배 더 빠름

try3
Counter 시간: 0.063872 초
반복문 시간: 0.123844 초
Counter가 1.94배 더 빠름
'''