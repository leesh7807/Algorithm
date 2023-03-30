#include <iostream>
using namespace std;

int main() {
    int n;
    int ans = 0;
    for(int i = 0; i < 5; i++) {
        cin >> n;
        ans += (n * n);
    }
    cout << ans % 10;
    return 0;
}