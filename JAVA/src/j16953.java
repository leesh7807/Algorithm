import java.io.*;
import java.util.*;
public class j16953 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        HashSet<Long> notVisited = new HashSet<>();
        LinkedList<Long> arr = new LinkedList<>();
        arr.add(A);
        int cnt = 0;
        while(!arr.isEmpty()) {
            LinkedList<Long> now = new LinkedList<>();
            while(!arr.isEmpty()) {
                now.add(arr.poll());
            }
            cnt++;
            while(!now.isEmpty()) {
                long pos = now.poll();
                if(pos == B) {
                    // B로 변환 가능한 경우
                    System.out.println(cnt);
                    return;
                }
                if(notVisited.add(pos)) {
                    if(pos * 2 <= 1000000000) arr.add(pos * 2);
                    if(pos * 10 + 1 <= 1000000000) arr.add(pos * 10 + 1);
                }
            }
        }
        System.out.println(-1);
    }
}
