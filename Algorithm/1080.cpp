#include <iostream>
using namespace std;

int main() {
    int N, M;
    cin >> N >> M;
    char A[N+1][M+1], B[N+1][M+1]; // \0을 고려해서 +1. 컴파일러에 따라서 안해줘도 잘 작동하지만 위험하다. 
    // 입력 받기
    for(int i = 0; i < N; i++) {
        cin >> A[i];
    }
    for(int i = 0; i < N; i++) {
        cin >> B[i];
    }
    // 행 또는 열이 3보다 작으면 두 행렬이 같은지 확인 다르면 -1 아니면 0 출력 후 리턴
    if(N < 3 || M < 3) { 
        for(int i = 0; i < N; i++) {
            for(int j= 0; j < M; j++) {
                if(A[i][j] != B[i][j]) { cout << -1; return 0; }
            }
        }
        cout << 0; return 0;
    } 

    // 3X3 부분 행렬의 (0+i, 0+j)를 기준으로 (2+i, 2+j)까지 뒤집는 것으로 가정.
    // nXm 행렬을 훑을 때 (i, j)를 뒤집지 않으면 임의의 (i+k, j+k)에서 뒤집는 연산을 하여도 (i, j)는 뒤집히지 않음.
    // 따라서, (i, j)는 무조건 뒤집기를 해야하는 최소 횟수라 가정. 이러한 뒤집기 연산은 (N-2, M-2)까지만 가능하다.
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

    // A와 B 전체 행렬 비교
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            if(A[i][j] != B[i][j]) { cout << -1; return 0; }
        }
    }
    
    cout << count;
    return 0;
}
