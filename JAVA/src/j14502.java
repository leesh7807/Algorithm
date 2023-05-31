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
        virus = new ArrayList<Point>(); // java.awt.Point ��ü�� Pairó�� ����Ͽ���.
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
        for(int i=0; i<n*m-2; i++) { // �� ���� �� 3�� ���ϱ�� ����. 3�� for������ ������ (n*m) Combination 3 ����.
            if(arr[i/m][i%m] != 0) { continue; }
            for(int j=i+1; j<n*m-1; j++) {
                if(arr[j/m][j%m] != 0) { continue; }
                for(int k=j+1; k<n*m; k++) {
                    if(arr[k/m][k%m] != 0) { continue; }
                    int[][] temp = new int[arr.length][]; // 2���� �迭�� ���� ���� ����.
                    for(int n=0; n<arr.length; n++) {
                        temp[n] = arr[n].clone();
                    }
                    temp[i/m][i%m] = 1; // m���� ���� ���� ��, �������� ��.
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
        for(Point p : virus) { // ArrayList�� ������ ���̷��� ��ġ�� Queue��.
            q.add(p);
        }
        while(!q.isEmpty()) { // ���̷��� BFS�� �۶߸���.
            Point p = q.poll();
            for(int i=0; i<4; i++) {
                if(0 <= p.x+dx[i] && p.x+dx[i] < n && 0 <= p.y+dy[i] && p.y+dy[i] < m && arr[p.x+dx[i]][p.y+dy[i]] == 0) {
                    arr[p.x+dx[i]][p.y+dy[i]] = 2;
                    q.add(new Point(p.x+dx[i], p.y+dy[i]));
                }
            }
        }
        for(int i=0; i<n; i++) { // �������� ī����.
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

// ���Ʈ������ Ǯ� �Ǵ��� �ǽɰ��� ��찡 ���Ƽ�, �ð����⵵ ����� ������ �غ��߰ڴ�.
// 64C3 * 6(BFS) * 64�� ���� 1���� ������.