import java.io.*;
import java.util.*;
public class j1158 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            queue.add(i);
        }
        bw.write("<");
        while(!queue.isEmpty()) {
            for(int k=0; k<K-1; k++) {
                queue.add(queue.poll());
            }
            bw.write(Long.toString(queue.poll()));
            if(queue.isEmpty()) {
                bw.write(">");
            }
            else {
                bw.write(", ");
            }
        }
        bw.close();
    }
}
