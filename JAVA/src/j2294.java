import java.io.*;
import java.util.*;
public class j2294 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        HashSet<Integer> coinList = new HashSet<>();
        for(int i=0; i<n; i++) {
            coinList.add(Integer.parseInt(br.readLine()));
        }
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[k+1];
        queue.add(k);
        isVisited[k] = true;
        int ans = 0;
        while(!queue.isEmpty()) {
            LinkedList<Integer> now = new LinkedList<>();
            while(!queue.isEmpty()) {
                int pos = queue.poll();
                if(pos == 0) {
                    System.out.println(ans);
                    return;
                }
                now.add(pos);
            }
            while(!now.isEmpty()) {
                int pos = now.poll();
                ArrayList<Integer> next =  new ArrayList<>();
                for(int coin : coinList) {
                    next.add(pos - coin);
                }
                for(int nextPos : next) {
                    if(nextPos < 0 || isVisited[nextPos]) continue;
                    queue.add(nextPos);
                    isVisited[nextPos] = true;
                }
            }
            ans++;
        }
        System.out.println(-1);
    }
}
