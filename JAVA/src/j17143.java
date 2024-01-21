import java.io.*;
import java.util.*;
public class j17143 {
    static int R, C;
    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Shark> sharks = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            sharks.add(new Shark(r, c, s, d, v));
        }
        int ans = 0;
        for(int f = 1; f <= C; f++) {
            Shark fishing = new Shark(101, f, 0, 0, 0);
            int fishingIdx = -1;
            for(int i = 0; i < sharks.size(); i++) {
                Shark temp = sharks.get(i);
                if(temp.c == f && temp.r < fishing.r) {
                    fishing = temp;
                    fishingIdx = i;
                }
            }
            ans += fishing.s;
            if(fishingIdx != -1) sharks.remove(fishingIdx);
            PriorityQueue<Shark> moved = new PriorityQueue<>((a, b) -> {
                if(a.r == b.r && a.c == b.c) return Integer.compare(b.s, a.s);
                else if(a.r == b.r) return Integer.compare(a.c, b.c);
                return Integer.compare(a.r, b.r);
            });
            for(int i = 0; i < sharks.size(); i++) {
                moved.add(sharks.get(i).move());
            }
            sharks = new ArrayList<>();
            int prevR = -1;
            int prevC = -1;
            while(!moved.isEmpty()) {
                Shark temp = moved.poll();
                if(prevR == temp.r && prevC == temp.c) {
                    continue;
                }
                else {
                    prevR = temp.r;
                    prevC = temp.c;
                    sharks.add(temp);
                }
            }
        }
        System.out.println(ans);
    }
    static class Shark {
        int r, c, s, d, v;
        public Shark(int r, int c, int s, int d, int v) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.v = v;
        }
        public Shark move() {
            int move = v;
            while(move != 0) {
                r += dr[d];
                c += dc[d];
                if(r == 0) {
                    r = 2;
                    d = 2;
                }
                if(r == R + 1) {
                    r = R - 1;
                    d = 1;
                }
                if(c == 0) {
                    c = 2;
                    d = 3;
                }
                if(c == C + 1) {
                    c = C - 1;
                    d = 4;
                }
                move--;
            }
            return this;
        }
    }
}
