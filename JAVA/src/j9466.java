import java.io.*;
import java.util.*;
public class j9466 {
    static final int INF = 20_0000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] topology = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            for(int i = 0; i <= N; i++) {
                arr.add(new ArrayList<Integer>());
            }
            for(int i = 1; i <= N; i++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == i) {
                    topology[temp] = INF;
                }
                else {
                    arr.get(i).add(temp);       
                    topology[temp]++;
                }
            } 
            LinkedList<Integer> q = new LinkedList<>();
            for(int i = 1; i <= N; i++) {
                if(topology[i] == 0) {
                    q.add(i);
                }
            }
            for(int i = 0; i < N; i++) {
                if(q.isEmpty()) {
                    break;
                }
                int now = q.poll();
                for(Integer temp : arr.get(now)) {
                    if(--topology[temp] == 0) {
                        q.add(temp);
                    }
                }
            }
            int ans = 0;
            for(int i = 1; i <= N; i++) {
                if(topology[i] == 0) {
                    ans++;
                }
            }
            bw.write(Long.toString(ans) + "\n");
            bw.flush();
        }
        bw.close();
    }
}
