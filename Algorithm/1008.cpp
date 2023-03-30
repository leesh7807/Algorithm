#include <iostream>
using namespace std;

int main() {
    int A, B;
    cin >> A >> B;
    double ans = (double)A/B;
    cout.precision(10);
    cout << ans;
    return 0;
}