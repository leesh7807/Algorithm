import java.io.*;
import java.util.*;
public class j11279 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> {return Integer.compare(b, a);});
        for(int n=0; n<N; n++) {
            int val = Integer.parseInt(br.readLine());
            if(val == 0) {
                if(max.isEmpty()) {
                    bw.write("0\n");
                }
                else {
                    bw.write(Long.toString(max.poll()) + "\n");
                }
            }
            else {
                max.add(val);
            }
        }
        bw.close();
    }
}
