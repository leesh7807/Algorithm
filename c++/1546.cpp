#include <iostream>
#include <cmath>

int main() {
    int N;
    std::cin >> N;
    int score[N];
    std::cin >> score[0];
    int max = score[0];
    for(int i = 1; i < N; i++) {
        std::cin >> score[i];
        if(score[i] > max) max = score[i];
    }
    float changedSum = 0;
    for(int i = 0; i < N; i++) {
        changedSum += (std::round((float)score[i]/max*10000) / 100);
    }
    std::cout << changedSum/N;
    return 0;
}