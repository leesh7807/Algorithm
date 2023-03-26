#include <iostream>
using namespace std;
int main() {
    int chess[6];
    for(int i=0; i<6; i++) 
        cin >> chess[i];   
    cout << 1 - chess[0] << " ";
    cout << 1 - chess[1] << " ";
    cout << 2 - chess[2] << " ";
    cout << 2 - chess[3] << " ";
    cout << 2 - chess[4] << " ";
    cout << 8 - chess[5] << " ";
    return 0;
}