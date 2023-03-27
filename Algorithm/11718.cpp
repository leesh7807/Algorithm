#include <iostream>
using namespace std;
int main() {
    char str[101];
    int c, i = 0;
    while(true) {
        do {
            c = getchar();
            if(c == EOF) 
                return 0;
            str[i] = c;
            i++;
        } while(c != '\n');
        for(int j = 0; j < i - 1; j++) {
            cout << str[j];
        }
        cout << endl;
        i = 0;
    }
    return 0;
}