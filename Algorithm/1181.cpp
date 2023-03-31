#include <iostream>
#include <string>
using namespace std;

// 최대 20000개의 문자열의 길이와 사전 순서를 동시에 비교해야함. 또, 중복도 제거해야함.
// string::compare은 사전 상의 순서. 길이가 우선 고려되지 않음.
// 퀵소트로도 구현할 수 있긴 한데, 데이터 셋이 그리 크지도 않고 그냥 삽입정렬로 구현하기로 결정.

int main() {
    int n;
    cin >> n;
    string str[n];
    for(int i = 0; i < n; i++) {
        cin >> str[i];
    }
    for(int i = 1; i < n; i++) {
        for(int j = i; j > 0; j--) {
            if(str[j-1].size() < str[j].size()) { // 내 앞 문자열의 길이가 더 짧은 상황
                break; // 중단.
            }
            else if(str[j-1].size() == str[j].size()) { // 문자열의 길이가 같은 상황
                if(str[j-1] == str[j]) { // 두 문자열이 동일하면
                    for(int k = j; k < n - 1; k++) { // 전부 한 칸씩 땡기고
                        swap(str[k], str[k+1]);
                    } 
                    i--; // 비교 위치도 땡기고 <-- 이거 빼먹어서 오류났음.
                    n--; // 데이터 총 크기도 줄임.
                }
                else { // or 문자열이 같지 않으면
                    if(str[j-1] > str[j]) { // 사전상 앞의 문자열이 더 크다면
                        swap(str[j-1], str[j]); // 교환.
                    }
                    else {
                        break; // 현재 문자열이 사전상 더 크다면 중단.
                    }
                }
            }
            else if(str[j-1].size() > str[j].size()) { // 앞의 문자열이 길이가 더 긴 상황
                swap(str[j-1], str[j]);
            }
        }
    }
    for(int i = 0; i < n; i++) { // 출력.
        cout << str[i] << '\n';
    }
    return 0;
}