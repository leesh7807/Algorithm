import java.io.*;
import java.util.*;
public class j7569 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][][] box = new int[N][M][K];
        LinkedList<Trio> tomato = new LinkedList<>();
        for(int k=0; k<K; k++) {
            for(int n=0; n<N; n++) {
                st = new StringTokenizer(br.readLine());
                for(int m=0; m<M; m++) {
                    int v = Integer.parseInt(st.nextToken());
                    box[n][m][k] = v;
                    if(v == 1) {
                        tomato.add(new Trio(n, m, k));
                    }
                }
            }
        }
        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};
        int day = -1;
        while(!tomato.isEmpty()) {
            day++;
            LinkedList<Trio> now = new LinkedList<>();
            while(!tomato.isEmpty()) {
                now.add(tomato.poll());
            }
            while(!now.isEmpty()) {
                Trio t = now.poll();
                for(int i=0; i<6; i++) {
                    int x2 = t.x + dx[i];
                    int y2 = t.y + dy[i];
                    int z2 = t.z + dz[i];
                    if(x2 >= 0 && x2 < N && y2 >= 0 && y2 < M && z2 >= 0 && z2 < K && box[x2][y2][z2] == 0) {
                        box[x2][y2][z2] = 1;
                        tomato.add(new Trio(x2, y2, z2));
                    }
                }
            }
        }
        boolean isRip = true;
        for(int k=0; k<K; k++) {
            for(int n=0; n<N; n++) {
                for(int m=0; m<M; m++) {
                    if(box[n][m][k] == 0) {
                        isRip = false;
                    }
                }
            }
        }
        day = isRip? day : -1;
        System.out.println(day);
    }
    public static class Trio {
        int x, y, z;
        public Trio(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
