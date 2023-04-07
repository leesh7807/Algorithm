#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
#define endl '\n'
using namespace std;

// 1�� 128MB �ѱ� �����ø��ǾƵ� 2010�� �ʵ�ι����ε�? �� �߿� ���� �����
int main() {
    int n; // 2~100
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
        bool safe[n][n]; // ���������� ����ϴ� �迭
        bool isChecked[n][n];
        stack<pair<int, int>> stackDFS;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(area[i][j] > h) safe[i][j] = true;
                else safe[i][j] = false;
                isChecked[i][j] = false;
            }
        }
        int tempCnt = 0;
        while(true) {
            bool flag1 = false;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(safe[i][j] && !isChecked[i][j]) {
                        stackDFS.push(make_pair(i, j));
                        isChecked[i][j] = true;
                        flag1 = true;
                        break;
                    }
                }
                if(flag1) break;
            }

            if(stackDFS.empty()) break;

            while(!stackDFS.empty()) {
                int x = stackDFS.top().first;
                int y = stackDFS.top().second;
                if(x+1 < n && safe[x+1][y] && !isChecked[x+1][y]) {
                    stackDFS.push(make_pair(x+1, y));
                    isChecked[x+1][y] = true;
                    continue;
                }
                if(y+1 < n && safe[x][y+1] && !isChecked[x][y+1]) {
                    stackDFS.push(make_pair(x, y+1));
                    isChecked[x][y+1] = true;
                    continue;
                }
                if(x-1 >= 0 && safe[x-1][y] && !isChecked[x-1][y]) {
                    stackDFS.push(make_pair(x-1, y));
                    isChecked[x-1][y] = true;
                    continue;
                }
                if(y-1 >= 0 && safe[x][y-1] && !isChecked[x][y-1]) {
                    stackDFS.push(make_pair(x, y-1));
                    isChecked[x][y-1] = true;
                    continue;
                }
                stackDFS.pop();
            }
            tempCnt++;
        }
        safeMax = max(tempCnt, safeMax);
    }
    cout << safeMax << endl;
    return 0;
}