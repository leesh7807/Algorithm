#include <iostream>
#include <algorithm>
#include <vector>
#define endl '\n'
using namespace std;

// �̰Ŵ� �迭 2�� ���� �� �ڿ� �ִ� �� �ε��� ������ ����鼭 ��.
// �뷫���� �ð����⵵ ���. n�� �ִ� �ʸ�. nũ�� �迭 ���� 2��. �׸��� n���� ���� ���.
// ���� �ڵ� 100000 * 17 * 2 + 100000 = 3500000 �뷫 350��.
// binary_search�� �� ����� �ð� ���⵵.
// -> 100000 * 17 + 100000 * 17 = 3400000 �뷫 340��.
// �̷��� ���� ���� ����� �� ������, ���� �� �ڵ尡 �� ����.
// �� �ڵ�� tie�� ����ȭ�� Ǯ�� �ʰ� ���������, ���� Ž���� �� �ڵ�� Ǯ��߸� ��.

// �׽�Ʈ ������ ��� for�� �ȿ� cin�� cout�� ���� �� ���� �ӵ��� ū ������ ��������.
// cin���� �Է� �ޱ� -> cout���� ����Ž�� �Լ� ȣ�� -> ȣ�� ��� -> ��� -> cin���� �Է� �ޱ�.
// ��������, tie�� ���� �ֱ⿡ cout�� ���۸� ���� ������ ���� �Է��� ���� �� ���� ������ ����. 
// ��, cout�� ����� ���� Ž���� ������ ���۸� ��� �Ŀ��� ���� �Է� ���� �޾Ƶ��̴� ��.
// cout��� �迭�� �����ϴ� ����� ����� �͸����� �� �ڵ庸�ٵ� 0.002�� ��������.
// �����Ϸ��� ������ �˾Ƽ� �ڵ� ����ȭ ó���ϴµ� cin�� cout�� tie�� �̸� �Ұ����ϰ� �� �ӵ��� �ɰ��� ���ϸ� ��ģ ������ ���.
// => �������� cin�� cout�� �� ���� �ȿ� ����ϴ� ���� ��������. endl�� ��������� ��������.

bool compare(pair<int, int> n1, pair<int, int> n2) {
    return n1.first < n2.first;
}
int main() {
    int n;
    cin >> n;
    int arr1[n];
    for(int i=0; i<n; i++) {
        cin >> arr1[i];
    }
    int m;
    cin >> m;
    vector<pair<int, int>> arr2;
    for(int i=0; i<m; i++) {
        int temp;
        cin >> temp;
        arr2.push_back(make_pair(temp, i));
    }
    sort(arr1, arr1 + n);
    sort(arr2.begin(), arr2.end(), compare);
    int iter1 = 0;
    int iter2 = 0;
    int ans[m] =  {0,};
    while(true) {
        if(iter1 >= n || iter2 >= m) {
            break;
        }

        if(arr2.at(iter2).first == arr1[iter1]) {
            ans[arr2.at(iter2).second] = 1;
            iter2++;
        }
        else if(arr2.at(iter2).first > arr1[iter1]) { 
            iter1++; 
        }
        else if(arr2.at(iter2).first < arr1[iter1]) {
            iter2++;
        }
    }
    for(int i=0; i<m; i++) {
        cout << ans[i] << endl;
    }
    return 0;
}