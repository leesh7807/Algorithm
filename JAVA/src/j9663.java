import java.util.*;
import java.io.*;
public class j9663 {
    static int n;
    static int ans = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 1 ~ 14
        
        bw.write(Long.toString(ans));
        bw.close();
    }
}

/* n x n 체스판 위에 n개의 퀸을 서로 공격하지 못하도록 올리는 경우의 수
 * 
 */