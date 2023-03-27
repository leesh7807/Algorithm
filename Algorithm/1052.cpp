#include <iostream>
using namespace std;

int main() {
    int N, K;
    int buy = -1;
    cin >> N >> K;
    int stand, count;
    do {
        stand = 0B1000000000000000000000000;
        count = 0;
        buy++;
        for(int i = 0; i < 25; i++) {
            if(N & stand) {
                count++;
            }  
            stand >>= 1;
        }
        N++;
    } while( count > K );
    cout << buy;
    return 0;
}