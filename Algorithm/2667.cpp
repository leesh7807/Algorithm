#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <string>
#define endl '\n'
using namespace std;

// ���簢�� ���� �� �� N(5~25)
// ���� �ִµ� Ȯ���� ���� ����? ���ο� ����.
// ���ο� ������ �����ϴ� ���� �ϳ�.
// �� ���������� �پ� �ִ� ������ ���� Ȯ���ϸ�(BFS) �� ���� ���� ���Ϳ� �о�ֱ�.
// �迭 ��ȸ n^2 + �ᱹ ���������� ���� ��ȸ�ϴ� ȸ���� �ִ�� �غ��� n^2 �����ϵ�. 2n^2���� ����.
int main() {
    int n;
    cin >> n;
    string house[n];
    for(int i=0; i<n; i++) {
        cin >> house[i];
    }
    int isCheck[n][n]; // Ȯ���ߴ��� �����ϴ� �迭
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
                int houseGroup = 1; // �� �ϳ� �ִ� ����.
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