#include <iostream>
using namespace std;
int main() {
    int n , sum = 0;
    cin >> n;
    char input[n];
    cin >> input;
    for(int i = 0; i < n; i++) {
        sum += ((int)input[i] - 48);
    }
    cout << sum;
}