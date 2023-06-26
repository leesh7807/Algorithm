import java.util.*;
import java.io.*;
public class j7568 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Pair> arr = new ArrayList<>();
        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr.add(new Pair(w, h));
        }
        for(Pair p : arr) {
            int rank = 1;
            for(Pair cont: arr) {
                if(cont.w > p.w && cont.h > p.h) {
                    rank++;
                }
            }
            bw.write(Long.toString(rank) + ' ');
        }
        bw.close();
    }
    static class Pair {
        int w, h;
        Pair(int w, int h) {
            this.w = w;
            this.h = h;
        }
    }
}
