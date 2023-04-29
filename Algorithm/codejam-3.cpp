#include <iostream>
#include <vector>
#include <algorithm>
#define endl '\n'
using namespace std;
bool compare(pair<int, int> n1, pair<int, int> n2) {
    if(n1.first == n2.first) return n1.second < n2.second;
    return n1.second < n2.second;
}
int main() {
    int T;
    cin >> T;
    for(int t=0; t<T; t++) {
        int n;
        cin >> n;
        vector<int> v;
        for(int i=0; i<n; i++) {
            int temp;
            cin >> temp;
            v.push_back(temp);
        }
        vector<int>::iterator it = unique(v.begin(), v.end());
        v.resize(it - v.begin());
        vector<int> test = v;
        int originSize = test.size();
        sort(test.begin(), test.end());
        vector<int>::iterator it2 = unique(test.begin(), test.end());
        test.resize(it2 - test.begin());
        if(originSize != test.size()) {
            cout << "Case #" << t + 1 << ": IMPOSSIBLE" << endl; 
        }
        else {
            cout << "Case #" << t + 1 << ": ";
            for(int i=0; i<v.size(); i++) {
                cout << v.at(i) << " ";
            }
            cout << endl;
        }
    }
    return 0;
}