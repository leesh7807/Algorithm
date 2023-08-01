import java.io.*;
import java.util.*;
public class j1043 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int knowN = Integer.parseInt(st.nextToken());
        LinkedList<Integer> know = new LinkedList<>();
        for(int k=0; k<knowN; k++) {
            know.add(Integer.parseInt(st.nextToken()));
        }
        boolean[][] party = new boolean[M][N+1];
        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int pN = Integer.parseInt(st.nextToken());
            for(int p=0; p<pN; p++) {
                party[m][Integer.parseInt(st.nextToken())] = true;
            }
        }
        boolean[] knowing = new boolean[N+1];
        while(!know.isEmpty()) {
            int k = know.poll();
            knowing[k] = true;
            for(int m=0; m<M; m++) {
                if(party[m][k]) {
                    for(int n=1; n<N+1; n++) {
                        if(party[m][n] && !knowing[n]) {
                            know.add(n);
                            knowing[n] = true;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for(int m=0; m<M; m++) {
            ans++;
            for(int n=1; n<N+1; n++) {
                if(party[m][n] && knowing[n]) {
                    ans--;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
