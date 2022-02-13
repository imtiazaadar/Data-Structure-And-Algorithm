/* Author :  Imtiaz Adar */
#include<bits/stdc++.h>
#define ll long long
#define pb push_back
#define all(v) sort(v.begin(), v.end())
#define for1(i, x, y) for(int i = x; i < y; i++)
#define for2(i, x, y) for(long i = x; i < y; i++)
#define for3(i, x, y) for(long long i = x; i < y; i++)
using namespace std;
template<typename T>
void addEdge(vector<T> adj[], T parent, T child){
    adj[parent].pb(child);
}
template<typename T>
void bfs(vector<T> adj[], T nodes, T source){
    bool* visited = new bool[nodes];
    for(int i = 0; i < nodes; i++){
        visited[i] = false;
    }
    visited[source] = true;
    queue<int> q;
    q.push(source);
    while(!q.empty()){
        int node = q.front();
        q.pop();
        cout << node << " ";
        vector<int>::iterator it;
        for(it = adj[node].begin(); it != adj[node].end(); it++){
            if(!visited[*it]){
                visited[*it] = true;
                q.push(*it);
            }
        }
    }
    delete[] visited;
}
template<typename T>
void dfsUtil(vector<T> adj[], bool visited[], T source){
    visited[source] = true;
    cout << source << " ";
    vector<int>::iterator it;
    for(it = adj[source].begin(); it != adj[source].end(); it++){
        if(!*it){
            dfsUtil(adj, visited, *it);
        }
    }
}
template<typename T>
void dfs(vector<T> adj[], T nodes){
    bool visited[nodes];
    for(int i = 0; i < nodes; i++){
        if(!visited[i])
            dfsUtil(adj, visited, i);
    }
}
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int nodes;
    cout << "Nodes : " << endl;
    cout.flush();
    cin >> nodes;
    vector<int> adj[nodes];
    cout << "Edges : " << endl;
    cout.flush();
    int edges;
    cin >> edges;
    while(edges--){
        int parent, child;
        cin >> parent >> child;
        addEdge(adj, parent, child);
    }
    int source;
    cout << "Source : ";
    cout.flush();
    cin >> source;
    bfs(adj, nodes, source);
    cout << endl;
    dfs(adj, nodes);
    cout << endl;
    fflush(stdout);
    return 0;
}
