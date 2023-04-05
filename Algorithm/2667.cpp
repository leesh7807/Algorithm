#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <string>
#define endl '\n'
using namespace std;

// 정사각형 지도 한 변 N(5~25)
// 집이 있는데 확인한 적이 없다? 새로운 단지.
// 새로운 단지를 저장하는 벡터 하나.
// 한 집에서부터 붙어 있는 집들을 전부 확인하며(BFS) 집 개수 세고 벡터에 밀어넣기.
// 배열 순회 n^2 + 결국 내부적으로 간선 순회하는 회수가 최대로 해봤자 n^2 정도일듯. 2n^2으로 추정.
int main() {
    int n;
    cin >> n;
    string house[n];
    for(int i=0; i<n; i++) {
        cin >> house[i];
    }
    int isCheck[n][n]; // 확인했는지 저장하는 배열
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            isCheck[i][j] = 0;
        }
    }
    vector<int> groupSize;
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            if(house[i][j] != '0' && isCheck[i][j] == 0) {
                queue<pair<int, int>> q;
                isCheck[i][j] = 1;
                q.push(make_pair(i, j));
                int houseGroup = 1; // 집 하나 있는 단지.
                while(true) {
                    queue<pair<int, int>> temp;
                    int coordCnt = q.size();
                    for(int k=0; k<coordCnt; k++) {
                        int x = q.front().first;
                        int y = q.front().second;
                        if(x+1 < n && house[x+1][y] == '1' && isCheck[x+1][y] == 0) {
                            houseGroup++;
                            isCheck[x+1][y] = 1;
                            temp.push(make_pair(x+1, y));
                        }
                        if(x-1 >= 0 && house[x-1][y] == '1' && isCheck[x-1][y] == 0) {
                            isCheck[x-1][y] = 1;
                            houseGroup++;
                            temp.push(make_pair(x-1, y));
                        }
                        if(y+1 < n && house[x][y+1] == '1' && isCheck[x][y+1] == 0) {
                            houseGroup++;
                            isCheck[x][y+1] = 1;
                            temp.push(make_pair(x, y+1));
                        }
                        if(y-1 >= 0 && house[x][y-1] == '1' && isCheck[x][y-1] == 0) {
                            houseGroup++;
                            isCheck[x][y-1] = 1;
                            temp.push(make_pair(x, y-1));
                        }
                        q.pop();
                    }
                    q = temp;
                    if(q.empty()) break;
                }
                groupSize.push_back(houseGroup);
            }
        }
    }
    sort(groupSize.begin(), groupSize.end());
    cout << groupSize.size() << endl;
    for(int i=0; i<groupSize.size(); i++) {
        cout << groupSize.at(i) << endl;
    }
    
    return 0;
}