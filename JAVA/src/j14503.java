import java.io.*;
import java.util.*;
public class j14503 {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int cleanerRow = Integer.parseInt(st.nextToken());
        int cleanerCol = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cleanCnt = 0;
        while(true) {
            if(map[cleanerRow][cleanerCol] == 0) {
                map[cleanerRow][cleanerCol] = 2;
                cleanCnt++;
            }
            boolean isNotCleaned = false;
            for(int d=0; d<4; d++) {
                int tempR = cleanerRow + dr[d];
                int tempC = cleanerCol + dc[d];
                if(map[tempR][tempC] == 0) {
                    isNotCleaned = true;
                    break;
                }
            }
            if(isNotCleaned) {
                dir = (dir + 3) % 4;
                int tempR = cleanerRow + dr[dir];
                int tempC = cleanerCol + dc[dir];
                if(map[tempR][tempC] == 0) {
                    cleanerRow = tempR;
                    cleanerCol = tempC;
                }
            }
            else {
                int backDir = (dir + 2) % 4;
                int tempR = cleanerRow + dr[backDir];
                int tempC = cleanerCol + dc[backDir];
                if(map[tempR][tempC] == 1) {
                    // 작동 중단
                    break;
                }
                else {
                    cleanerRow = tempR;
                    cleanerCol = tempC;
                }
            }
        }
        System.out.println(cleanCnt);
    }
}
