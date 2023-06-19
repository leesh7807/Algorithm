import java.util.*;
import java.io.*;
public class j4018 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] ch = new char[n][m];
        for(int i=0; i<n; i++) {
            String temp = br.readLine();
            ch[i] = temp.toCharArray();
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n-7; i++) {
            for(int j=0; j<m-7; j++) {
                char[][] temp = new char[8][8];
                for(int r=0; r<8; r++) {
                    for(int c=0; c<8; c++) {
                        temp[r][c] = ch[r+i][c+j];
                    }
                }
                ans = Math.min(ans, check(temp));
            }
        }
        System.out.print(ans);
    }
    public static int check(char[][] arr) {
        int cnt = 0;
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if((i+j)%2 == 0) {
                    if(arr[i][j] == 'B') {
                        cnt++;
                    }
                }
                else {
                    if(arr[i][j] == 'W') {
                        cnt++;
                    }
                }
            }
        }
        if(cnt > 32) {
            return 64 - cnt;
        }
        else {
            return cnt;
        }
    }
}
