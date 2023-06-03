import java.util.*;
import java.io.*;
public class j15591 {
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][n+1];
        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[r][c] = v;
            arr[c][r] = v;
        }
        for(int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            bw.write(Long.toString(bfs(v, k, arr)) + '\n');
        }
        bw.close();
    }
    public static int bfs(int v, int k, int[][] arr) {
        int cnt = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n+1];
        queue.add(v);
        isVisited[v] = true;
        while(!queue.isEmpty()) {
            int now = queue.peekFirst();
            for(int i=1; i<=n; i++) {
                if(!isVisited[i] && arr[now][i] >= k) {
                    isVisited[i] = true;
                    queue.add(i);
                    cnt++;
                }
            }
            queue.poll();
        }
        return cnt;
    }
}