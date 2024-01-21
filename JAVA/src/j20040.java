import java.io.*;
import java.util.*;
public class j20040 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] set = new int[n];
        for(int i = 0; i < n; i++) {
            set[i] = i;
        }
        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(!union(set, u, v)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
    static boolean union(int[] set, int u, int v) {
        int r1 = find(set, u);
        int r2 = find(set, v);
        if(r1 == r2) {
            return false;
        }
        set[r1] = r2;
        return true;
    }
    static int find(int[] set, int u) {
        if(set[u] != u) {
            set[u] = find(set, set[u]);
        }
        return set[u];
    }
}
