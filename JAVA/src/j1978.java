import java.io.*;
public class j1978 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[1001];
        for(int i=2; i<1001; i++) {
            int temp = i;
            for(int j=i; j<1001; j+=temp) {
                arr[j]++;
            }
        }
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int ans = 0;
        for(int i=0; i<n; i++) {
            if(arr[Integer.parseInt(s[i])] == 1) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
