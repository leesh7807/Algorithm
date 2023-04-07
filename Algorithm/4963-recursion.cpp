#include <iostream>
#include <algorithm>
#include <vector>
#define endl '\n'
using namespace std;

int w, h; // 1 ~ 50
bool arr[50][50];
bool isVisited[50][50];
int dx[8] = {-1, 0, 1, 0, 1, 1, -1, -1};
int dy[8] = {0, 1, 0, -1, 1, -1, 1, -1};
void DFS(int x, int y) {
    isVisited[x][y] = true;
    for(int i=0; i<8; i++) {
        int n = x + dx[i];
        int m = y + dy[i];
        if(n >= 0 && n < w && m >= 0 && m < h) {
            if(arr[n][m] && !isVisited[n][m]) {
                DFS(n, m);
            }
        }
    }
    return;
};

// 1초, 128MB
int main() {
    while(true) {
        cin >> h >> w; // 열, 행
        if(!h && !w) break; // 0 0 입력 시 정지.
        for(int i=0; i<w; i++) {
            for(int j=0; j<h; j++) {
                cin >> arr[i][j];
                isVisited[i][j] = false;
            }
        }
        int island = 0;
        for(int i=0; i<w; i++) {
            for(int j=0; j<h; j++) {
                if(arr[i][j] && !isVisited[i][j]) {
                    DFS(i, j);
                    island++;
                }
            }
        }
        cout << island << endl;
    }
    return 0;
}