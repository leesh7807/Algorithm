#include <iostream>
#include <string>
using namespace std;

// 처음으로 입력 받은 것을 최초 패턴으로 설정
// 다음 입력 들어오는 것들 중 최초 패턴과 다른 부분을 전부 ? 변환
int main() {
    int N;
    cin >> N;
    string pattern;
    string file[N];
    for(int i = 0; i < N; i++) {
        cin >> file[i];
        if(pattern.empty()) {
            pattern = file[i]; 
        } 
        else {
            for(int j = 0; j < pattern.size(); j++) {
                if(pattern[j] != file[i][j]) {
                    pattern[j] = '?';
                }
            }
        }
    }
    cout << pattern;
}