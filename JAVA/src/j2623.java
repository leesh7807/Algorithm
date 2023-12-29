import java.io.*;
import java.util.*;
public class j2623 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<HashSet<Integer>> arr = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            arr.add(new HashSet<Integer>());
        }
        int[] topology = new int[N + 1];
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int numSinger = Integer.parseInt(st.nextToken());
            int prevSinger = Integer.parseInt(st.nextToken());
            for(int s = 1; s < numSinger; s++) {
                int nextSinger = Integer.parseInt(st.nextToken());
                if(arr.get(prevSinger).add(nextSinger))
                    topology[nextSinger]++;
                prevSinger = nextSinger;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(topology[i] == 0) 
                queue.add(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            if(queue.isEmpty()) {
                System.out.println(0);
                return;
            }
            int now = queue.poll();
            sb.append(Long.toString(now) + "\n");
            for(Integer next : arr.get(now)) {
                if(--topology[next] == 0)
                    queue.add(next);
            }
        }
        System.out.println(sb.toString());
    }
}
