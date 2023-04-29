#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#define endl '\n'
using namespace std;
int main() {
    int T;
    int N;
    cin >> T;
    for(int i=0; i<T; i++) {
        int alp[26]; // 0은 A, 1은 B ...
        for(int i=0; i<26; i++) {
            cin >> alp[i]; // alp[0]에다가 인코딩 숫자... alp[25]
        }
        int N;
        cin >> N;
        string s[N];
        /*
        string str = "안녕하세요";
        str[0] = '안';
        string arr[N] = {"안녕하세요", "반갑습니다"};
        arr[0][2] = '하';
        arr[0] = "안녕하세요";
        */
        vector<string> res;
        for(int i=0; i<N; i++) {
            cin >> s[i]; // ABC
            for(int j=0; j<10; j++) {
                if(s[i][j] == '\0') {
                    break;
                }
                int newValue = alp[s[i][j]-65]; // s[0][0] - 65. (int)A - 65. 0. alp[0] = 인코딩 숫자 무언가.
                s[i][j] = newValue; // s[0][0] = A를 인코딩 숫자 무언가로 바꿈.
            }
            res.push_back(s[i]); // 2차원 배열은 1차원 배열에 있으니까
        }
        int originSize = res.size(); // 현재 크기를 받아두기.
        sort(res.begin(), res.end()); // 유니크 함수를 위한 정렬
        vector<string>::iterator it = unique(res.begin(), res.end()); // 유니크 함수로 중복 제거(사이즈는 안 줄어둠)
        res.resize(it - res.begin()); // 리사이즈로 사이즈 줄이기
        int newSize = res.size(); // 줄어든 사이즈 확인
        if(originSize != newSize) { // 최초 사이즈랑 달라졌으면 유니크 함수로 중복 제거된거니까 충돌이 있었다.
            cout << "Case #" << i + 1 << ": YES" << endl; 
        }
        else {
            cout << "Case #" << i + 1 << ": NO" << endl;
        }
    }
    return 0;
}