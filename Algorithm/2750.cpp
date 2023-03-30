#include <iostream>
using namespace std;
// 계수 정렬
int main() {
    int arr[2001] = {0,};
    int N;
    cin >> N;
    int num;
    for(int i = 0; i < N; i++) {
        cin >> num;
        arr[num+1000] = 1;
    }
    for(int i = 0; i < 2001; i++) {
        if(arr[i] == 1) {
            cout << i - 1000 << '\n';
        }
    }
    return 0;
}