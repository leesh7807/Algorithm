#include <iostream>
#include <algorithm>
#include <vector>
#define endl '\n'
using namespace std;

// 최대한 간단하게 정렬할 수 있도록 미리 생각을 정리하고 코딩을 하자.
// 포커스를 정해야 함. 결국 회의가 끝나는 시간을 최대한 당기는 것이 목표.
// 그러니까, 회의 끝나는 시간 정렬을 베이스로 두고, 주변에 조작을 가해야 함.

bool compare(pair<int, int> n1, pair<int, int> n2) {
    if(n1.second == n2.second) {
        return n1.first < n2.first;
    }
    return n1.second < n2.second;
}
int main() {
    int n; 
    cin >> n;
    vector<pair<int, int>> arr;
    for(int i = 0; i < n; i++) {
        int a, b;
        cin >> a >> b;
        arr.push_back(make_pair(a, b));
    }
    sort(arr.begin(), arr.end(), compare);
    vector<pair<int, int>> meeting;
    meeting.push_back(make_pair(arr.at(0).first, arr.at(0).second));
    for(int i = 1; i < n; i++) {
        if(arr.at(i).first < meeting.back().second) continue;
        meeting.push_back(make_pair(arr.at(i).first, arr.at(i).second));
    }
    cout << meeting.size();
    return 0;
}