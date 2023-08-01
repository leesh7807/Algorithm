import java.io.*;
public class j5525 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        char[] c = S.toCharArray();
        int[] count = new int[M];
        for(int i=2; i<M; i++) {
            if(c[i] == 'I' && c[i-1] == 'O' && c[i-2] == 'I') {
                count[i] = count[i-2] + 1;
            }
        }
        int ans = 0;
        for(int i=0; i<count.length; i++) {
            if(count[i] >= N) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
