# Imtiaz Adar
# BFS Implementation

from collections import deque
from collections import defaultdict

class graph:
    def __init__(self):
        self.vertex = defaultdict(list)

    def addEdge(self, u, v):
        self.vertex[u].append(v)
        self.vertex[v].append(u)

    def BFS(self, source):
        visited = [False] * (len(self.vertex))
        queue = deque([])
        visited[source] = True
        queue.append(source)
        while len(queue) != 0:
            node = queue.popleft()
            print(node, end=' ')
            for i in self.vertex[node]:
                if not visited[i]:
                    visited[i] = True
                    queue.append(i)
        print()

g = graph()
vertex = int(input('Enter how many vertex do you want to add : '))
edges = int(input('Enter how many edges do you want to add : '))
for _ in range(edges):
    print('Add Edge : ')
    source, destination = map(int, input().split())
    g.addEdge(source, destination)
# 0, 1  0, 2  1, 2  2, 0  2, 3  3, 3
s = int(input('Enter source : '))
print('\n##- BFS -##\n')
g.BFS(s)