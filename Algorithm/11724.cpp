#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#define endl '\n'
using namespace std;

// 시간 제한 3초, 메모리 제한 512MB

bool compare(pair<int, int> n1, pair<int, int> n2) {
    if(n1.first == n2.first) return n1.second < n2.second;
    return n1.first < n2.first;
}
bool pairValueCompare(const pair<int, int> &n1, const int &n2) {
    return n1.first < n2;
}
int main() {
    int v, e; // 정점, 간선의 개수
    cin >> v >> e;
    vector<pair<int, int>> edge; // 실제 간선 저장 벡터.
    for(int i=0; i<e; i++) {
        int temp1, temp2;
        cin >> temp1 >> temp2;
        edge.push_back(make_pair(temp1, temp2));
        edge.push_back(make_pair(temp2, temp1)); // 방향 없는 그래프이므로 양방향으로 추가.
    }
    sort(edge.begin(), edge.end(), compare);
    bool isVisited[v+1] = {0,}; // 1~v번 정점을 false으로 초기화.
    stack<int> stackDFS;
    int ans = 0; // 연결 요소 
    while(true) {
        for(int i=1; i<=v; i++) {
            if(!isVisited[i]) { // 방문하지 않은 곳이 있으면 그 곳부터 다시 DFS. 연결요소 +1.
                isVisited[i] = true;
                stackDFS.push(i);
                ans++;
                break;
            }
        }
        if(stackDFS.empty()) { // 방문하지 않은 곳이 없다 => 스탑.
            break;
        }
        while(!stackDFS.empty()) { // DFS
            vector<pair<int, int>>::iterator it = lower_bound(edge.begin(), edge.end(), stackDFS.top(), pairValueCompare);
            while(true) {
                if(it >= edge.end() || it->first != stackDFS.top()) {
                    stackDFS.pop();
                    break;
                }
                if(it->first == stackDFS.top() && !isVisited[it->second]) {
                    isVisited[it->second] = true;
                    stackDFS.push(it->second);
                    break;
                }
                it++;
            }
        }
    }
    cout << ans << endl; // 정답 연결 요소의 개수 출력.
    return 0;
}