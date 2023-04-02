#include <iostream>
#include <vector>
#include <algorithm>
#define endl '\n'
using namespace std;

// 배열 안의 원소에 대한 조작. 원소의 값을 자기 미만의 서로 다른 원소 개수로 바꾸는 문제.
// n은 백만개. nlogn 이하로. 원소로 들어오는 값은 -10억에서 10억. 메모리는 512MB
// 다른 벡터에 넣고 정렬, 중복제거. 순환하면서 벡터에서 원소 찾아 값 넣으면, n^2이니까 터지고. 
// 한 번의 순환에 다 찾을 수 있게, 원소도 정렬해두고 비교하면서 찾기
// 다시 원래대로 돌려야 되니까, 2차원 배열로 만들어서 자기 원래 위치 기록해두기
bool compare(pair<int, int> n1, pair<int, int> n2) {
    return n1.first < n2.first;
}
int main() {
    int n;
    cin >> n;
    vector<pair<int, int>> arr;
    vector<int> noDup;
    for(int i = 0; i < n; i++) {
        int temp;
        cin >> temp;
        arr.push_back(make_pair(temp, i));
        noDup.push_back(temp);
    }
    sort(arr.begin(), arr.end());
    sort(noDup.begin(), noDup.end());
    unique(noDup.begin(), noDup.end());

    int noDupIter = 0;
    for(int i = 0; i < arr.size(); i++) {
        while(arr.at(i).first != noDup.at(noDupIter)) noDupIter++;
        arr.at(i).first = noDupIter;
    }
    int ans[n];
    for(int i = 0; i < n; i++) {
        ans[arr.at(i).second] = arr.at(i).first;
    }
    for(int i = 0; i < n; i++) {
        cout << ans[i] << ' ';
    }
}