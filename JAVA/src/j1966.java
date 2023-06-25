import java.io.*;
import java.util.*;
public class j1966 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            LinkedList<Pair> q = new LinkedList<>();
            int pos = 0; // n번째 문서
            int maxW = 0;
            while(st.hasMoreTokens()) {
                int w = Integer.parseInt(st.nextToken());
                maxW = Math.max(maxW, w);
                q.add(new Pair(w, pos++));
            }
            pos = 1;
            while(!q.isEmpty()) {
                Pair first = q.poll();
                if(first.w == maxW) {
                    if(first.v == M) {
                        bw.write(Long.toString(pos) + '\n');
                        break;
                    }
                    else {
                        maxW = 0;
                        for(Pair p : q) {
                            maxW = Math.max(maxW, p.w);
                        }
                        pos++;
                    }
                }
                else {
                    q.add(first);
                }
            }
        }
        bw.close();
    }
    public static class Pair {
        Integer w, v;
        Pair(Integer w, Integer v) {
            this.w = w;
            this.v = v;
        }
    }
}
