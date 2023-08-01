import java.io.*;
import java.util.*;
public class j16928 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] jump = new int[101];
        
        for(int nm=0; nm<N+M; nm++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jump[u] = v;
        }
        LinkedList<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[101];
        q.add(1);
        isVisited[1] = true;
        int cnt = 0;
        while(!q.isEmpty() && !isVisited[100]) {
            LinkedList<Integer> now = new LinkedList<>();
            while(!q.isEmpty()) {
                now.add(q.poll());
            }
            while(!now.isEmpty()){
                int pos = now.poll();
                for(int i=1; i<=6; i++) {
                    int next = pos+i;
                    if(next > 100) continue;
                    if(jump[next] != 0) next = jump[next];
                    if(isVisited[next]) continue;
                    q.add(next);
                    isVisited[next] = true;
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
