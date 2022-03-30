#include <iostream>
using namespace std;
int main() {
    int wordCount = 0, blankChecker = 1;
    int c;
    do {
        c = getchar();
        if(c == 32) {
            blankChecker = 1;
        }
        if((blankChecker == 1) && (c != 32) && (c != 10)) {
            wordCount++;
            blankChecker = 0;
        }
    } while(c != '\n');

    cout << wordCount;
}