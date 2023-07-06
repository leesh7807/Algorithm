import java.io.*;
import java.util.*;
public class j2606 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        boolean[][] net = new boolean[N+1][N+1];
        for(int k=0; k<K; k++) {
            st = new StringTokenizer(br.readLine()); 
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            net[v][w] = true;
            net[w][v] = true;
        }
        boolean[] isVisited = new boolean[N+1];
        isVisited[1] = true;
        dfs(1, net, isVisited);
        int ans = 0;
        for(int i=2; i<isVisited.length; i++) {
            if(isVisited[i]) ans++;   
        }
        System.out.println(ans);
    }
    public static void dfs(int now, boolean net[][], boolean isVisited[]) {
        for(int i=0; i<net.length; i++) {
            if(net[now][i] && !isVisited[i]) {
                isVisited[i] = true;
                dfs(i, net, isVisited);
            }
        }
    }
}
