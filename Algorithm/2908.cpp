#include <iostream>
using namespace std;
int main() {
    char num1[3], num2[3];
    int c, i = 0;
    do {
        c = getchar();
        num1[i] = c;
        i++;
    } while(c != ' ');
    i = 0;
    do {
        c = getchar();
        num2[i] = c;
        i++;
    } while(c != '\n');
    int revNum1 = (num1[2] - 48) * 100 + (num1[1] - 48) * 10 + (num1[0] - 48);
    int revNum2 = (num2[2] - 48) * 100 + (num2[1] - 48) * 10 + (num2[0] - 48);
    if(revNum1 > revNum2) {
        cout << revNum1;
    }
    else {
        cout << revNum2;
    }
}