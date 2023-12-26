import java.io.*;
import java.util.*;
public class j2098 {
    static final int INF = 2000_0000;
    static int N;
    static int[][][] cache;
    static int bitMax; // 11111...
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        bitMax = (1 << N) - 1;
        cache = new int[N][N][bitMax + 1]; // 16 * 16 * 2^16
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                cache[i][j][(1 << i) | (1 << j)] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 1; i < N; i++) {
            if(cache[i][0][(1 << i) + 1] == 0) continue; // i에서 0으로 길이 있어야함
            ans = Math.min(minDistance(0, i, bitMax) + cache[i][0][(1 << i) + 1], ans); // 모든 곳을 전부 방문하고 0부터 i까지 최소로 도달하는 방법 + i에서 0으로
        }
        System.out.println(ans);
    }
    static int minDistance(int from, int to, int visit) { // 출발, 도착, 방문해야하는 지점
        if(cache[from][to][visit] > 0) // 이미 이 케이스에 대해 알고 있으면
            return cache[from][to][visit];

        cache[from][to][visit] = INF;
        for(int i = 1; i < N; i++) {
            if(i == to) continue; // 0과 to는 제외
            if((visit & (1 << i)) > 0 && cache[i][to][(1 << i) | (1 << to)] > 0) { // 방문해야만 하는 i && i에서 to까지 길이 있으면
                 // minDistance(from, to, visit) = (minDistance(from, i, visit에서 to제외) + i에서 to 거리) 중 최소
                cache[from][to][visit] = Math.min(minDistance(from, i, visit ^ (1 << to)) + cache[i][to][(1 << i) | (1 << to)], cache[from][to][visit]);
            }
        }
        return cache[from][to][visit];
    }
}

/*
 * 1. minDistance(1, 4) + cost(4, 1)
 * -> min(1, 3) + cost(3, 4) + cost(4, 1) or min(1, 2) + cost(2, 4) + cost(4, 1)
 * -> cost(1, 2) + cost(2, 3) + cost(3, 4) + cost(4, 1) or cost(1, 3) + cost(3, 2) + cost(3, 4) + cost(4, 1) or ...
 * 2. minDistance(1, 3) + cost(3, 1)
 * 한 케이스를 끝내면 뒤에 케이스에서 계산을 중복해서 하게된다.
 */