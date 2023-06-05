import java.util.*;
import java.io.*;
public class j9663 {
    static int n;
    static int ans = 0;
    static boolean[] isVisited;
    static ArrayList<Integer> queen;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 1 ~ 14
        isVisited = new boolean[n];
        queen = new ArrayList<>();
        nQueen();
        bw.write(Long.toString(ans));
        bw.close();
    }
    public static void nQueen() {
        if(!queen.isEmpty()) {
            int nowQueen = queen.get(queen.size()-1);
            int nowRow = queen.size() - 1;
            for(int i=1; i<=nowRow; i++) {
                int prevQueen = queen.get(nowRow-i);
                if(prevQueen == nowQueen - i || prevQueen == nowQueen + i) {
                    return;
                }
            }
            if(nowRow+1 == n) {
                ans++;
                return;
            }
        }
        for(int i=0; i<n; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                queen.add(i);
                nQueen();
                queen.remove(queen.size()-1);
                isVisited[i] = false;
            }
        }
    }
}

/* n x n 체스판 위에 n개의 퀸을 서로 공격하지 못하도록 올리는 경우의 수
 * 어차피 한 행에 하나. 0부터 n-1까지 중복없이 열만 고르면 된다.
 * 1차원 배열의 인덱스가 곧 행. 0부터 시작해서 백트래킹 하면 됨.
 * 1행 1열에 놓였다. 행차이와 열차이가 일치하는 곳에 퀸이 놓여있으면 back.
 */