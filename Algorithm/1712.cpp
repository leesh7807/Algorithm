#include <iostream>
using namespace std;
int main() {
    int A, B, C, x = 0;
    cin >> A >> B >> C;
    if(B >= C) {
        cout << -1;
    }
    else {
        while(x <= A/(C-B)) {
            x++;
        }
        cout << x;
    }
}