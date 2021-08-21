#include <bits/stdc++.h>
#include <algorithm>
typedef long long ll;
using namespace std;
#define pii pair<int, int>
#define f first
#define s second
#define mp make_pair
const int MAXN = 1e5 + 3;
const int MAXP = 7;
int N, P, K;
int mod = 1e9 + 7;
ll ind[MAXN];
ll A[MAXN];
ll skill[MAXN][7];

/* DP[i][mask] is the mask strength if we pick players from(0...i).
   The mask is of the player positions.
   If a bit is set, that means this position has been taken,
   if it was not set, then the position is free. */
ll dp[MAXN][(1 << MAXP) + 1]; 

bool sortbysecdesc(const pii& a, const pii& b) {
    return a.s > b.s;
}

/* Because I can't get __builtin_popcount() to work on visual studio */
unsigned int countSetBits(unsigned int n) {
    unsigned int count = 0;
    while (n) {
        count += n & 1;
        n >>= 1;
    }
    return count;
}



int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> P >> K;
   
    memset(dp, -1, sizeof(dp));

    vector<pii> A(N);
    for (int i = 0; i < N; i++) {
        int val; cin >> val;
        A.push_back(mp(i, val));
    }

    /* Skill matrix */
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < P; j++) {
            cin >> skill[i][j];
        }
    }

    /* Sort audience score dsc.*/
    sort(A.begin(), A.end() , sortbysecdesc);

    dp[0][0] = 0;

	for (int i = 1; i <= N; i++) {
		int ind = A[i - 1].f;
		for (int mask = 0; mask < (1 << P); mask++) {
            /* Number of players. */
			int bits = countSetBits(mask);

			int numAud = i - bits - 1;
            /* Try adding it to the audience. */
			if (numAud < K) {
				if (dp[i - 1][mask] != -1) {
					dp[i][mask] = dp[i - 1][mask] + A[i - 1].s;
				}
			}
			else {
				if (dp[i - 1][mask] != -1) {
					dp[i][mask] = dp[i - 1][mask];
				}
			}

			// Try adding the player to the team.
			for (int pos = 0; pos < P; pos++) {
				if ((mask & (1 << pos)) > 0 && (dp[i - 1][mask ^ (1 << pos)]) != -1) {
					dp[i][mask] = max(dp[i][mask], dp[i - 1][mask ^ (1 << pos)] + skill[ind][pos]);
				}
			}
		}
	}
    cout << dp[N][(1 << P) - 1] << "\n";



}


