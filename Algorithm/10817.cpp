#include <iostream>
using namespace std;

// 부등호 대신에 계수 정렬했음.
int main() {
    int arr[100] = {0,};
    int a, b, c;
    
    cin >> a >> b >> c;
    arr[a] += 1;
    arr[b] += 1;
    arr[c] += 1;
    int count = 0;
    for(int i = 0; i < 100; i++) {
        if(arr[i] > 0) {
            if(count == 1) { cout << i; break;}
            count++;
            arr[i] -= 1;
            i--;
        }
    }
    return 0;
}