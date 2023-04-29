    #include <iostream>
    #include <vector>
    #include <algorithm>
    #define endl '\n'
    using namespace std;

    int main() {
        int T;
        cin >> T;
        for(int t=0; t<T; t++) {
            int M, R, N;
            cin >> M >> R >> N;
            vector<int> check[M+1];
            for(int i=0; i<N; i++) {
                int x;
                cin >> x;
                int begin = x-R;
                int end = x+R;
                if(begin < 0) begin = 0;
                if(end > M) end = M;
                for(int j=begin; j<=end; j++) {
                    check[j].push_back(x);
                }
            }
            int cnt = 1;
            int currentLight = -1;
            if(!check[0].empty()) {
                currentLight = check[0].front();
            }
            else cnt = -1;
            if(currentLight != -1) {
                for(int i=1; i<M+1; i++) {
                    if(check[i].empty()) {
                        cnt = -1;
                        break;
                    }
                    if(!binary_search(check[i].begin(), check[i].end(), currentLight)) {
                        if(check[i-1].size() > 1) {
                            currentLight = check[i-1].back();
                            cnt++;
                        }
                        else {
                            cnt = -1;
                            break;
                        }
                    }
                }
            }
            if(cnt < 0) {
                cout << "Case #" << t + 1 << ": IMPOSSIBLE" << endl; 
            }
            else {
                cout << "Case #" << t + 1 << ": " << cnt << endl; 
            }
        }
        return 0;
    }    