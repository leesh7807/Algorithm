import java.io.*;
public class j1929 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        int[] arr = new int[1000001];
        for(int i=2; i<arr.length; i++) {
            int temp = i;
            for(int j=i; j<arr.length; j+=temp) {
                arr[j]++;
            }
        }
        for(int i=m; i<=n; i++) {
            if(arr[i] == 1) {
                bw.write(Long.toString(i)+'\n');
            }
        }
        bw.close();
    }
}
