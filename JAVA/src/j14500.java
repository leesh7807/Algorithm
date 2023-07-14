import java.io.*;
import java.util.*;

public class j14500 {
    static int[][] tet;
    static boolean[][] isVisited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        tet = new int[row][col];
        isVisited = new boolean[row][col];
        for(int r=0; r<row; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<col; c++) {
                tet[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        for(int r=0; r<row; r++) {
            for(int c=0; c<col; c++) {
                ans = Math.max(ans, tetromino(r, c, 0, 0, 0));
            }
        }
        System.out.println(ans);
    }
    public static int tetromino(int x, int y, int blockCnt, int sum, int ret) {
        blockCnt++;
        sum += tet[x][y];
        isVisited[x][y] = true;
        if(blockCnt >= 4) {
            isVisited[x][y] = false;
            ret = Math.max(ret, sum);
            return ret;
        }
        for(int i=0; i<4; i++) {
            int x2 = x + dx[i];
            int y2 = y + dy[i];
            if(x2 >= 0 && x2 < tet.length && y2 >= 0 && y2 < tet[0].length && !isVisited[x2][y2]) {
                // t블록 처리.
                if(blockCnt == 2) { 
                    // x2, y2를 방문했다 가정하고 x, y를 중복 방문.
                    isVisited[x2][y2] = true;
                    ret = Math.max(ret, tetromino(x, y, blockCnt, sum-tet[x][y]+tet[x2][y2], ret));
                    isVisited[x2][y2] = false;
                    isVisited[x][y] = true;
                }
                ret = Math.max(ret, tetromino(x2, y2, blockCnt, sum, ret));
            }
        }
        isVisited[x][y] = false;
        return ret;
    }
}
/* 1. 좌표 받기
 * 2. 방문표시, 블록+1, 총합 기록.
 * 3. 블록이 4가 될 때까지 상하좌우로 방문안한 곳 이동.
 * 4. 총합 중 제일 큰 것 기록하기. 
 * 5. t블록에 대한 처리.
*/