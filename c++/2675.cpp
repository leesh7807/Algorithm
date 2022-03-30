#include <iostream>
#include <cstring>
using namespace std;
int main() {
    int T, R;
    char S[21];
    cin >> T;
    for(int i = 0; i < T; i++) {
        cin >> R;
        cin >> S;
        for(int j = 0; j < strlen(S); j++){
            for(int k = 0; k < R; k++) {
                cout << S[j];
            }
        }
        cout << '\n';
    }
}