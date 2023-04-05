#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
#include <queue>
#define endl '\n'
using namespace std;

// 정점 v에서 출발하는 간선을 찾을 때 단순 순회로 O(n)으로 처리.
// 정점 v를 binary_search로 찾으면 n^2에서 nlogn으로 시간복잡도를 줄일 수 있을 듯.
// pair에 대해 binary_search 적용 시키는 법.
// https://www.tutorialspoint.com/binary-search-in-sorted-vector-of-pairs-in-cplusplus

bool compare(pair<int, int> n1, pair<int, int> n2) {
    if(n1.first == n2.first) return n1.second < n2.second;
    return n1.first < n2.first;
}
int main() {
    int n, m, v;
    cin >> n >> m >> v;
    vector<pair<int, int>> arr;
    for(int i=0; i<m; i++) {
        int temp1, temp2;
        cin >> temp1 >> temp2;
        arr.push_back(make_pair(temp1, temp2));
        arr.push_back(make_pair(temp2, temp1)); // 간선이 양방향이므로, 양쪽으로 추가.
    }
    sort(arr.begin(), arr.end(), compare); // 가능하면 작은 정점부터 조사해야하므로 정렬.
    
    // DFS
    vector<int> dfsAns; // 방문한 순서를 기록할 벡터
    int visitedByDFS[n+1] = {0,}; // 방문 기록을 저장하는 배열
    stack<int> DFSstack; // DFS 구현 스택 
    int pos = v; // 현재 정점의 위치.
    visitedByDFS[pos] = 1; // 시작 위치 초기화
    DFSstack.push(pos); // 시작 위치를 스택에 입력
    dfsAns.push_back(pos); // 최초 방문지를 시작 장소로
    int dfsIter = 0; // DFS 반복자.
    while(true) {
        if((arr.at(dfsIter).first == pos) && (visitedByDFS[arr.at(dfsIter).second] == 0)) { // 간선의 시작지 = 현재 위치 & 목적지 방문 x
            pos = arr.at(dfsIter).second; // 현재 위치를 목적지로 옮김
            visitedByDFS[pos] = 1; // 방문 기록
            DFSstack.push(pos); // DFS 스택에 추가
            dfsAns.push_back(pos); // 방문 순서 추가
            dfsIter = 0; // 다시 목적지에서 도달 할 수 있는 곳 찾기
            continue;
        }
        if(dfsIter >= 2*m-1 || arr.at(dfsIter).first > pos) { // 간선을 모두 찾아봤거나 더 이상 현재 위치와 같은 출발지가 없음을 확인
            DFSstack.pop(); // 현재 방문중인 곳을 스택에서 제거
            if(DFSstack.empty()) break; // 그랬을 때 스택이 비었다면 스탑.
            pos = DFSstack.top(); // 이전에 방문했던 곳에 대해 다른 간선이 있는지 조사
            dfsIter = 0;
            continue;
        }
        dfsIter++;
    }
    for(int i=0; i<dfsAns.size(); i++) {
        cout << dfsAns.at(i) << ' ';
    }
    cout << endl;

    // BFS
    vector<int> ansBFS;
    int visitedByBFS[n+1] = {0,};
    queue<int> queueBFS;
    pos = v;
    ansBFS.push_back(pos);
    visitedByBFS[pos] = 1;
    queueBFS.push(pos);
    int iterBFS = 0;
    while(true) {
        if(arr.at(iterBFS).first == pos && visitedByBFS[arr.at(iterBFS).second] == 0) {
            int temp = arr.at(iterBFS).second;
            ansBFS.push_back(temp);
            visitedByBFS[temp] = 1;
            queueBFS.push(temp); // 현재 위치에서 갈 수 있는 곳 모두 찾기
        }
        if(iterBFS >= 2*m-1 || arr.at(iterBFS).first > pos) { // 간선을 모두 찾아봤거나 더 이상 현재 위치와 같은 출발지가 없음을 확인
            queueBFS.pop(); // 큐에서 현재 위치를 제거
            if(queueBFS.empty()) break; // 큐가 비었다면 중단
            pos = queueBFS.front(); // 가장 먼저 조회했던 목적지에서 갈 수 있는 곳이 있는지 조사
            iterBFS = 0;
            continue;
        }
        iterBFS++;
    }
    for(int i=0; i<ansBFS.size(); i++) {
        cout << ansBFS.at(i) << ' ';
    }
    return 0;
}