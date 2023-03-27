#include <iostream>

int main() {
    int a = 0, b = 1; 
    int temp, n;

    std::cin >> n;

    if(n==0) {std::cout << 0; return 0;}

    for(int i = 0; i < n - 1; i++){
        temp = b;
        b += a;
        a = temp;
    }
    
    std::cout << b;
    return 0;
}