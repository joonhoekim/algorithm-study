# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
'''
node = N개, edge = M개 (무방향성)
구하고자 하는 건, 특정 노드에 연결되어 있는 전체 노드의 수 (시작노드 포함)
DFS/BFS 모두 무방
DFS 재귀 가능 but 콜스택 크기 3000정도인 점 고려해야
'''
from collections import defaultdict

def dfs(graph, curr_node, visited):
    global answer
    for next_node in graph[curr_node]:
        if next_node not in visited:
            visited.add(next_node)
            answer += 1
            dfs(graph, next_node, visited)

N = int(input())
M = int(input())

graph = defaultdict(list)
for _ in range(M):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)  # 양방향 그래프 처리

start_friend = 1
answer = 1
visited = set([start_friend])
dfs(graph, start_friend, visited)

print(answer)