#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
#define endl '\n'
using namespace std;

// n과 m은 500000개. nlogn 정도 써야할듯. n과 m에서 같은 이름 찾아서 출력.
// 둘 다 사전 순으로 정렬 해두기.
// 비교 한 후에 사전 순으로 더 앞에 있는 단어만 플러스. 그러다 하나가 범위 벗어나면 스탑.
int main() {
    int n, m;
    cin >> n >> m;
    string a[n], b[m];
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }
    for(int i = 0; i < m; i++) {
        cin >> b[i];
    }
    sort(a, a+n);
    sort(b, b+m);
    vector<string> ans;
    int nPos = 0, mPos = 0;
    while(true) {
        if(mPos >= m || nPos >= n) break;
        if(a[nPos] == b[mPos]) {
            ans.push_back(a[nPos]);
            mPos++;
            nPos++;
            
        }
        else if(a[nPos] > b[mPos]) {
            mPos++;
        }
        else if(a[nPos] < b[mPos]) {
            nPos++;
        }
        else break;        
    }
    cout << ans.size() << endl;
    for(int i = 0; i < ans.size(); i++) {
        cout << ans.at(i) << endl;
    }
}