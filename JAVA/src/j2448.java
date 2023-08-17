import java.io.*;
import java.util.*;
public class j2448 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        N /= 3;
        StringBuilder sb = new StringBuilder("  *  \n * * \n*****");
        int length = 6;
        while(N > 1) {
            StringBuilder next = new StringBuilder();
            String blank = " ";
            String tab;
            int repeat = length/2;
            StringTokenizer st = new StringTokenizer(sb.toString(), "\n");
            tab = blank.repeat(repeat);
            // 기준의 앞 뒤에 공백을 추가해 담기
            while(st.hasMoreTokens()) {
                next.append(tab + st.nextToken() + tab + "\n");
            }
            st = new StringTokenizer(sb.toString(), "\n");
            // 그 아래에 기준을 두개 붙이기
            while(st.hasMoreTokens()) {
                String token = st.nextToken();
                next.append(token + " " + token + "\n");
            }
            // 새롭게 만든 것을 기준으로 교체
            sb = new StringBuilder(next.toString());
            N /= 2;
            length *= 2;
        }
        System.out.println(sb.toString());
    }
}
