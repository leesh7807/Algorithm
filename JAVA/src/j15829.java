import java.io.*;
public class j15829 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] ch = s.toCharArray();
        Long[] r = new Long[51];
        r[0] = 1L;
        for(int i=1; i<51; i++) {
            r[i] = (r[i-1] * 31) % 1234567891;
        }
        Long ans = 0L;
        for(int i=0; i<L; i++) {
            ans += (((int)ch[i] - 96) * r[i]) % 1234567891;
            ans %= 1234567891;
        }
        System.out.println(ans);
    }
}
