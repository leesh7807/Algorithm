#include <iostream>

int main() {
    int a, b, c;

    while(1) {
        std::cin >> a >> b >> c;

        if(a==0 && b==0 && c==0) break; 
        
        if(a*a+b*b==c*c||b*b+c*c==a*a||c*c+a*a==b*b) {
            std::cout << "right" << std::endl;
        }
        else {
            std::cout << "wrong" << std::endl;
        } 

    }
    return 0;
}