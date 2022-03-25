#include <iostream>

int main() {
    int n, temp = 0;
    int num[7] = {0, 0, 0, 0, 0, 0, 0,};

    std::cin >> n;

    int i = 1;
    for(; i < n; i++) {
        temp = i;

        for(int j = 0; j < 7; j++) {
            num[j] = temp % 10;
            temp = temp / 10;
            if(temp == 0) break;
        }

    if(n == i + num[0] + num[1] + num[2] + num[3] + num[4] + num[5] + num[6]) {
        std::cout << i << std::endl;
        break;    
    }
    
    }

    if(n == i) 
        std::cout << 0 << std::endl;

    return 0;
}