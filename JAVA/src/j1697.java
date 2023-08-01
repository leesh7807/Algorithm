import java.io.*;
import java.util.*;
public class j1697 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] isVisited = new boolean[100001];
        LinkedList<Integer> q = new LinkedList<>();
        q.add(N);
        isVisited[N] = true;
        int ans = bfs(K, q, isVisited);
        System.out.println(ans);
    }
    public static int bfs(int K, LinkedList<Integer> q, boolean[] isVisited) {
        int ret = 0;
        while(!q.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<>();
            while(!q.isEmpty()) temp.add(q.poll());
            for(Integer i : temp) {
                if(i == K) {
                    return ret;
                }
                if(0 <= i-1 && i-1 <= 100000 && !isVisited[i-1]) {
                    isVisited[i-1] = true;
                    q.add(i-1);
                }
                if(0 <= i+1 && i+1 <= 100000 && !isVisited[i+1]) {
                    isVisited[i+1] = true;
                    q.add(i+1);
                }
                if(0 <= i*2 && i*2 <= 100000 && !isVisited[i*2]) {
                    isVisited[i*2] = true;
                    q.add(i*2);
                }
            }
            ret++;
        }
        ret = -1;
        return ret;
    }
}
