#include <iostream>
using namespace std;

int main() {
    int arr[31] = {0,};
    int n;
    for(int i = 1; i < 29; i++) {
        cin >> n;
        arr[n] = 1;
    }
    for(int i = 1; i < 31; i++) {
        if(arr[i] == 0) {
            cout << i << '\n';
        }
    }
    return 0;
}