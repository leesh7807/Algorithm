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
                    house.add(new Point(i, j)); // 집 좌표
                }
                else if(arr[i][j] == 2) {
                    chicken.add(new Point(i, j)); // 치킨 좌표
                }
            }
        }
        boolean[] visited = new boolean[chicken.size()];
        dfs(0, 0, visited); // dfs로 탐색하면서 치킨 집을 폐업시키는 모든 경우의 수를 고려. 모든 치킨 중 폐업 시킬 일부 선택은 조합.
        bw.write(Long.toString(ans));
        bw.close();
    }

    public static void dfs(int v, int depth, boolean visited[]) throws Exception {
        if(depth == m) { // 탐색 중지 조건, 폐업안할 치킨집 선택됨.
            int chickenLength = 0;
            for(Point h : house) { // 각각의 집에 대해 가장 가까운 치킨집 찾기.
                int temp = Integer.MAX_VALUE;
                for(int i=0; i<visited.length; i++) {
                    if(visited[i]) { // 방문한 곳 = 선택한 치킨집
                        Point c = chicken.get(i);
                        temp = Math.min(temp, Math.abs(c.x - h.x) + Math.abs(c.y - h.y));
                    }
                }
                chickenLength += temp; // 집과 가장 가까운 치킨집과의 거리를 더해줌. 반복문 결과는 도시치킨거리.
            }
            ans = Math.min(ans, chickenLength); // 현재 케이스 도시치킨거리와 이전 케이스들과의 비교.
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

// DFS. 13C6(2000, 폐업할 치킨집 고르기) * 100(집) * 13(치킨) 2백만 정도