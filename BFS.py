# Imtiaz Adar
# BFS Implementation

from collections import deque
from collections import defaultdict

class Graph:
    def __init__(self):
        self.graph = defaultdict(list)

    def addEdge(self, u, v):
        self.graph[u].append(v)

    def BFS(self, source):
        visited = [False] * (len(self.graph))
        queue = deque([])
        visited[source] = True
        queue.append(source)
        while len(queue) != 0:
            node = queue.popleft()
            print(node, end=' ')
            for i in self.graph[node]:
                if not visited[i]:
                    visited[i] = True
                    queue.append(i)
        print()

g = Graph()
vertex = int(input('Enter how many vertex do you want to add : '))
edges = int(input('Enter how many edges do you want to add : '))
for _ in range(edges):
    print('Add Edge : ', end='')
    source, destination = map(int, input().split())
    g.addEdge(source, destination)
s = int(input('Enter source : '))
print('\n##- BFS -##\n')
g.BFS(s)
