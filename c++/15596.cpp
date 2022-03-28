#include <iostream>
#include <vector>

long long sum(std::vector<int> &a) {
    long long ans = 0;
    for(int i = 0; i < a.size(); i++) {
        ans += a[i];
    }
    return ans;
}

int main() {
    std::vector<int> a = {1, 2, 3, 4, 5};
    long long ans = sum(a);
    std::cout << ans;
    return 0;
}