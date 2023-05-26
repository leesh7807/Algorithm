import java.util.*;
import java.io.*;
public class j15651 {
    static int n;
    static int m;
    static ArrayList<Integer> stack;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i=1; i<=n; i++) {
            stack = new ArrayList<>();
            backtracking(i);
        }
        bw.close();
    }

    public static void backtracking(int v) throws Exception{
        stack.add(v);
        if(stack.size() == m) {
            StringBuilder sb = new StringBuilder();
            for(Integer i : stack) {
                sb.append(Long.toString(i) + ' ');
            }
            bw.write(sb.toString() + "\n");
            return;
        }
        for(int i=1; i<=n; i++) {
            backtracking(i);
            stack.remove(stack.size() - 1);
        }
    }
}

/* 15649 비튼 문제2. 중복 순열.
 * 방문한 곳을 기록하지 않고 전부 다 들르도록 수정. 
 * System.out.println을 쓰면 시간초과. 항상 BufferedWriter를 써야겠다.
 */