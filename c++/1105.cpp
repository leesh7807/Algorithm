#include <iostream>
using namespace std;

int main() {
    int L, R;
    cin >> L >> R;
    int i = L;
    
    while(i <= R) {
        if(i % 10 != 8) { i /= 10; R /= 10; } // 1�� �ڸ��� 8�� �ƴϸ� 1�� �ڸ��� ������.
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