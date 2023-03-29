#include <iostream>
#include <string>
using namespace std;
// NxM 직사각형. 각 칸에 한 자리 숫자. 꼭짓점에 쓰여 있는 수가 모두 같은 가장 큰 정사각형의 크기.
// N과 M 중 더 작은 숫자부터 한 변의 길이로 설정하고 변 길이 줄여가며 모든 경우의 수 조사.
// 시간 복잡도 O(n^3)
int main() {
    int N, M;
    cin >> N >> M; // 50 이하 자연수
    string num[N];
    for(int i = 0; i < N; i++) {
        cin >> num[i];
    }
    int max; // 변의 길이
    if(N > M) {
        max = M;
    }
    else {
        max = N;
    }
    for(int k = max; k > 1; k--) { // k는 변의 길이
        for(int i = 0; i < N - k + 1; i++) { // k-1만큼 행렬을 움직이면 k 길이의 변이 생긴다.
            for(int j = 0; j < M - k + 1; j++) {
                char ch = num[i][j];
                if((ch == num[i+k-1][j]) && (ch == num[i][j+k-1]) && (ch == num[i+k-1][j+k-1])) {
                    max = k;
                    goto exit; // break하기 까다로워서 goto
                }
            }
        }
        if(k == 2) { // k가 2가 될 때까지 정사각형을 못 찾은 경우
            cout << 1; 
            return 0;
        }
    }
    exit:
    cout << max*max;    
    return 0;
}