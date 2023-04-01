#include <iostream>
#define endl '\n'
using namespace std;

// 최대 점 개수 100000.
// 삽입 정렬 시간 초과.
// 퀵소트로 구현해보기
void quickSort(int arr[][2], int start, int end);

int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);
    int n;
    cin >> n;
    int arr[n][2];
    for(int i = 0; i < n; i++) {
        cin >> arr[i][0] >> arr[i][1];
    }
    quickSort(arr, 0, n-1);
    for(int i = 0; i < n; i++) {
        cout << arr[i][0] << ' ' << arr[i][1] << endl;
    }
    return 0;
}

void quickSort(int arr[][2], int start, int end) {
    if(start >= end) return;
    int pivot = start;
    int left = start + 1;
    int right = end;
    while(left <= right) { // while start
        while(left <= end) {
            if(arr[left][0] > arr[pivot][0]) {
                break;
            }
            else if(arr[left][0] == arr[pivot][0] && arr[left][1] > arr[pivot][1]) {
                break;
            }
            else left++;
        }
        while(right > start) {
            if(arr[right][0] < arr[pivot][0]) {
                break;
            }
            else if(arr[right][0] == arr[pivot][0] && arr[right][1] < arr[pivot][1]) {
                break;        
            }
            else right--;
        }
        if(left > right) {
            int tempX = arr[pivot][0];
            int tempY = arr[pivot][1];
            arr[pivot][0] = arr[right][0];
            arr[pivot][1] = arr[right][1];
            arr[right][0] = tempX;
            arr[right][1] = tempY;
        }
        else {
            int tempX = arr[left][0];
            int tempY = arr[left][1];
            arr[left][0] = arr[right][0];
            arr[left][1] = arr[right][1];
            arr[right][0] = tempX;
            arr[right][1] = tempY;
        }
    } // while end
    quickSort(arr, start, right-1);
    quickSort(arr, right+1, end); 
}