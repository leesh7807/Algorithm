#include <iostream>
#define endl '\n'
using namespace std;

// 1�� 512MB
// N 500000, nũ�� �迭�� ���� 0~10��
// ���� ��Ʈ�� �� ������ �� �� �Ͼ�°�? 
// ���� ��Ʈ�� �� �Ͼ�� ������ Ƚ���� �Ȱ��� ������?
// ���� ��Ʈ�� ������ �迭 ���� �� ���� ��, ��ġ�ԵǴ� ���� �迭 ���� �������� ��.
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