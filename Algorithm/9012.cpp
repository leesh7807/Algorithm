#include <iostream>
#include <string>

int main() {
    int n;
    std::cin >> n;
    std::string test[9999];
    for(int i = 0; i < n; i++) {
        std::cin >> test[i]; 
    }
    for(int i = 0; i < n; i++) {
        int stackSum = 0, stack = 0;
        for(int j = 0; j < test[i].length(); j++) {
            if(test[i][j] == 'O') {
                stack++;
            }
            else {
                stack = 0;
            }
            stackSum += stack;
        }
        std::cout << stackSum << std::endl;
        stack = 0;
    }
}