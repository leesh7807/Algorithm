#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#define endl '\n'
using namespace std;
bool compare(pair<int, int> n1, pair<int, int> n2) {
    if(n1.first == n2.first) return n1.second < n2.second;
    return n1.first < n2.first;
}
bool departCompare(const pair<int, int> &n1, const int &n2) { // Comp(ForwardIterator, value) https://cplusplus.com/reference/algorithm/lower_bound/
    return n1.first < n2;
}
// 컴퓨터의 수(1~100), 네트워크 간선, 상호 연결 번호쌍.
int main() {
    int computerCnt, e; // 컴퓨터 수, 네트워크 간선
    cin >> computerCnt >> e;
    vector<pair<int, int>> net; // 간선 벡터
    for(int i=0; i<e; i++) {
        int temp1, temp2;
        cin >> temp1 >> temp2;
        net.push_back(make_pair(temp1, temp2));
        net.push_back(make_pair(temp2, temp1)); // 상호 연결.
    }
    sort(net.begin(), net.end(), compare); 
    int ans = 0;
    int infestedCom[computerCnt+1] = {0,}; // 감염된 컴퓨터
    infestedCom[1] = 1; // 최초 감염된 1번 컴퓨터
    queue<int> bfsQ;
    bfsQ.push(1);
    while(true) {
        vector<pair<int, int>>::iterator iter = lower_bound(net.begin(), net.end(), bfsQ.front(), departCompare); // net 벡터를 앞에서 부터 탐색, bfsQ.first 이상인 최초의 iterator 반환. 
        while(iter->first == bfsQ.front()) {
            if(!infestedCom[iter->second]) {
                infestedCom[iter->second] = 1;
                bfsQ.push(iter->second);
                ans++;
            }
            iter++;
        }
        bfsQ.pop();
        if(bfsQ.empty()) break;
    }
    cout << ans << endl;
    return 0;
}