#include <iostream>
using namespace std;
int main() {
    int alp[26];
    for(int i = 0; i < 26; i++) {
        alp[i] = -1;
    }
    char input[100];
    int i = 0, c; 
    do {
        c = getchar();
        input[i] = c;
        i++;
    } while(c != '\n');
    for(int n = i - 1; n >= 0; n--) {
        alp[((int)input[n] - 97)] = n;
    }
    for(int n = 0; n < 26; n++) {
        cout << alp[n] << " ";
    }
    return 0;
}