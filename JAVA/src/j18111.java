import java.io.*;
import java.util.*;
public class j18111 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int maxH = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, arr[i][j]);
            }
        }
        int ansT = Integer.MAX_VALUE;
        int ansH = -1;
        for(int h = maxH; h>=0; h--) {
            int time = 0;
            int needBlock = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    int heightDiff = h - arr[i][j];
                    if(heightDiff < 0) { // 블록을 제거할 때
                        time += -2 * heightDiff;
                        needBlock += heightDiff;
                    }
                    else if(heightDiff > 0) { // 블록을 쌓을 때
                        time += 1 * heightDiff;
                        needBlock += heightDiff;
                    }
                }
            }
            if(needBlock <= b) {
                if(time < ansT) {
                    ansT = time;
                    ansH = h;
                }
            }
        }
        bw.write(Long.toString(ansT) + ' ' + Long.toString(ansH));
        bw.close();
    }
}
