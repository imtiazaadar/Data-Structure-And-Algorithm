/* Author :  Imtiaz Adar */
#include<bits/stdc++.h>
#define pb push_back
#define mp make_pair
#define fi first
#define se second
#define vi vector<int>
#define pi pair<int, int>
#define rep(i, x) for(int i = 0; i < x; i++)
#define rep1(i, x) for(long i = 0; i < x; i++)
#define rep2(i, x) for(long long i = 0; i < x; i++)
typedef long long i64;
typedef long double ld;
using namespace std;
void bfs(vi* adj, int source, int MAX){
	bool* visited = new bool[MAX];
	for(int i = 0; i < MAX; i++){
		visited[i] = false;
	}
	queue<int> q;
	visited[source] = true;
	q.push(source);
	while(!q.empty()){
		int current = q.front();
		q.pop();
		cout << current << " ";
		vi::iterator it;
		for(it = adj[source].begin(); it != adj[source].end(); it++){
			if(!visited[*it]){
				visited[*it] = true;
				q.push(*it);
			}
		}
	}
	cout << endl;
	delete[] visited;
}
void addEdge(vi* adj, int source, int destination){
	adj[source].pb(destination);
	adj[destination].pb(source);
}
int main()
{
	#ifndef Imtiaz_Adar 
		freopen("input.txt", "r", stdin);
	#endif
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int MAX;
    cout << "Enter how many nodes : ";
    cin >> MAX;
    vi adj[MAX];
    int edges;
    cin >> edges;
    int source, destination;
    for(int i = 0; i < edges; i++){
    	cin >> source >> destination;
    	cout << "Add Edge : ";
    	addEdge(adj, source, destination);
    }
    int sour;
    cout << "Enter source : ";
    cin >> sour;
    bfs(adj, sour, MAX);
    fflush(stdout);
    return 0-0;
}