#include <iostream>
#define endl '\n'
using namespace std;

// �Է� �ִ밪�� 10000���� �ڿ��� -> ��� ����
int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false); // �����ָ� �ð��ʰ�
    int n;
    cin >> n;
    int arr[10001] = {0,};
    int input;
    for(int i = 0; i < n; i++) {
        cin >> input;
        arr[input]++;
    }   
    for(int i = 1; i < 10001; i++) {
        while(arr[i] > 0) {
            cout << i << endl;
            arr[i]--;
        }
    }
    return 0;
}