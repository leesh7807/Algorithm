import java.io.*;
public class j1676 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int two = 0;
        int five = 0;
        for(int i=1; i<=n; i++) {
            int temp = i;
            while(true) {
                if(temp%5 == 0) {
                    five++;
                    temp /= 5;
                    continue;
                }
                else if(temp%2 == 0) {
                    two++;
                    temp /= 2;
                    continue;
                }
                break;
            }
        }
        int ans = two < five ? two : five;
        System.out.print(ans);
    }
}
