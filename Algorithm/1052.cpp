#include <iostream>
using namespace std;

int main() {
    int N, K;
    int buy = 0;
    cin >> N >> K;
    int stand, count;
    // 같은 양의 물병 2개가 있으면 하나로 합쳐질 수 있다. 1+1=2 2+2=4... 
    // 2진수 기준으로 1의 개수가 합치고 남은 물병의 개수. ex) 111(2) 1L 하나, 2L 하나, 4L 하나
    do {
        stand = 0B1000000000000000000000000; // 최대값보다 큰 2진수 기준
        count = 0; // 물이 들어가 있는 물병의 개수    
        for(int i = 0; i < 25; i++) { // 물병의 개수와 1000000...(2) 기준을 AND 연산하여 1이 몇개 있는지 찾기.
            if(N & stand) {
                count++;
            }  
            stand >>= 1; // 비트 오른쪽 1 쉬프트
        }
        N++; // 남은 물병의 개수가 K 이하가 될 때 까지 물병 하나씩 사며 반복.
        buy++;
    } while( count > K );
    buy--; // 반복문 빠져나오기전에 산 물병 빼주기.
    cout << buy;
    return 0;
}