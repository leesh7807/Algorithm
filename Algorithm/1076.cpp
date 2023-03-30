#include <iostream>
#include <string>
#include <cmath>
using namespace std;

// 러프하게 구현
int main() {
    long long int ans = 0; // white white white인 경우 990억이다.
    string color; 
    for(int i = 0; i < 3; i++) {
        cin >> color;
        int colorNum;
        if(color == "black") { colorNum = 0; }
        else if(color == "brown") { colorNum = 1; }
        else if(color == "red") { colorNum = 2; }
        else if(color == "orange") { colorNum = 3; }
        else if(color == "yellow") { colorNum = 4; }
        else if(color == "green") { colorNum = 5; }
        else if(color == "blue") { colorNum = 6; }
        else if(color == "violet") { colorNum = 7; }
        else if(color == "grey") { colorNum = 8; }
        else if(color == "white") { colorNum = 9; }
        if(i == 0) {
            ans += colorNum * 10;
        }
        else if(i == 1) {
            ans += colorNum;
        }
        else if(i == 2) {
            ans *= round(pow(10, colorNum)); // cmath의 pow는 double형을 기반으로 돌아가기에 손실이 생길 수 있다. pow(10,2) = 99.99999...이다.
        }
    }
    cout << ans;
    return 0;
}