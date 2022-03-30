#include <iostream>
using namespace std;
int main() {
    int c, sum = 0;
    do {
        c = getchar();
        if(c >= 80 && c <= 83) {
            sum += 8;
        }
        else if(c >= 84 && c <= 86) {
            sum += 9;
        }
        else if(c >= 87) {
            sum += 10;
        }
        else if(c != '\n') {
            sum += (c - 'A') / 3 + 3;
        }
    } while(c != '\n');
    cout << sum;
}