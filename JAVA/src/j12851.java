import java.io.*;
import java.util.*;
public class j12851 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[100001];
        queue.add(N);
        isVisited[N] = true;
        int time = 0;
        while(!queue.isEmpty()) {
            LinkedList<Integer> now = new LinkedList<>();
            int cnt = 0;
            while(!queue.isEmpty()) {
                int val = queue.poll();
                now.add(val);
                isVisited[val] = true;
                if(val == K) {
                    cnt++;
                }
            }
            if(cnt > 0) {
                System.out.println(time);
                System.out.println(cnt);
                return;
            }
            while(!now.isEmpty()) {
                int nowVal = now.poll();
                int[] nextValArr = {nowVal - 1, nowVal + 1, nowVal * 2};
                for(int i=0; i<3; i++) {
                    int nextVal = nextValArr[i];
                    if(nextVal < 0 || nextVal > 100000 || isVisited[nextVal]) continue;
                    queue.add(nextVal);
                }
            }
            time++;
        }
    }
}
