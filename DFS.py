# Imtiaz Adar
# DFS Implementation

from collections import defaultdict

class Graph:
    def __init__(self):
        self.graph = defaultdict(list)

    def addEdge(self, u, v):
        self.graph[u].append(v)

    def DfsUtil(self, visited, source):
        visited.add(source)
        print(source, end=' ')
        for neighbour in self.graph[source]:
            if neighbour not in visited:
                self.DfsUtil(visited, neighbour)

    def DFS(self):
        visited = set()
        for vertex in self.graph:
            if vertex not in visited:
                self.DfsUtil(visited, vertex)

g = Graph()
vertex = int(input('Enter how many vertex do you want to add : '))
edges = int(input('Enter how many edges do you want to add : '))
for _ in range(edges):
    print('Add Edge : ', end='')
    source, destination = map(int, input().split())
    g.addEdge(source, destination)
print('\n##- DFS -##\n')
g.DFS()
