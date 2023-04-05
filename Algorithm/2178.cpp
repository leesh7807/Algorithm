#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <string>
#include <tuple>
#define endl '\n'
using namespace std;

// n, m 행렬 미로. n과 m은 2에서 100 사이. 최대 1000개니까 n^2 가능.
// 미로를 전수 조사 해야되니까 bfs를 써야하지 않을까 추측.
// 현재 위치에서 행 또는 열이 1 차이나면 이동 가능한 위치. 
// 오, 아, 위, 왼 순서로 이동을 시도. 이동 성공하면 그 위치를 큐에 저장.
// 시작 지점에서 이동한 거리 
int main() {
    int n, m;
    cin >> n >> m;
    string arr[n];
    for(int i=0; i<n; i++) {
        cin >> arr[i];
    }
    int visited[n][m] = {0,};
    visited[0][0] = 1;
    return 0;
}