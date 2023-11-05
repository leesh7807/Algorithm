import java.io.*;
import java.util.*;
class j1083 {
    static int[] arr;
    static int s;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        sort();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++) {
            sb.append(Long.toString(arr[i]) + " ");
        }
        System.out.println(sb.toString());
    }
    public static void sort() {
        for(int i=0; i<arr.length; i++) {
            int max = -1;
            int idx = -1;
            for(int j=i; j<arr.length; j++) {
                if(arr[j] > max && j-i <= s) {
                    max = arr[j];
                    idx = j;
                }
            }
            for(int k=idx; k>i; k--) {
                int temp = arr[k];
                arr[k] = arr[k-1];
                arr[k-1] = temp;
            }
            s -= idx - i;
        }        
    }
}