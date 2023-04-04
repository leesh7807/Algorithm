#include <iostream>
#include <algorithm>
#include <vector>
#define endl '\n'
using namespace std;

// 이거는 배열 2개 만들어서 더 뒤에 있는 애 인덱스 앞으로 땡기면서 비교.
// 대략적인 시간복잡도 계산. n은 최대 십만. n크기 배열 정렬 2번. 그리고 n번의 조건 계산.
// 현재 코드 100000 * 17 * 2 + 100000 = 3500000 대략 350만.
// binary_search를 쓸 경우의 시간 복잡도.
// -> 100000 * 17 + 100000 * 17 = 3400000 대략 340만.
// 이렇게 놓고 보면 비슷할 것 같지만, 막상 이 코드가 더 빠름.
// 이 코드는 tie와 동기화를 풀지 않고도 통과하지만, 이진 탐색을 쓴 코드는 풀어야만 함.

// 테스트 돌려본 결과 for문 안에 cin과 cout을 같이 쓴 것이 속도에 큰 문제를 일으켰음.
// cin으로 입력 받기 -> cout안의 이진탐색 함수 호출 -> 호출 결과 -> 출력 -> cin으로 입력 받기.
// 추측컨데, tie로 묶여 있기에 cout이 버퍼를 비우기 전까지 다음 입력을 받을 수 없는 것으로 보임. 
// 즉, cout의 출력인 이진 탐색이 끝나고 버퍼를 비운 후에야 다음 입력 값을 받아들이는 것.
// cout대신 배열에 저장하는 방식을 사용한 것만으로 이 코드보다도 0.002초 빨라졌음.
// 컴파일러는 루프를 알아서 자동 병렬화 처리하는데 cin과 cout의 tie가 이를 불가능하게 해 속도에 심각한 저하를 끼친 것으로 결론.
// => 이유없이 cin과 cout을 한 루프 안에 사용하는 것을 자제하자. endl의 사용자제도 마찬가지.

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