#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <climits>
#define endl '\n'
using namespace std;

// 500000����. n�� Ȧ ��. nlogn. �޸� ����. |����| < 4000
// ���. �߾Ӱ�. �ֺ�. ����. ��� ���� ���� ���� ������ ��.
int main() {
    int n;
    int arr[8001] = {0,};
    cin >> n;
    int avg = 0; // ���. 4000 * 500000 = 2000000000 int���� �̳�.
    for(int i = 0; i < n; i++) {
        int temp;
        cin >> temp;
        arr[temp+4000]++;
        avg += temp;
    }
    avg = round((double)avg/n); // round �Լ��� �Ҽ��� ù° �ڸ����� �ݿø�
    if(avg == 0) avg *= -1; // round(-0.3)�� -0���� ��µ�. �̸� �ؼ�
    int mid, count = 0;
    int freq = -1;
    vector<int> freqV;
    int minN = INT_MAX, maxN = INT_MAX;
    for(int i = 0; i < 8001; i++) {
        if(freq == arr[i]) { // ���� �󵵸� ���Ϳ� ����
            freqV.push_back(i-4000); 
        }
        else if(freq < arr[i]) { // �� ū �� ã���� ���� �ʱ�ȭ
            freqV.clear();
            freq = arr[i];
            freqV.push_back(i-4000);
        }
        if(arr[i] > 0 && minN == INT_MAX) minN = i - 4000; // ó������ ������ �ּҰ�
        if(arr[i] > 0) maxN = i - 4000; // ���������� ������ �ִ밪
        while(arr[i] > 0) { 
            arr[i]--;
            count++; // ���ݱ��� �� ����
            if(count == n/2 + 1) mid = i - 4000; // �߾Ӱ�
        }
    }
    int mode; // �ֺ�
    if(freqV.size() == 1) { mode = freqV.front(); } // �ֺ��� �ϳ�
    else {
        sort(freqV.begin(), freqV.end()); // �������� �����Ͽ�, �ι�°�� ���
        mode = freqV.at(1);
    }

    cout << avg << endl << mid << endl << mode << endl << maxN - minN << endl;
    return 0;
}