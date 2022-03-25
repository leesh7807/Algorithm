#include <iostream>

int main() {
    std::cout.setf(std::ios::fixed);
    std::cout.precision(3);

    int n, k, sum = 0, avg, overg = 0;
    std::cin >> n; // 입력받을 반 개수
    for(;n > 0; n--) {
        std::cin >> k; // 학생 인원
        int grade[k];
        for(int i = 0; i < k; i++) {
            std::cin >> grade[i];
            sum += grade[i];
        }
        avg = sum / k;
        
        for(int i = 0; i < k; i++) 
            if(grade[i]>avg) overg++;
        
        std::cout << (float)overg/k*100 << "%" << std::endl;

        sum =0;
        overg = 0;
    }
    
    return 0;
}