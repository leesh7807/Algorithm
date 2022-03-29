#include <iostream>
#include <vector>
int hansu(int n) {
    std::vector<int> digit;
    int array[3] = {-1, -1, -1};
    for(int i = n; i != 0; i = i/10) {
        digit.push_back(i%10);
    }
    for(int i = 0; !digit.empty(); i++) {
        array[i] = digit.back();
        digit.pop_back();
    }
    for(int i = 0; i < sizeof(array)/sizeof(int) - 2; i++){
        if((array[i] != -1) && (array[i+1] != -1) && (array[i+2] != -1)) {
            int tmp1 = array[i] - array[i+1];
            int tmp2 = array[i+1] - array[i+2];
            if(tmp1 != tmp2) {
                return 0;
            }
        }
    }
    return 1;
}
int main() {
    int n, count = 0;
    std::cin >> n;
    for(int i = 1; i <= n; i++) {
        count += hansu(i);
    }
    std::cout << count;
    return 0;
}