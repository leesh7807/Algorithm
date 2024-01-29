import java.io.*;
import java.util.*;
class j16566 {
    static ArrayList<Integer> arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M, K;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>(M);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arr.add(temp);
        }
        arr.sort(null);
        int[] set = new int[arr.size()];
        for(int i = 0; i < set.length; i++) {
            set[i] = -1;
        }
        st = new StringTokenizer(br.readLine());
        for(int k = 0; k < K; k++) {
            int chulsu = Integer.parseInt(st.nextToken());
            int lo = -1;
            int hi = arr.size() - 1;
            while(lo + 1 < hi) {
                int mid = (lo + hi) / 2;
                if(arr.get(mid) <= chulsu) {
                    lo = mid;    
                }
                else {
                    hi = mid;
                }
            }
            int idx = union(set, hi);
            bw.write(Long.toString(arr.get(idx)) + "\n");
        }
        bw.close();
    }
    static int union(int[] set, int v) {
        if(set[v] == -1) {
            set[v] = v;
            return v;
        }
        else {
            int parent = find(set, v);
            set[parent] = parent + 1;
            return union(set, parent + 1);
        }
    }
    static int find(int[] set, int v) {
        if(set[v] != v) {
            set[v] = find(set, set[v]);
        }
        return set[v];
    }
}