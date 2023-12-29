import java.io.*;
public class j2239 {
    static int[][] arr = new int[9][9];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++) {
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j < 9; j++) {
                arr[i][j] = line[j] - '0';
            }
        }
        for(int i = 0; i < 81; i++) {
            if(arr[i / 9][i % 9] == 0) {
                backtracking(i / 9, i % 9);
                break;
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                ans.append(Long.toString(arr[i][j]));
            }
            ans.append("\n");
        }
        System.out.println(ans.toString());
    }
    static boolean backtracking(int r, int c) {
        // 가능한 숫자 탐색
        int num = searchNum(1, r, c);
        if(num > 9) {
            return false;
        }
        arr[r][c] = num;
        // 그 다음 0인 곳 탐색
        for(int i = r * 9 + c; i < 81; i++) {
            if(arr[i / 9][i % 9] == 0) {
                // 실패? 백트래킹. 돌아와서 다음 가능한 숫자 탐색.
                while(true) {
                    if(backtracking(i / 9, i % 9)) 
                        break;
                    else {
                        num = searchNum(++num, r, c);
                        if(num > 9) {
                            arr[r][c] = 0;
                            return false;
                        }
                        arr[r][c] = num;
                    }
                }
            }
        }
        return true;
    }
    // num부터 가능한 숫자 탐색
    static int searchNum(int num, int r, int c) {
        int n = num;
        for(int i = 0; i < 9; i++) {
            if(arr[r][i] == n) {
                i = -1;
                n++;
                continue;
            }
            if(arr[i][c] == n) {
                i = -1;
                n++;
                continue;
            }
            if(arr[i / 3 + (r / 3) * 3][i % 3 + (c / 3) * 3] == n) {
                i = -1;
                n++;
                continue;
            }
        }
        return n;
    }
}
