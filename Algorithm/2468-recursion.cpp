#include <iostream>
#include <algorithm>
#include <vector>
#define endl '\n'
using namespace std;

// 1�� 128MB �ѱ� �����ø��ǾƵ� 2010�� �ʵ�ι����ε�? �� �߿� ���� �����
int n; // 2~100
bool isVisited[100][100];
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};
void DFS(int x1, int y1, vector<vector<bool>> &arr) {
    isVisited[x1][y1] = true;
    for(int i=0; i<4; i++) {
        int x2 = x1 + dx[i];
        int y2 = y1 + dy[i];
        if(x2 >= 0 && x2 < n && y2 >= 0 && y2 < n && arr[x2][y2] && !isVisited[x2][y2]) {
            DFS(x2, y2, arr);
        }
    }
    return;
};

int main() {
    cin >> n;
    int area[n][n]; // 1~100
    int maxH = 0;
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            int temp;
            cin >> temp;
            area[i][j] = temp;
            maxH = max(maxH, temp);
        }
    }
    int safeMax = 0;
    for(int h=0; h<maxH; h++) { // ������ �ִ���� �Ǹ� �� ����.
        vector<vector<bool>> safe;
        safe.assign(n, vector<bool>(n, false));
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(area[i][j] > h) safe[i][j] = true;
                else safe[i][j] = false;
                isVisited[i][j] = false;
            }
        }
        
        int tempRes = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(safe[i][j] && !isVisited[i][j]) {
                    DFS(i, j, safe);
                    tempRes++;
                }
            }
        }
        safeMax = max(tempRes, safeMax);
    }
    cout << safeMax << endl;
    return 0;
}