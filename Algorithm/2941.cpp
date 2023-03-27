#include <iostream>
using namespace std;
int main() {
    char str[101];
    int c, i = 0, j = 0;
    do {
        c = getchar();
        str[j] = c;
        if(c == '=') {
            if(str[j-1] == 'c' || str[j-1] == 's') {
                i--;
            }
            else if(str[j-1] == 'z') {
                if(str[j-2] == 'd') {
                    i--;
                    i--;
                }
                else {
                    i--;
                }
            }
        }
        else if(c == '-') {
            if(str[j-1] == 'c' || str[j-1] == 'd') {
                i--;
            }
        }
        else if(c == 'j') {
            if(str[j-1] == 'l' || str[j-1] == 'n') {
                i--;
            }
        }
        i++;
        j++;
    } while(c != '\n');
    cout << i - 1;
}