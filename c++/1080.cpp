#include <iostream>
using namespace std;

int main() {
    int N, M;
    cin >> N >> M;
    char A[N][M], B[N][M];
    for(int i = 0; i < N; i++) {
        cin >> A[i];
    }
    for(int i = 0; i < N; i++) {
        cin >> B[i];
    }
    if(N < 3 || M < 3) { 
        for(int i = 0; i < N; i++) {
            for(int j= 0; j < M; j++) {
                if(A[i][j] != B[i][j]) { cout << -1; return 0; }
            }
        }
        cout << 0; return 0;
    } 

    int count = 0;
    for(int i = 0; i < N-2; i++) {
        for(int j = 0; j < M-2; j++) {
            if(A[i][j] != B[i][j]) {
                count ++;
                for(int n = 0; n < 3; n++) {
                    for(int m = 0; m < 3; m++) {
                        if(A[i+n][j+m] == '0') { A[i+n][j+m] = '1';}
                        else { A[i+n][j+m] = '0';}
                    }
                }
            }
        }
    }

    for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            if(A[i][j] != B[i][j]) { cout << -1; return 0; }
        }
    }
    
    cout << count;
    return 0;
}
