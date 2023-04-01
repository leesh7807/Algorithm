#include <iostream>
#include <string>
#define endl '\n'
using namespace std;

void quickSort(string &arr, int start, int end);
// 문자열로 입력 받아서 퀵소트. 그냥 라이브러리 sort하고 역순으로 출력했어도 될듯.
int main() {
    string arr;
    cin >> arr;
    quickSort(arr, 0, arr.size() - 1);
    for(int i = 0; i < arr.size(); i++) {
        cout << arr[i];
    }
    return 0;
}

void quickSort(string &arr, int start, int end) {
    if(start >= end) return;
    int pivot = start;
    int left = start + 1;
    int right = end;
    while(left <= right) {
        while(left <= end && arr[left] >= arr[pivot]) left++;
        while(right > start && arr[right] <= arr[pivot]) right--;
        if(left > right) {
            swap(arr[pivot], arr[right]);
        }
        else {
            swap(arr[left], arr[right]);
        }
    }
    quickSort(arr, start, right -1);
    quickSort(arr, right + 1, end);
}