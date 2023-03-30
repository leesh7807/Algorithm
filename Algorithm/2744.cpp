#include <iostream>
#include <string>
using namespace std;

int main() {
    string str;
    cin >> str;
    for(int i = 0; i < str.size(); i++) {
        if(str[i] < 95) {
            str[i] = tolower(str[i]);
        }
        else {
            str[i] = toupper(str[i]);
        }
    }
    cout << str;
    return 0;
}