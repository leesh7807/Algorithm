#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
#define endl '\n'
using namespace std;

// 1초, 128MB
int main() {
    while(true) {
        int w, h; // 1 ~ 50
        cin >> h >> w; // 열, 행
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
                    while(!stackDFS.empty()) { // 주변 8칸에 대해 갈 수 있는 곳 찾는 DFS.
                        int x = stackDFS.top().first;
                        int y = stackDFS.top().second;
                        bool flag = false; // 2중 반복문을 빠져 나온 뒤 바로 while문을 continue하기 위한 플래그
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