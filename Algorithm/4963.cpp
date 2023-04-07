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
        while(true) {
            for(int i=0; i<w; i++) {
                for(int j=0; j<h; j++) {
                    if(arr[i][j] && !isVis[i][j]) {
                        stackDFS.push(make_pair(i, j));
                        isVis[i][j] = true;
                        break;
                    }
                }
                if(!stackDFS.empty()) break;
            }

            if(stackDFS.empty()) break; // 섬 다 찾았으면 스탑.

            while(!stackDFS.empty()) { // 주변 8칸에 대해 갈 수 있는 곳 찾는 DFS.
                int x = stackDFS.top().first;
                int y = stackDFS.top().second;
                if(x-1>=0 && arr[x-1][y] && !isVis[x-1][y]) {
                    stackDFS.push(make_pair(x-1, y));
                    isVis[x-1][y] = true;
                    continue;
                }
                if(x-1>=0 && y+1<h && arr[x-1][y+1] && !isVis[x-1][y+1]) {
                    stackDFS.push(make_pair(x-1, y+1));
                    isVis[x-1][y+1] = true;            
                    continue;
                }
                if(y+1<h && arr[x][y+1] && !isVis[x][y+1]) {
                    stackDFS.push(make_pair(x, y+1));
                    isVis[x][y+1] = true;                  
                    continue;
                }
                if(x+1<w && y+1<h && arr[x+1][y+1] && !isVis[x+1][y+1]) {
                    stackDFS.push(make_pair(x+1, y+1));
                    isVis[x+1][y+1] = true;                
                    continue;
                }
                if(x+1<w && arr[x+1][y] && !isVis[x+1][y]) {
                    stackDFS.push(make_pair(x+1, y));
                    isVis[x+1][y] = true;                   
                    continue;
                }
                if(x+1<w && y-1>=0 && arr[x+1][y-1] && !isVis[x+1][y-1]) {
                    stackDFS.push(make_pair(x+1, y-1));
                    isVis[x+1][y-1] = true;            
                    continue;
                }
                if(y-1>=0 && arr[x][y-1] && !isVis[x][y-1]) {
                    stackDFS.push(make_pair(x, y-1));
                    isVis[x][y-1] = true;                   
                    continue;
                }
                if(x-1>=0 && y-1>=0 && arr[x-1][y-1] && !isVis[x-1][y-1]) {
                    stackDFS.push(make_pair(x-1, y-1));
                    isVis[x-1][y-1] = true;                  
                    continue;
                }
                stackDFS.pop();
            }
            island++;
        }
        cout << island << endl;
    }
    return 0;
}