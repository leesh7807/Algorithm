#include <iostream>
#include <vector>
#include <algorithm>
#define endl '\n'
using namespace std;

// 이진 탐색을 활용한 풀이.

int main() {
    int n;
    cin >> n;
    vector<int> A;
    for(int i=0; i<n; i++) {
        int temp;
        cin >> temp;
        A.push_back(temp);
    }
    sort(A.begin(), A.end());
    int m;
    cin >> m;
    int arr[m];
    for(int i=0; i<m; i++) {
        int temp;
        cin >> temp;
        arr[i] = binary_search(A.begin(), A.end(), temp);
    }
    for(int i=0; i<m; i++) {
        cout << arr[i] << endl;
    }
    return 0;
}