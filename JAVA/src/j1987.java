import java.io.*;
import java.util.*;
public class j1987 {
    static int R, C;
    static int[][] arr;
    static int ans = 0;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        for(int r=0; r<R; r++) {
            char[] cArr = br.readLine().toCharArray();
            for(int c=0; c<C; c++) {
                arr[r][c] = cArr[c] - 65;
            }
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(arr[0][0]);
        dfs(0, 0, 1, set);
        System.out.println(ans);
    }
    public static void dfs(int r, int c, int depth, HashSet<Integer> set) {
        for(int d=0; d<4; d++) {
            int newR = r + dr[d];
            int newC = c + dc[d];
            if(newR < 0 || newR >= R || newC < 0 || newC >= C) continue;
            if(set.add(arr[newR][newC])) {
                dfs(newR, newC, depth + 1, set);
                set.remove(arr[newR][newC]);
            }
        }
        ans = Math.max(ans, depth);
    }
}
