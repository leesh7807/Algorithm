import java.util.*;
import java.io.*;
import java.awt.Point;
public class j15686 {
    static int m;
    static ArrayList<Point> house = new ArrayList<>();
    static ArrayList<Point> chicken = new ArrayList<>();
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    house.add(new Point(i, j)); // �� ��ǥ
                }
                else if(arr[i][j] == 2) {
                    chicken.add(new Point(i, j)); // ġŲ ��ǥ
                }
            }
        }
        boolean[] visited = new boolean[chicken.size()];
        dfs(0, 0, visited); // dfs�� Ž���ϸ鼭 ġŲ ���� �����Ű�� ��� ����� ���� ���. ��� ġŲ �� ��� ��ų �Ϻ� ������ ����.
        bw.write(Long.toString(ans));
        bw.close();
    }

    public static void dfs(int v, int depth, boolean visited[]) throws Exception {
        if(depth == m) { // Ž�� ���� ����, ������� ġŲ�� ���õ�.
            int chickenLength = 0;
            for(Point h : house) { // ������ ���� ���� ���� ����� ġŲ�� ã��.
                int temp = Integer.MAX_VALUE;
                for(int i=0; i<visited.length; i++) {
                    if(visited[i]) { // �湮�� �� = ������ ġŲ��
                        Point c = chicken.get(i);
                        temp = Math.min(temp, Math.abs(c.x - h.x) + Math.abs(c.y - h.y));
                    }
                }
                chickenLength += temp; // ���� ���� ����� ġŲ������ �Ÿ��� ������. �ݺ��� ����� ����ġŲ�Ÿ�.
            }
            ans = Math.min(ans, chickenLength); // ���� ���̽� ����ġŲ�Ÿ��� ���� ���̽������ ��.
            return;
        }
        for(int i=v; i<visited.length; i++) { // dfs 
            if(!visited[i]) {
                visited[i] = true;
                dfs(i, depth+1, visited);
                visited[i] = false;
            }
        }
    }
}

// DFS. 13C6(2000, ����� ġŲ�� ����) * 100(��) * 13(ġŲ) 2�鸸 ����