#include <iostream>
#define MAX 10000
int cache[10000] = {0,};

int d(int n) {
    int sum = n;
    for(int i = n; i != 0; i = i/10) {
        sum += i%10; 
    }
    return sum;
}
void selfNumber(int n) {
    if(cache[n] == 1) 
        return;
    int dRes = d(n);
    if(dRes > MAX) 
        return;
    selfNumber(dRes);
    cache[dRes] = 1;
}
int main() {
    for(int i = 1; i <= MAX; i++) {
        selfNumber(i);
    }
    for(int i = 1; i <= MAX; i++) {
        if(cache[i] == 0) {
            std::cout << i << "\n";
        }
    }
    return 0;
}