#include <iostream>
#include <string>
using namespace std;

int main() {
    int L, R;
    cin >> L >> R;
    string strL = to_string(L);
    string strR = to_string(R);
    if(strL.length() != strR.length()) { cout << 0; return 0; } // �ڸ� ���� �ٸ��� ������ 0�� ���´�.

    int eight = 0;
    for(int i = 0; i < strL.length(); i++) {
        if((strL[i] == '8') && (strR[i] == '8')) { eight++; } // ���� ū �ڸ����� ���Ͽ� 8�� ������ count++
        else if(strL[i] == strR[i]) { continue; } // Ư�� �ڸ����� �ٸ��� �� �Ʒ� �ڸ������� ���� 1�̻� ���� �� �ִ�. ���� 8�� �ƴϴ�.
        else { break; }
    }
    cout << eight;
    return 0;
}