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
        if(pattern.empty()) { // 이렇게 굳이 if문 반복해서 검사하게 하지 말고, 이 부분을 밖으로 뺀 뒤 i = 1부터 시작하게 하는게 맞을 것 같음.
            pattern = file[i]; 
        } 
        else {
            for(int j = 0; j < pattern.size(); j++) {
                if(pattern[j] != file[i][j]) { // 한 글자씩 비교해가며 다르면 ?로
                    pattern[j] = '?';
                }
            }
        }
    }
    cout << pattern;
}