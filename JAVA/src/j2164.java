import java.io.*;
import java.util.*;
public class j2164 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> q = new LinkedList<>();
        for(int n=1; n<=N; n++) {
            q.add(n);
        }
        while(q.size() != 1) {
            q.poll();
            q.add(q.poll());
        }
        System.out.println(q.poll());
    }
}
