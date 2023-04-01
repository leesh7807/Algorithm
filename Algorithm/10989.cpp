#include <iostream>
#define endl '\n'
using namespace std;

// 입력 최대값이 10000이하 자연수 -> 계수 정렬
int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false); // 안해주면 시간초과
    int n;
    cin >> n;
    int arr[10001] = {0,};
    int input;
    for(int i = 0; i < n; i++) {
        cin >> input;
        arr[input]++;
    }   
    for(int i = 1; i < 10001; i++) {
        while(arr[i] > 0) {
            cout << i << endl;
            arr[i]--;
        }
    }
    return 0;
}