import java.io.*;
import java.util.*;
import java.awt.Point;

public class j14502 {
    static int n;
    static int m;
    static ArrayList<Point> virus;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        virus = new ArrayList<Point>(); // java.awt.Point 객체를 Pair처럼 사용하였음.
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) {
                    virus.add(new Point(i, j));
                }
            }
        }
        int ans = 0;
        for(int i=0; i<n*m-2; i++) { // 벽 세울 곳 3개 정하기는 조합. 3중 for문으로 구현한 (n*m) Combination 3 연산.
            if(arr[i/m][i%m] != 0) { continue; }
            for(int j=i+1; j<n*m-1; j++) {
                if(arr[j/m][j%m] != 0) { continue; }
                for(int k=j+1; k<n*m; k++) {
                    if(arr[k/m][k%m] != 0) { continue; }
                    int[][] temp = new int[arr.length][]; // 2차원 배열에 대한 깊은 복사.
                    for(int n=0; n<arr.length; n++) {
                        temp[n] = arr[n].clone();
                    }
                    temp[i/m][i%m] = 1; // m으로 나눈 몫은 행, 나머지는 열.
                    temp[j/m][j%m] = 1;
                    temp[k/m][k%m] = 1;
                    ans = Math.max(ans, check(temp, virus));
                }
            }
        }
        bw.write(Long.toString(ans));
        bw.close();
    }   
    public static int check(int arr[][], ArrayList<Point> virus) {
        int cnt = 0;
        Queue<Point> q = new LinkedList<>();
        for(Point p : virus) { // ArrayList에 저장한 바이러스 위치를 Queue로.
            q.add(p);
        }
        while(!q.isEmpty()) { // 바이러스 BFS로 퍼뜨리기.
            Point p = q.poll();
            for(int i=0; i<4; i++) {
                if(0 <= p.x+dx[i] && p.x+dx[i] < n && 0 <= p.y+dy[i] && p.y+dy[i] < m && arr[p.x+dx[i]][p.y+dy[i]] == 0) {
                    arr[p.x+dx[i]][p.y+dy[i]] = 2;
                    q.add(new Point(p.x+dx[i], p.y+dy[i]));
                }
            }
        }
        for(int i=0; i<n; i++) { // 안전구역 카운팅.
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

// 브루트포스로 풀어도 되는지 의심가는 경우가 많아서, 시간복잡도 계산을 무조건 해봐야겠다.
// 64C3 * 6(BFS) * 64는 대충 1억좀 넘을듯.