#include <iostream>
#include <string>
#include <ctime>
using namespace std;

int main() {
    time_t timer = time(NULL);
    struct tm* t = localtime(&timer);
    cout << to_string(t->tm_year + 1900) << "-";
    cout.width(2);
    cout.fill('0');
    cout << to_string(t->tm_mon + 1) << "-";
    cout.width(2);
    cout.fill('0');
    cout << to_string(t->tm_mday);
    return 0;   
}