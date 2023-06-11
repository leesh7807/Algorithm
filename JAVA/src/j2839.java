import java.io.*;
public class j2839 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[1800][5001];
        arr[1][3] = true;
        arr[1][5] = true;
        for(int i=2; i<1800; i++) {
            for(int j=N; j>0; j--) {
                if(arr[i-1][j]) {
                    arr[i][j] = true;
                    if(j+3 <= N) {
                        arr[i][j+3] = true;
                    }
                    if(j+5 <= N) {
                        arr[i][j+5] = true;
                    }
                }
            }
        }
        bw.write(Long.toString(-1));
        for(int i=1; i<1800; i++) {
            if(arr[i][N]) {
                bw = new BufferedWriter(new OutputStreamWriter(System.out));
                bw.write(Long.toString(i));
                break;
            }
        }
        bw.close();
    }
}
