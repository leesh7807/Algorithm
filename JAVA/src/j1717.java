import java.io.*;
import java.util.*;
public class j1717 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        for(int i=1; i<n+1; i++) {
            arr[i] = i;
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(command == 0) {
                int rootA = find(arr, a);
                int rootB = find(arr, b);
                union(arr, rootA, rootB);
            }
            if(command == 1) {
                int rootA = find(arr, a);
                int rootB = find(arr, b);
                if(rootA == rootB) {
                    bw.write("YES\n");
                }
                else {
                    bw.write("NO\n");
                }
            }
        }
        bw.close();
    }
    public static int find(int[] arr, int a) {
        if(arr[a] == a) return a;
        else {
            arr[a] = find(arr, arr[a]);
            return arr[a];
        }
    }
    public static void union(int[] arr, int a, int b) {
        int rootA = find(arr, a);
        int rootB = find(arr, b);
        arr[rootB] = rootA;
    }
}
