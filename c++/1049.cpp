#include <iostream>
using namespace std;

int main() {
    int N, M;
    cin >> N >> M;
    int six[M], one[M];
    int minSix = -1, minOne = -1;
    for(int i = 0 ; i < M; i++) {
        cin >> six[i] >> one[i];
        if(i == 0) { minSix = six[i]; minOne = one[i]; }
        if(minSix > six[i]) { minSix = six[i]; }
        if(minOne > one[i]) { minOne = one[i]; }
    }
    int price = 0, string = 0;
    if(minOne * 6 < minSix) { minSix = minOne * 6;}

    while(string < N) {
        if((N - string) / 6) { price += minSix; string += 6; }
        else {
            if((N - string) * minOne > minSix) { price += minSix; string += 6; }
            else { price += minOne; string += 1; }
        }
    }
    cout << price;
}