#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <string>
#define endl '\n'
using namespace std;

// n, m 행렬 미로. n과 m은 2에서 100 사이. 최대 1000개니까 n^2 가능.
// 미로를 전수 조사 해야되니까 bfs를 써야하지 않을까 추측.
// 현재 위치에서 행 또는 열이 1 차이나면 이동 가능한 위치. 
// 오른쪽, 왼쪽, 아래, 위 순서로 이동을 시도. 이동 성공하면 그 위치를 큐에 저장.
// 이런 식으로 계속해서 펼치면 반복한 횟수가 곧 거리가 됨. 처음으로 n, m에 도달하는데 성공한 것이 최단거리.
int main() {
    int n, m;
    cin >> n >> m;
    string arr[n];
    for(int i=0; i<n; i++) {
        cin >> arr[i];
    }
    int visited[n][m];
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            visited[i][j] = 0;
        }
    }
    visited[0][0] = 1;
    int distance = 1; // 첫 한칸도 거리에 포함
    pair<int, int> pos(0, 0);
    queue<pair<int, int>> q; // BFS큐
    q.push(pos); // 시작 지점이 들어가 있는 큐.
    // 현재 위치에서 이동할 수 있는 놈들 전부 큐로. 그 큐에서 꺼내면서 이동할 수 있는 좌표들을 또 전부 큐로.
    // 큐에서 한 번 전부 다 꺼내면, 그게 거리 한 칸.
    while(true) {
        queue<pair<int, int>> temp;
        int coordCnt = q.size(); // BFS큐의 좌표 개수
        for(int i=0; i<coordCnt; i++) { // 임시 큐에 BFS큐의 좌표들에서 이동 가능한 좌표 전부 넣기.
            int x = q.front().first;
            int y = q.front().second;
            if(x == n-1 && y == m-1) {
                cout << distance << endl;
                return 0;
            }
            if(y+1 < m && visited[x][y+1] == 0 && arr[x][y+1] == '1') {
                visited[x][y+1] = 1;
                temp.push(make_pair(x, y+1));
            }
            if(y-1 >= 0 && visited[x][y-1] == 0 && arr[x][y-1] == '1') {
                visited[x][y-1] = 1;
                temp.push(make_pair(x, y-1));
            }
            if(x+1 < n && visited[x+1][y] == 0 && arr[x+1][y] == '1') {
                visited[x+1][y] = 1;
                temp.push(make_pair(x+1, y));
            }
            if(x-1 >= 0 && visited[x-1][y] == 0 && arr[x-1][y] == '1') {
                visited[x-1][y] = 1;
                temp.push(make_pair(x-1, y));
            }
            q.pop();
        }
        q = temp; // BFS큐에 임시 큐를 저장.
        distance++;
    }
    return -1;
}