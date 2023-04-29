#include <iostream>
#define endl '\n'
using namespace std;

// 1초 512MB
// N 500000, n크기 배열에 원소 0~10억
// 버블 소트할 때 스왑이 몇 번 일어나는가? 
// 머지 소트할 때 일어나는 스왑의 횟수와 똑같지 않은가?
// 머지 소트의 오른쪽 배열 값이 더 적을 때, 제치게되는 왼쪽 배열 숫자 개수들의 합.
long long int cnt = 0;

void merge(int arr[], int left, int mid, int right) {
    int sizeL = mid - left + 1;
    int sizeR = right - mid;
    int leftArr[sizeL];
    int rightArr[sizeR];

    for(int i = 0; i < sizeL; i++) {
        leftArr[i] = arr[left+i];
    }
    for(int i = 0; i < sizeR; i++) {
        rightArr[i] = arr[mid+1+i];
    }

    int i = 0, j = 0, k = left;
    while(i < sizeL && j < sizeR) {
        if(leftArr[i] <= rightArr[j]) {
            arr[k++] = leftArr[i++];
        }
        else {
            arr[k++] = rightArr[j++];
            cnt += sizeL - i;
        }
    }

    while(i < sizeL) {
        arr[k++] = leftArr[i++];
    }
    while(j < sizeR) {
        arr[k++] = rightArr[j++];
    }
}

void mergeSort(int arr[], int left, int right) {
    if(left < right) {
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }
}

int main() {
    int n;
    cin >> n;
    int arr[n];
    for(int i=0; i<n; i++) {
        cin >> arr[i];
    }
    mergeSort(arr, 0, n-1);
    cout << cnt << endl;
    return 0;
}