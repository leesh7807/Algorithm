#include <iostream>
using namespace std;
int main() {
    int alp[26] = {0};
    int i = 0, c;
    do {
        c = getchar();
        if((c >= 97) && (c <= 122)) c -= 32; // 소문자에서 대문자
        alp[c-65]++; // 65는 A
        i++;
    } while(c != '\n');
    int freq = 0;
    char ans;
    for(int i = 0; i < 26; i++) {
        if(freq < alp[i]) { 
            freq = alp[i];
            ans = i;
        }
        else if(freq == alp[i]) {
            ans = -2; // 63은 물음표
        }
    }
    cout << (char)(ans + 65);
}