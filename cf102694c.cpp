#include <bits/stdc++.h>
using namespace std;

const int MAXN = 3e5 + 5;
const int LOGN = log2(MAXN) + 1;

int depth[MAXN];
// anc[i][j] is the 2^j-th parent of i.
int anc[MAXN][LOGN];
vector<int> adj[MAXN];

void dfs(int node, int par) {
	anc[node][0] = par;
	depth[node] = depth[anc[node][0]] + 1;
	// initializes binary jumping for the current node.
	for (int i = 1; i < LOGN; i++) {
		anc[node][i] = anc[anc[node][i - 1]][i - 1];
	}
	for (int next : adj[node]) {
		if (next != par) {
			dfs(next, node);
		}
	}
}

// jump(i, j) returns jth ancestor of node i
int jump(int node, int level) {
	for (int i = 0; i < LOGN; i++) {
		if (level & (1 << i)) {
			node = anc[node][i];
		}
	}
	return (node > -1) ? node : 0;
}

// lca(i, j) returns least common ancestor of nodes i and j.
int LCA(int a, int b) {
	if (depth[a] < depth[b]) {
		swap(a, b);
	}
	a = jump(a, depth[a] - depth[b]);
	if (a == b) {
		return a;
	}
	for (int i = LOGN - 1; i >= 0; i--) {
		int newA = anc[a][i];
		int newB = anc[b][i];
		if (newA != newB) {
			a = newA, b = newB;
		}
	}
	return anc[a][0];
}


int main() {
	int N; int Q;
	cin >> N;
	for (int i = 0; i < N - 1; i++) {
		int a; int b;
		cin >> a >> b;
		a--;
		b--;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}

	dfs(0, 0);
	cin >> Q;
	for (int i = 1; i <= Q; i++) {
		int start, end, energy;
		cin >> start >> end >> energy;
		start--;
		end--;
		int lca = LCA(start, end);
		int path1 = depth[start] - depth[lca];
		int path2 = depth[end] - depth[lca];
		int result;
		if (energy <= path1) {
			// moves up from start towards the lca.
			result = jump(start, energy) + 1;
		} else if (energy <= path1 + path2) {
			// moves up from start to the lca, then goes down towards end.
			result = jump(end, path2 - (energy - path1)) + 1;
		} else {
			// reaches the end.
			result = end + 1;
		}
		cout << result << "\n";
	}

}
