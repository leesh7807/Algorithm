#include <iostream>
using namespace std;

int main() {
    int L, R;
    cin >> L >> R;
    int i = L;
    
    while(i <= R) {
        if(i % 10 != 8) { i /= 10; R /= 10; } // 1의 자리가 8이 아니면 1의 자리를 날린다.
        i++;
    }
    int result = i - 1;
    int eightCount = 0;
    while(result != 0) {
        if(result % 10 == 8) { eightCount++; }
        result /= 10;
    }
    cout << eightCount;
    return 0;
}