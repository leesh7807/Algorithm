#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
#define endl '\n'
using namespace std;

// 1��, 128MB
int main() {
    while(true) {
        int w, h; // 1 ~ 50
        cin >> h >> w; // ��, ��
        if(!h && !w) break;
        bool arr[w][h];
        bool isVis[w][h];
        stack<pair<int, int>> stackDFS;
        for(int i=0; i<w; i++) {
            for(int j=0; j<h; j++) {
                cin >> arr[i][j];
                isVis[i][j] = false;
            }
        }
        int island = 0;
        for(int i=0; i<w; i++) {
            for(int j=0; j<h; j++) {
                if(arr[i][j] && !isVis[i][j]) {
                    stackDFS.push(make_pair(i, j));
                    isVis[i][j] = true;
                    while(!stackDFS.empty()) { // �ֺ� 8ĭ�� ���� �� �� �ִ� �� ã�� DFS.
                        int x = stackDFS.top().first;
                        int y = stackDFS.top().second;
                        bool flag = false; // 2�� �ݺ����� ���� ���� �� �ٷ� while���� continue�ϱ� ���� �÷���
                        for(int i=x-1; i<=x+1; i++) {
                            for(int j=y-1; j<=y+1; j++) {
                                if(i>=0 && i<w && j>=0 && j<h && !(i==x && j==y)) {
                                    if(arr[i][j] && !isVis[i][j]) {
                                        stackDFS.push(make_pair(i, j));
                                        isVis[i][j] = true;
                                        flag = true;
                                        break;
                                    }
                                }
                            }
                            if(flag) break;
                        }
                        if(flag) continue;
                        stackDFS.pop();
                    }
                    island++;
                }
            }
        }
        cout << island << endl;
    }
    return 0;
}