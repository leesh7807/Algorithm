import java.io.*;
import java.util.*;
public class j9019 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            LinkedList<Pair> q = new LinkedList<>();
            boolean[] isVisited = new boolean[10000];
            isVisited[A] = true;
            q.add(new Pair(A, ""));
            while(true) {
                Pair p = q.poll();
                int v = p.v;
                String com = p.command;
                if(v == B) {
                    bw.write(com + "\n");
                    break;
                }
                // D
                int D = v * 2 % 10000;
                if(!isVisited[D]) {
                    q.add(new Pair(D, com + "D"));
                    isVisited[D] = true;
                }
                // S
                int S = v == 0 ? 9999 : v - 1;
                if(!isVisited[S]) {
                    q.add(new Pair(S, com + "S"));
                    isVisited[S] = true;
                }
                // L
                int L = v % 1000 * 10 + v / 1000;
                if(!isVisited[L]) {
                    q.add(new Pair(L, com + "L"));
                    isVisited[L] = true;
                }
                int R = v % 10 * 1000 + v / 10;
                if(!isVisited[R]) {
                    q.add(new Pair(R, com + "R"));
                    isVisited[R] = true;
                }
            }
        }
        bw.close();
    }
    static class Pair {
        int v;
        String command;
        public Pair(int v, String command) {
            this.v = v;
            this.command = command;
        }
    }
}
