import java.io.*;
import java.util.*;
public class j13549 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<Pair> now = new PriorityQueue<>((Pair a, Pair b) -> Integer.compare(a.time, b.time));
        int[] timeTable = new int[200000];
        now.add(new Pair(N, 0));
        for(int i=0; i<200000; i++) {
            timeTable[i] = Integer.MAX_VALUE;
        }
        timeTable[N] = 0;
        while(!now.isEmpty()) {
            Pair nowPos = now.poll();
            if(nowPos.pos == K) {
                System.out.println(nowPos.time);
                return;
            }
            if(nowPos.pos*2 < 200000 && nowPos.time < timeTable[nowPos.pos*2] ) {
                now.add(new Pair(nowPos.pos*2, nowPos.time));
                timeTable[nowPos.pos*2] = nowPos.time;
            }
            if(nowPos.pos+1 <= 100000 && nowPos.time + 1 < timeTable[nowPos.pos+1]) {
                now.add(new Pair(nowPos.pos+1, nowPos.time+1));
                timeTable[nowPos.pos+1] = nowPos.time + 1;
            }
            if(nowPos.pos-1 >= 0 && nowPos.time + 1 < timeTable[nowPos.pos-1]) {
                now.add(new Pair(nowPos.pos-1, nowPos.time+1));
                timeTable[nowPos.pos-1] = nowPos.time + 1;
            }
        }
    }
    static class Pair {
        int pos, time;
        public Pair(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }
}
