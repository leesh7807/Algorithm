#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#define endl '\n'
using namespace std;

// 배열에서 뭉쳐있는 1 집단이 몇 개 있는지 찾는 문제.
int main() {
    int T; // 테스트 케이스
    cin >> T;
    for(int t=0; t<T; t++) {
        int n, m, k; // 가로 길이(<=50) 세로 길이(<=50) 배추 개수(<=2500)
        cin >> n >> m >> k;
        int field[n][m]; // 배추 밭
        int isChecked[n][m]; // BFS 방문 기록
        for(int i=0; i<n; i++) { 
            for(int j=0; j<m; j++) {
                field[i][j] = 0;
                isChecked[i][j] = 0;
            }
        }
        for(int i=0; i<k; i++) { // 배추 심은 좌표 받기
            int tempX, tempY;
            cin >> tempX >> tempY;
            field[tempX][tempY] = 1;
        }
        int cabbageGroup = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(field[i][j] && !isChecked[i][j]) { // 배추 있는데 BFS탐색 안한 곳.
                    cabbageGroup++;
                    queue<pair<int, int>> q;
                    q.push(make_pair(i, j)); 
                    while(!q.empty()) {
                        int x = q.front().first;
                        int y = q.front().second;
                        if(x + 1 < n && field[x+1][y] && !isChecked[x+1][y]) {
                            isChecked[x+1][y] = 1;
                            q.push(make_pair(x+1, y));
                        }
                        if(y + 1 < m && field[x][y+1] && !isChecked[x][y+1]) {
                            isChecked[x][y+1] = 1;
                            q.push(make_pair(x, y+1));
                        }
                        if(x - 1 >= 0 && field[x-1][y] && !isChecked[x-1][y]) {
                            isChecked[x-1][y] = 1;
                            q.push(make_pair(x-1, y));
                        }
                        if(y - 1 >= 0 && field[x][y-1] && !isChecked[x][y-1]) {
                            isChecked[x][y-1] = 1;
                            q.push(make_pair(x, y-1));
                        }
                        q.pop();
                    }
                }
            }
        }
        cout << cabbageGroup << endl;
    }
    return 0;
}