import java.io.*;
import java.util.*;
public class j20529 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] mbti = new int[16];
            for(int n=0; n<N; n++) {
                char[] temp = st.nextToken().toCharArray();
                String binary = new String();
                for(int i=0; i<4; i++) {
                    if(temp[i]=='I' || temp[i]=='N' || temp[i]=='F' || temp[i]=='P') {
                        binary += "0";
                    }
                    else {
                        binary += "1";
                    }
                }
                mbti[Integer.parseInt(binary, 2)]++;
            }
            int ans = Integer.MAX_VALUE;
            for(int i=0; i<16; i++) {
                for(int j=0; j<16; j++) {
                    for(int k=0; k<16; k++) {
                        mbti[i]--;
                        mbti[j]--;
                        mbti[k]--;
                        if(mbti[i]>=0 && mbti[j]>=0 && mbti[k]>=0) {
                            int tempAns = 0;
                            int a = i^j;
                            int b = j^k;
                            int c = k^i;
                            while(a>0 || b>0 || c>0) {
                                if((a&1)==1) {
                                    tempAns++;
                                }
                                if((b&1)==1) {
                                    tempAns++;
                                }
                                if((c&1)==1) {
                                    tempAns++;
                                }
                                a >>>= 1;
                                b >>>= 1;
                                c >>>= 1;
                            }
                            ans = Math.min(ans, tempAns);
                        }
                        mbti[i]++;
                        mbti[j]++;
                        mbti[k]++;
                    }
                }
            }
            bw.write(Long.toString(ans) + "\n");
        }
        bw.close();
    }
}
