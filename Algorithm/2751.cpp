#include <iostream>
using namespace std;
// 계수 정렬
// 정렬하는 데이터(정수)의 최대 범위를 알고 있을 때, 최대 크기의 배열 생성.
// 데이터 값을 인덱스로 배열 내 값을 증가.
// 배열을 오름차순으로 조회하며 값이 있으면 인덱스를 출력. 
// 데이터 개수 n, 최대 범위 k라면 시간복잡도는 O(n + k).

int main() {
    int arr[2000001] = {0,}; // -1000000 ~ 1000000
    int N;
    cin >> N;
    int num;
    for(int i = 0; i < N; i++) {
        cin >> num;
        arr[num+1000000] = 1;  // -1000000일 때 arr[0]이 되도록 더하기
    }
    for(int i = 0; i < 2000001; i++) {
        if(arr[i] == 1) {
            cout << i - 1000000 << '\n';
        }
    }
    return 0;
}

// quick sort - 이건 시간 복잡도 터짐
// 첫 번째 원소를 기준으로, 왼쪽에서 기준보다 큰 것을, 오른쪽에서 기준보다 작은 것을 찾아 스왑.
// 오른쪽에서 찾은 것이 왼쪽을 추월하면 기준과 오른쪽에서 찾은 것을 스왑.
// 이렇게 되면 기준 값을 기준으로 작은 값들과 큰 값들로 구분되어짐.
// 왼쪽 집단과 오른쪽 집단에 대해 같은 방식으로 정렬 반복.
// n=2^k개의 원소를 정렬한다고 가정. 최선의 경우, 배열이 매번 이등분되므로 k번. 이등분시키기 위한 비교 연산을 n번.
// k=log(n)이므로, 시간복잡도는 O(nlogn). 최악의 경우, 배열에서 원소가 하나씩 분리되므로, 시간복잡도는 O(n^2).

// void quickSort(int *arr, int start, int end) {
//     if(start >= end) return;
//     int pivot = start;
//     int left = start + 1;
//     int right = end;
//     while(left <= right) {
//         while(left <= end && arr[left] <= arr[pivot]) left++;
//         while(right > start && arr[right] >= arr[pivot]) right--;
//         if(left > right) { // 
//             int temp = arr[pivot];
//             arr[pivot] = arr[right];
//             arr[right] = temp;
//         }
//         else {
//             int temp = arr[left];
//             arr[left] = arr[right];
//             arr[right] = temp;
//         }
//     }

//     quickSort(arr, start, right - 1); // 왼쪽
//     quickSort(arr, right + 1, end); // 오른쪽
// }

// int main() {
//     int N;
//     cin >> N;
//     int arr[N];
//     for(int i = 0; i < N; i++) {
//         cin >> arr[i];
//     }
//     quickSort(arr, 0, N - 1);
//     for(int i = 0; i < N; i++) {
//         cout << arr[i] << '\n';
//     }
// }