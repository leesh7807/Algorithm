import java.io.*;
import java.util.*;
public class j1022 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        int[][] result = new int[r2 - r1 + 1][c2 - c1 + 1];
        int shell = -1;
        for(int r = r1; r <= r2; r++) {
            for(int c = c1; c <= c2; c++) {
                shell = Math.max(Math.abs(r), Math.abs(c));
                int shellMax = 1 + shell*(8 + 8*shell)/2;
                if(Math.abs(r) >= Math.abs(c)) {
                    int rowMid = shellMax - shell;
                    if(r >= 0) {
                        result[r - r1][c - c1] = rowMid + c;
                    }
                    else if(r < 0) {
                        result[r - r1][c - c1] = rowMid - 4*shell - c;
                    }
                }                
                else {
                    int colMid = shellMax - 3*shell;
                    if(c <= 0) {
                        result[r - r1][c - c1] = colMid + r;
                    }
                    else if(c > 0) {
                        result[r - r1][c - c1] = colMid - 4*shell - r;
                    }
                }
            }
        }
        int strLength = Math.max(Long.toString(result[0][0]).length(), Long.toString(result[r2 - r1][c2 - c1]).length());
        for(int i = 0; i < r2 - r1 + 1; i++) {
            for(int j = 0; j < c2 - c1 + 1; j++) {
                sb.append(String.format("%" + strLength + "d ", result[i][j]));
            }
           sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
