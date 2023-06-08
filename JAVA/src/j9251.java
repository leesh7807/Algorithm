import java.io.*;
public class j9251 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int[][] arr = new int[s1.length()+1][s2.length()+1];
        for(int i=1; i<=s1.length(); i++) {
            for(int j=1; j<=s2.length(); j++) {
                if(s2.charAt(j-1) == s1.charAt(i-1)) {
                    arr[i][j] = arr[i-1][j-1] + 1;
                }
                if(arr[i][j] < arr[i][j-1]) {
                    arr[i][j] = arr[i][j-1];
                }
                if(arr[i][j] < arr[i-1][j]) {
                    arr[i][j] = arr[i-1][j];
                }
            }   
        }
        bw.write(Long.toString(arr[s1.length()][s2.length()]));
        bw.close();
    }
}
