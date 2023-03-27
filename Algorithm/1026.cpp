#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int N, S = 0;
    cin >> N;
    int A[N], B[N], sortedA[N];
    // A와 B에 입력 받으면서 sortedA를 -1로 초기화.
    for(int i = 0; i < N; i++) { cin >> A[i]; sortedA[i] = -1;}
    for(int i = 0; i < N; i++) { cin >> B[i];}
    // A 오름차순 정렬
    sort(A, A+N);
    // A의 가장 작은 값과 B의 가장 큰 값이 매칭될 때 S는 최소가 된다.
    for(int i = 0; i < N; i++) { // A는 정렬되어 있어 배열의 가장 작은 값부터 비교가 시작.
        int highTemp = -1;
        int jTemp = -1;
        for(int j = 0; j < N; j++) {
            if(sortedA[j] != -1) { continue; } // B[j]가 곱해질 상대가 정해졌으니 건너뛰기.
            int newTemp = B[j]; 
            if(highTemp < newTemp) {highTemp = newTemp; jTemp = j;} // 가장 큰 B[j]와 j위치 저장
        }
        sortedA[jTemp] = A[i]; // 작은 A[i]가 큰 B[j]와 곱해지도록 sortedA[j]에 대입
    }
    for(int i = 0; i < N; i++) { S += sortedA[i] * B[i];}
    cout << S;

    
    return 0;
}