import java.io.*;
class j10775 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        Integer[] set = new Integer[G + 1];
        int ans = 0;
        for(int i = 0; i < P; i++) {
            int n = Integer.parseInt(br.readLine());
            // 제일 번호가 큰 게이트가 비어 있으면
            if(set[n] == null) {
                set[n] = n;
            }
            // n의 루트에서 루트 - 1이랑 합치기. 
            else {
                int gate = union(set, n);
                // 더 이상 도킹 불가능
                if(gate == 0) break;
            }
            ans++;
        }
        System.out.println(ans);
    }
    static int union(Integer[] set, int u) {
        int root = find(set, u);
        if(set[root - 1] == null) {
            set[root - 1] = root - 1;
            set[root] = root - 1;
            return root - 1;
        }
        else {
            set[u] = union(set, root - 1);
            return set[u];
        }
    }
    static int find(Integer[] set, int u) {
        if(set[u] != u) {
            set[u] = find(set, set[u]);
        }
        return set[u];
    }
}