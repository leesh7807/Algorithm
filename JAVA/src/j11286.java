import java.io.*;
import java.util.*;
public class j11286 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Pair> absHeap = new PriorityQueue<>((Pair a, Pair b) -> 
        {if(a.abs == b.abs) return Integer.compare(a.val, b.val); 
            else return Integer.compare(a.abs, b.abs);});
        for(int n=0; n<N; n++) {
            int val = Integer.parseInt(br.readLine());
            if(val == 0) {
                if(absHeap.isEmpty()) {
                    bw.write("0\n");
                }
                else {
                    bw.write(Long.toString(absHeap.poll().val) + "\n");
                }
            }
            else {
                absHeap.add(new Pair(val, Math.abs(val)));
            }
        }
        bw.close();
    }
    static class Pair {
        int val, abs;
        public Pair(int val, int abs) {
            this.val = val;
            this.abs = abs;
        }
    }
}
