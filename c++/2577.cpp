#include <iostream>
#include <cmath>

int main() {
    int a, b, c;
    std::cin >> a >> b >> c; //�Է�
    int sum = a * b * c; //A*B*C
    int num[10];
    for(int i=0; i<10; i++)
        num[i] = 0;

    int digit = 0;
    digit = log10(sum) + 1; //�ڸ������ϱ�

    int tmp = 0;    
    for(int i=0; i<digit; i++) { //���� ���� ���ϱ�
        tmp = sum%10;
        num[tmp]++;
        sum /= 10;
    }
    
    for(int i=0; i<10; i++) {
        std::cout << num[i] << std::endl;
    }
    
    return 0;
}