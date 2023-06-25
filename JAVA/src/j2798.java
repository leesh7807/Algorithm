import java.io.*;
import java.util.*;
public class j2798 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        arr.sort(null);
        int ans = 0;
        for(int i=0; i<N-2; i++) {
            for(int j=i+1; j<N-1; j++) {
                for(int k=j+1; k<N; k++) {
                    int temp = arr.get(i) + arr.get(j) + arr.get(k);
                    if(temp <= M) {
                        ans = Math.max(ans, temp);
                    } 
                }
            }
        }
        System.out.println(ans);
    }
}
