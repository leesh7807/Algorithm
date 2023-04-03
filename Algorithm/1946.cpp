#include <iostream>
#include <algorithm>
#include <vector>
#define endl '\n'
using namespace std;

// �׽�Ʈ ���̽� �ִ� 20���ϱ� ����.
// n�� �ʸ�����. 2��. nlogn���Ϸ�. �޸� ���� 256MB
// �ٸ� ��ο� ���� �� ���� �� �ϳ��� �߳��� �Ѵ�. 
// ������ ���� �߿� 1���� ������ ������ ä��.
// ���� ���� ������ �����ϰ�, �ڱ� ���� ����� ���� ����� ���ϸ� ���� �ʳ�?
// (1, 4) (2, 5) (3, 3) (4, 1), (5, 2). �ڱ� �� �߿� ���� ��� ���� �߳� �ֶ� ���ؾ���.
// ���� �ڱ⺸�� �� ������ �ֵ� �߿� ���� ���� ���� �ֺ��� ���� �� �������� �ȴ�. 

bool compare(pair<int, int> n1, pair<int, int> n2) {
    return n1.first < n2.first;
}
int main() {
    int T;
    cin >> T;
    for(int i=0; i<T; i++) {
        int n;
        cin >> n;
        vector<pair<int, int>> arr;
        for(int i=0; i<n; i++) {
            int first, second;
            cin >> first >> second;
            arr.push_back(make_pair(first, second));
        }
        sort(arr.begin(), arr.end(), compare);
        int ans = 1; // ���� 1��
        int meetingGood = arr.at(0).second; // �� ���� �� ���� ���� ���� ��
        for(int i=1; i<n; i++) {
            if(meetingGood > arr.at(i).second) {
                meetingGood = arr.at(i).second;
                ans++;
            }
        }
        cout << ans << endl;
    }
    return 0;
}