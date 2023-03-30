#include <iostream>
#include <string>
using namespace std;

int main() {
    string str;
    cin >> str;
    if(str == "A+") {
        cout << fixed;
        cout.precision(1);
        cout << 4.3;
    }
    else if(str == "A0") {
        cout << fixed;
        cout.precision(1);
        cout << 4.0;
    }
    else if(str == "A-") {
        cout << fixed;
        cout.precision(1);
        cout << 3.7;
    }
    else if(str == "B+") {
        cout << fixed;
        cout.precision(1);
        cout << 3.3;
    }
    else if(str == "B0") {
        cout << fixed;
        cout.precision(1);
        cout << 3.0;
    }
    else if(str == "B-") {
        cout << fixed;
        cout.precision(1);
        cout << 2.7;
    }
    else if(str == "C+") {
        cout << fixed;
        cout.precision(1);
        cout << 2.3;
    }
    else if(str == "C0") {
        cout << fixed;
        cout.precision(1);
        cout << 2.0;
    }
    else if(str == "C-") {
        cout << fixed;
        cout.precision(1);
        cout << 1.7;
    }
    else if(str == "D+") {
        cout << fixed;
        cout.precision(1);
        cout << 1.3;
    }
    else if(str == "D0") {
        cout << fixed;
        cout.precision(1);
        cout << 1.0;
    }
    else if(str == "D-") {
        cout << fixed;
        cout.precision(1);
        cout << 0.7;
    }
    else if(str == "F") {
        cout << fixed;
        cout.precision(1);
        cout << 0.0;
    }
    return 0;
}