import java.io.*;
import java.util.*;
public class j2503 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        LinkedList<Integer> candi = new LinkedList<>();
        for(int i = 1; i <= 9; i++) {
            for(int j = 1; j <= 9; j++) {
                if(j == i) continue;
                for(int k = 1; k <= 9; k++) {
                    if(k == i || k == j) continue;
                    candi.add(i * 100 + j * 10 + k);
                }
            }
        }
        LinkedList<Integer> candi2 = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            while(!candi2.isEmpty()) {
                candi.add(candi2.poll());    
            }
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());            
            int ball = Integer.parseInt(st.nextToken());            
            int first = num / 100;
            int second = (num / 10) % 10;
            int third = num % 10;
            while(!candi.isEmpty()) {
                int s = 0;
                int b = 0;
                int temp = candi.poll();
                if(first == temp / 100) s++;
                if(second == (temp / 10) % 10) s++;
                if(third == temp % 10) s++;
                if(first == (temp / 10) % 10 || first == temp % 10) b++;
                if(second == temp / 100 || second == temp % 10) b++;
                if(third == temp/100 || third == (temp / 10) % 10) b++;
                if(s == strike && b == ball) candi2.add(temp);
            }
        }
        System.out.println(candi2.size());
    }
    
}

// 9 * 8 * 7 = 504