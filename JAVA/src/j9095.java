import java.io.*;
public class j9095 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[11];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = arr[1] + arr[2] + 1;
        for(int i=4; i<11; i++) {
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(Long.toString(arr[n]) + '\n');
        }
        bw.close();
    }
}
