import java.util.*;
import java.io.*;
public class j1074 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.println(merge(N, r, c));
    }
    public static int merge(int N, int r, int c) {
        if(r==0 && c==0) return 0;
        else if(r==0 && c==1) return 1;
        else if(r==1 && c==0) return 2;
        else if(r==1 && c==1) return 3;
        int stand = (int)Math.pow(2, N-1);
        if(r < stand && c < stand) {
            return merge(N-1, r, c);
        }
        else if(r < stand && c >= stand) {
            return stand*stand + merge(N-1, r, c-stand);
        }
        else if(r >= stand && c < stand) {
            return stand*stand*2 + merge(N-1, r-stand, c);
        }
        else {
            return stand*stand*3 + merge(N-1, r-stand, c-stand);
        }
    }
}
