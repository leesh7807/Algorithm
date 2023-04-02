#include <iostream>
#include <algorithm>
#define endl '\n'
using namespace std;

// n은 십만개. nlogn 이하로. 메모리 192MB. 각각의 로프가 감당가능한 무게 다름. 
// 로프를 병렬 연결하면 각 로프에 걸리는 무게는 무게/로프개수
// 로프들을 이용하여 들 수 있는 최대 중량은?
// 가벼운 로프가 섞이면, n으로 나누어도 가벼운 로프가 감당하지 못해 오히려 손해일 수 있다.
// 그래서 무거운 로프부터 추가해야함. 무거운 순으로 정렬하자.
// (15) -> 15 (15, 10) -> 20 (15, 10, 8) -> 24 (15, 10, 8, 5) -> 20 이러면 24가 최대.
// 중복 케이스에 대한 예외 생각을 안해서 코드 다시 짰음. (15, 10, 8, 5, 5) -> 25로 더 커진다.
// 시작과 끝, 중복 케이스를 항상 의식하자.
bool compare(int n1, int n2) {
    return n1 > n2;
}
int main() {
    int n;
    cin >> n;
    int arr[n];
    for(int i=0; i<n; i++) {
        cin >> arr[i];
    }
    sort(arr, arr+n, compare);
    int max = 0;
    for(int i=0; i<n; i++) {
        int newMax = arr[i] * (i+1);;
        if(max < newMax) {
            max = newMax;
        }
    }
    cout << max;
    return 0;
}