#include <iostream>
using namespace std;
// ��� ����
// �����ϴ� ������(����)�� �ִ� ������ �˰� ���� ��, �ִ� ũ���� �迭 ����.
// ������ ���� �ε����� �迭 �� ���� ����.
// �迭�� ������������ ��ȸ�ϸ� ���� ������ �ε����� ���. 
// ������ ���� n, �ִ� ���� k��� �ð����⵵�� O(n + k).

int main() {
    int arr[2000001] = {0,}; // -1000000 ~ 1000000
    int N;
    cin >> N;
    int num;
    for(int i = 0; i < N; i++) {
        cin >> num;
        arr[num+1000000] = 1;  // -1000000�� �� arr[0]�� �ǵ��� ���ϱ�
    }
    for(int i = 0; i < 2000001; i++) {
        if(arr[i] == 1) {
            cout << i - 1000000 << '\n';
        }
    }
    return 0;
}

// quick sort - �̰� �ð� ���⵵ ����
// ù ��° ���Ҹ� ��������, ���ʿ��� ���غ��� ū ����, �����ʿ��� ���غ��� ���� ���� ã�� ����.
// �����ʿ��� ã�� ���� ������ �߿��ϸ� ���ذ� �����ʿ��� ã�� ���� ����.
// �̷��� �Ǹ� ���� ���� �������� ���� ����� ū ����� ���еǾ���.
// ���� ���ܰ� ������ ���ܿ� ���� ���� ������� ���� �ݺ�.
// n=2^k���� ���Ҹ� �����Ѵٰ� ����. �ּ��� ���, �迭�� �Ź� �̵�еǹǷ� k��. �̵�н�Ű�� ���� �� ������ n��.
// k=log(n)�̹Ƿ�, �ð����⵵�� O(nlogn). �־��� ���, �迭���� ���Ұ� �ϳ��� �и��ǹǷ�, �ð����⵵�� O(n^2).

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

//     quickSort(arr, start, right - 1); // ����
//     quickSort(arr, right + 1, end); // ������
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