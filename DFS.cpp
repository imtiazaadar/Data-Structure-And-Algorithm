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
void dfsUtil(vi* adj, bool visited[], int source){
	visited[source] = true;
	cout << source << " ";
	vi::iterator it;
	for(it = adj[source].begin(); it != adj[source].end(); it++){
		if(!visited[*it]){
			dfsUtil(adj, visited, *it);
		}
	}
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
    bool* visited = new bool[MAX];
    int edges;
    cin >> edges;
    int source, destination;
    for(int i = 0; i < edges; i++){
    	cin >> source >> destination;
    	cout << "Add Edge : ";
    	addEdge(adj, source, destination);
    }
    dfsUtil(adj, visited, 0);
    delete[] visited;
    fflush(stdout);
    return 0-0;
}