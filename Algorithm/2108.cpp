#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <climits>
#define endl '\n'
using namespace std;

// 500000만개. n은 홀 수. nlogn. 메모리 여유. |정수| < 4000
// 평균. 중앙값. 최빈값. 범위. 계수 정렬 쓰기 좋은 문제인 듯.
int main() {
    int n;
    int arr[8001] = {0,};
    cin >> n;
    int avg = 0; // 평균. 4000 * 500000 = 2000000000 int범위 이내.
    for(int i = 0; i < n; i++) {
        int temp;
        cin >> temp;
        arr[temp+4000]++;
        avg += temp;
    }
    avg = round((double)avg/n); // round 함수는 소수점 첫째 자리에서 반올림
    if(avg == 0) avg *= -1; // round(-0.3)이 -0으로 출력됨. 이를 해소
    int mid, count = 0;
    int freq = -1;
    vector<int> freqV;
    int minN = INT_MAX, maxN = INT_MAX;
    for(int i = 0; i < 8001; i++) {
        if(freq == arr[i]) { // 같은 빈도면 벡터에 저장
            freqV.push_back(i-4000); 
        }
        else if(freq < arr[i]) { // 더 큰 빈도 찾으면 벡터 초기화
            freqV.clear();
            freq = arr[i];
            freqV.push_back(i-4000);
        }
        if(arr[i] > 0 && minN == INT_MAX) minN = i - 4000; // 처음으로 만난게 최소값
        if(arr[i] > 0) maxN = i - 4000; // 마지막으로 만난게 최대값
        while(arr[i] > 0) { 
            arr[i]--;
            count++; // 지금까지 수 개수
            if(count == n/2 + 1) mid = i - 4000; // 중앙값
        }
    }
    int mode; // 최빈값
    if(freqV.size() == 1) { mode = freqV.front(); } // 최빈값이 하나
    else {
        sort(freqV.begin(), freqV.end()); // 여러개면 정렬하여, 두번째를 출력
        mode = freqV.at(1);
    }

    cout << avg << endl << mid << endl << mode << endl << maxN - minN << endl;
    return 0;
}