#include <iostream>
#include <algorithm>
#include <vector>
#define endl '\n'
using namespace std;

long long int arr[1000001];
bool prime[1000001];

// 2초 512MB
// 범위 내 제곱ㄴㄴ수
int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);
    long long int min, max; // 1조, min과 백만차이.
    cin >> min >> max;
    for(int i=2; i<1000001; i++) {
        prime[i] = true;
    }
    for(int i=0; i <= max-min; i++) {
        arr[i] = i+min;
    }
    for(int i=2; i<1000001; i++) { // 소수 찾기
        if(prime[i]) {
            for(int j=i*2; j<1000001; j+=i) {
                prime[j] = false;
            }
        }
    }
    for(long long int i=2; i*i <= max; i++) {
        if(prime[i]) {
            if(min%(i*i) == 0) {
                for(long long int j=0; j <= max-min; j += i*i) {
                    arr[j] = 0;
                }
            }
            else {
                // 특정 제곱으로 나눠지는지 확인하기 위해 범위를 다 확인할 필요가 없다.
                // ex) 30/4 = 7.xxx.     7*4 + 4 = 32가 범위 내의 최초 값. 이 값부터 배수들을 전부 제거하면 된다.
                // 1부터 1000000까지 70000개 이상의 소수 중 200개만 전수 조사하더라도 2억번의 연산이 들어간다.
                for(long long int j = (min/(i*i) + 1) * (i*i) - min; j <= max-min; j += i*i) {
                    arr[j] = 0;
                }
            }
        }
    }
    int ans = 0;
    for(int i=0; i <= max-min; i++) {
        if(arr[i]) ans++;
    }

    cout << ans;
    return 0;
}