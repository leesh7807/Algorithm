#include <iostream>
#include <algorithm>
#include <vector>
#define endl '\n'
using namespace std;

// 테스트 케이스 최대 20개니까 무시.
// n은 십만까지. 2초. nlogn이하로. 메모리 제한 256MB
// 다른 모두에 비해 두 성적 중 하나라도 잘나야 한다. 
// 서류나 면접 중에 1등이 있으면 무조건 채용.
// 서류 성적 순으로 나열하고, 자기 위에 등수랑 면접 등수만 비교하면 되지 않나?
// (1, 4) (2, 5) (3, 3) (4, 1), (5, 2). 자기 앞 중에 면접 등수 제일 잘난 애랑 비교해야함.
// 서류 자기보다 앞 순위인 애들 중에 면접 제일 잘한 애보다 면접 더 잘했으면 된다. 

bool compare(pair<int, int> n1, pair<int, int> n2) {
    return n1.first < n2.first;
}
int main() {
    int T;
    cin >> T;
    for(int i=0; i<T; i++) {
        int n;
        cin >> n;
        vector<pair<int, int>> arr;
        for(int i=0; i<n; i++) {
            int first, second;
            cin >> first >> second;
            arr.push_back(make_pair(first, second));
        }
        sort(arr.begin(), arr.end(), compare);
        int ans = 1; // 서류 1등
        int meetingGood = arr.at(0).second; // 앞 순위 중 면접 제일 잘한 애
        for(int i=1; i<n; i++) {
            if(meetingGood > arr.at(i).second) {
                meetingGood = arr.at(i).second;
                ans++;
            }
        }
        cout << ans << endl;
    }
    return 0;
}