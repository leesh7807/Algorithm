#include <iostream>
using namespace std;

// 1의 자리 숫자가 곧 정답
int main() {
    int T, a, b;
    cin >> T;
    for(int i = 0; i < T; i++) {
        cin >> a >> b;
        int ans = a;
        for(int j = 1; j < b; j++) { // 1일 때는 ans 그대로. b - 1만큼 a를 ans에 곱해준다.
            ans *= a;
            ans %= 10; // 제곱을 그냥 하면 int 범위를 벗어날 것이라 판단. 1의 자리만 남김.
        }
        ans %= 10; // b가 1일 때 반복문에 들어가지 않아 나머지 연산을 하지 않고 ans가 나옴.
        if(ans== 0) { cout << 10 << endl; } // 1의 자리가 0이면 10번 컴퓨터
        else { cout << ans << endl; }
    }
    return 0;
}