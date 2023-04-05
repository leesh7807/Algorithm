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
// ��ǻ���� ��(1~100), ��Ʈ��ũ ����, ��ȣ ���� ��ȣ��.
int main() {
    int computerCnt, e; // ��ǻ�� ��, ��Ʈ��ũ ����
    cin >> computerCnt >> e;
    vector<pair<int, int>> net; // ���� ����
    for(int i=0; i<e; i++) {
        int temp1, temp2;
        cin >> temp1 >> temp2;
        net.push_back(make_pair(temp1, temp2));
        net.push_back(make_pair(temp2, temp1)); // ��ȣ ����.
    }
    sort(net.begin(), net.end(), compare); 
    int ans = 0;
    int infestedCom[computerCnt+1] = {0,}; // ������ ��ǻ��
    infestedCom[1] = 1; // ���� ������ 1�� ��ǻ��
    queue<int> bfsQ;
    bfsQ.push(1);
    while(true) {
        vector<pair<int, int>>::iterator iter = lower_bound(net.begin(), net.end(), bfsQ.front(), departCompare); // net ���͸� �տ��� ���� Ž��, bfsQ.first �̻��� ������ iterator ��ȯ. 
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