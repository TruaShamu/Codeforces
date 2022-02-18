#include <bits/stdc++.h>
using namespace std;
using vi = vector<int>;

#define pb push_back
vector<vi> adj;
vector<int> dist;
vector<int> ans;
vector<bool> visited;

// BFS for the distance.
void findDist() {
  dist[1] = 0;
  queue<int> q;
  q.push(1);
  while (!q.empty()) {
     int cur = q.front();
     q.pop();
     for (int next : adj[cur]) {
        if (dist[next] == -1) {
           dist[next] = dist[cur] + 1;
           q.push(next);
        }
     }
  }
}
// DFS for individual sol
void dfs(int cur) {
  visited[cur] = true;
  ans[cur] = dist[cur];
  for (int next : adj[cur]) {
     if (!visited[next] && dist[cur] < dist[next]) {
        dfs(next);
     }
     if (dist[cur] < dist[next]) {
        ans[cur] = min(ans[cur], ans[next]);
     } else {
        ans[cur] = min(ans[cur], dist[next]);
     }
  }
}

void solve() {
  int N, M;
  cin >> N >> M;
  adj.resize(N + 1);
  dist.resize(N + 1);
  ans.resize(N + 1);
  visited.resize(N + 1);

  for (int i = 0; i <= N; i++) {
     adj[i].clear();
     dist[i] = -1;
     visited[i] = false;
  }

  for (int i = 0; i < M; i++) {
     int a, b;
     cin >> a >> b;
     adj[a].pb(b);
  }
  findDist();
  dfs(1);
  for (int i = 1; i <= N; i++) {
     cout << ans[i] << " ";
  }
  cout << "\n";
}

int main() {
  int tc;
  cin >> tc;
  while (tc-- > 0) {
     solve();
  }
}
