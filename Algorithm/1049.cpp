#include <iostream>
using namespace std;

int main() {
    int N, M;
    cin >> N >> M;
    int six[M], one[M];
    int minSix = -1, minOne = -1;
    for(int i = 0 ; i < M; i++) { // 브랜드 중 가장 싼 6개 묶음과 1개 찾기.
        cin >> six[i] >> one[i];
        if(i == 0) { minSix = six[i]; minOne = one[i]; }
        if(minSix > six[i]) { minSix = six[i]; }
        if(minOne > one[i]) { minOne = one[i]; }
    }
    int price = 0, string = 0;
    if(minOne * 6 < minSix) { minSix = minOne * 6;} // 만약 1개를 6개 사는게 더 싸면 최소 값 바꾸기.

    while(string < N) { // 기타 줄 다 살 때까지
        if((N - string) * minOne > minSix) { price += minSix; string += 6; } // 1개씩 사는게 더 비싸면 6개씩 사기.
        else { price += minOne; string += 1; }
    }
    cout << price;
}