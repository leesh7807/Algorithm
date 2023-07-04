import java.util.*;
import java.io.*;
public class j1927 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n=0; n<N; n++) {
            int v = Integer.parseInt(br.readLine());
            if(v==0) {
                if(pq.isEmpty()) {
                    bw.write("0\n");
                }
                else {
                    bw.write(Long.toString(pq.poll()) + "\n");
                }
            }
            else {
                pq.add(v);
            }
        }
        bw.close();                                                   
    }
}
