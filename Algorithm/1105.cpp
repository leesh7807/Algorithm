#include <iostream>
#include <string>
using namespace std;

int main() {
    int L, R;
    cin >> L >> R;
    string strL = to_string(L);
    string strR = to_string(R);
    if(strL.length() != strR.length()) { cout << 0; return 0; } // 자리 수가 다르면 무조건 0이 나온다.

    int eight = 0;
    for(int i = 0; i < strL.length(); i++) {
        if((strL[i] == '8') && (strR[i] == '8')) { eight++; } // 가장 큰 자리부터 비교하여 8이 나오면 count++
        else if(strL[i] == strR[i]) { continue; } // 특정 자리수가 다르면 그 아래 자리수들은 전부 1이상 더할 수 있다. 절대 8이 아니다.
        else { break; }
    }
    cout << eight;
    return 0;
}