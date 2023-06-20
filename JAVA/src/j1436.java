import java.io.*;
public class j1436 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt=0;
        for(int i=666; i<=10000000; i++) {
            String s = Long.toString(i);
            if(s.contains("666")) {
                cnt++;
            }
            if(cnt >= n) {
                System.out.print(i);
                break;
            }
        }
    }
}
