#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int N, S = 0;
    cin >> N;
    int A[N], B[N], sortedA[N];
    for(int i = 0; i < N; i++) { cin >> A[i]; sortedA[i] = -1;}
    for(int i = 0; i < N; i++) { cin >> B[i];}
    sort(A, A+N);
    for(int i = 0; i < N; i++) {
        int highTemp = 0;
        int jTemp = -1;
        for(int j = 0; j < N; j++) {
            if(sortedA[j] != -1) { continue; }
            int newTemp = A[i] * B[j] + B[j];
            if(highTemp < newTemp) {highTemp = newTemp; jTemp = j;}
        }
        sortedA[jTemp] = A[i];
    }
    for(int i = 0; i < N; i++) { S += sortedA[i] * B[i];}
    cout << S;

    
    return 0;
}