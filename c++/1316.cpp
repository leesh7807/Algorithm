#include <iostream>
using namespace std;
int groupWordChecker() {
    int alp[26] = {0};
    char str[101];
    cin >> str;
    for(int i = 0; str[i] != '\0'; i++) {
        while(str[i] == str[i+1]) {
            i++;
        }
        if(alp[str[i]-97] == -1) {
            return 0;
        }
        alp[str[i]-97] = -1;
    }
    return 1;
}
int main() {
    int n, count = 0;
    cin >> n;
    for(int i = 0; i < n; i++) {
        count += groupWordChecker();
    }
    cout << count;
    return 0;
}