#include <iostream>
using namespace std;

// 계수 정렬 사용할거임 
int main() {
    int arr[1001] = {0,};
    int n;
    cin >> n;
    int time;
    for(int i = 0; i < n; i++) {
        cin >> time;
        arr[time]++;
    }
    int sort[n];
    int count = 0;
    for(int i = 1; i < 1001; i++) {
        if(arr[i] > 0) {
            arr[i]--;
            sort[count] = i;
            count++;
            i--;
        }
    }
    int ans = 0;
    for(int i = 0; i < n; i++) {
        ans += sort[i] * (n - i);
    }
    cout << ans;
    return 0;
}