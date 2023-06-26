import java.io.*;
import java.util.*;
public class j11651 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Pair> arr = new ArrayList<>();
        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new Pair(x, y));
        }
        arr.sort(null);
        for(Pair p : arr) {
            bw.write(Long.toString(p.x) + ' ' + Long.toString(p.y) + '\n');
        }
        bw.close();
    }
    static class Pair implements Comparable<Pair> {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override 
        public int compareTo(Pair p) {
            if(y == p.y) {
                return Integer.compare(x, p.x);
            }
            return Integer.compare(y, p.y);
        }
    }
}
