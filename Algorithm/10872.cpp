#include <iostream>
using namespace std;

int main() {
    int n = 1;
    int k;
    cin >> k;
    for(int i = 2; i <= k; i++) {
        n *= i;
    }
    cout << n;
    return 0;
}