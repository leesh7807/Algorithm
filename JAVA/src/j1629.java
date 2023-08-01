import java.io.*;
import java.util.*;
public class j1629 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        long ans = mergePower(A, B, C);
        System.out.println(ans);
    }
    public static long mergePower(int A, int B, int C) {
        if(B == 1) return A % C;
        long divide = mergePower(A, B/2, C) % C;
        if(B%2==0) return (divide * divide) % C;
        else return (((divide * divide) % C) * A % C) % C; 
    }
}