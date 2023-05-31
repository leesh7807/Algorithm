import java.util.*;
import java.io.*;
public class j14889 {
    static int n;
    static int[][] arr;
    static ArrayList<Integer> res = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[] visited = new boolean[n];
        comb(0, 0, visited);
        int ans = Integer.MAX_VALUE;
        for(Integer i : res) {
            ans = Math.min(ans, i); // 리스트에서 가장 작은 값
        } 
        bw.write(Long.toString(ans));
        bw.close();
    }
    public static void comb(int v, int depth, boolean[] visited) throws Exception {
        if(depth == n/2) { // 팀이 절반으로 나눠졌을 때
            int team1 = 0;
            int team2 = 0;
            for(int i=0; i<n; i++) {
                for(int j=i; j<n; j++) {
                    if(visited[i] && visited[j]) { // DFS로 방문한 팀1
                        team1 += (arr[i][j] + arr[j][i]);
                    }
                    if(!visited[i] && !visited[j]) { // DFS로 방문안한 팀2
                        team2 += (arr[i][j] + arr[j][i]);
                    }
                }
            }
            res.add(Math.abs(team1 - team2)); // 차이를 리스트에 저장
            return;
        }
        for(int i=v; i<n; i++) { // DFS
            if(!visited[i]) {
                visited[i] = true;
                comb(i, depth+1, visited);
                visited[i] = false;
            }
        }
    }
}

/* 20C10 * 20^2 브루트포스 시간복잡도
 * 20C10은 약 18만.
 * 20에서 1커질 때마다 2배씩 증가한다고 어림짐작하면 맞음.
*/