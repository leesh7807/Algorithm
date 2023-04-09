#include <iostream>
#include <algorithm>
#include <vector>
#define endl '\n'
using namespace std;
bool arr[1001000] = {false,};
// log1조는 40으로 일반적으로 40번 안에 소인수분해가 끝날 것.
bool Factorization(long long int n) {
    int i= 2;
    do {
        int cnt = 0;
        while(n%i == 0) {
            for(int j=1; i*j<1001000; j++) {
                arr[i*j] = true; 
            }
            n /= i;
            cnt++;
        }
        if(cnt > 1) return false; // 제곱ㄴㄴ수가 아니다.
        for(int j=2; j<1001000; j++) {
            if(!arr[j]) i = j;
        }
    } while(n>1);
    return true; // 제곱ㄴㄴ수가 맞다.
};
// 2초 512MB
// 소인수분해 했을 때, 제곱인 것이 없으면 제곱ㄴㄴ수
// 범위 내 제곱ㄴㄴ수
// 소인수분해는 logn으로 줄어들 것. log1조 = 40. 40*백만= 사천만
int main() {
    long long int min, max; // 1조, 1조+백만
    cin >> min >> max;
    int ans = 0;
    for(long long int i = min; i<=max; i++) { // 백만번
        if(Factorization(i)) ans++;
    }
    cout << ans;
    return 0;
}