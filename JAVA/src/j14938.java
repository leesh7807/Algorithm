import java.io.*;
import java.util.*;
public class j14938 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int spotCount = Integer.parseInt(st.nextToken());
        int range = Integer.parseInt(st.nextToken());
        int roadCount = Integer.parseInt(st.nextToken());
        int[] itemsInSpot = new int[spotCount+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=spotCount; i++) {
            itemsInSpot[i] = Integer.parseInt(st.nextToken());
        }
        int[][] graph = new int[spotCount+1][spotCount+1];
        for(int i=1; i<=spotCount; i++) {
            for(int j=1; j<=spotCount; j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=0; i<roadCount; i++) {
            st = new StringTokenizer(br.readLine());
            int spot1 = Integer.parseInt(st.nextToken());
            int spot2 = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            graph[spot1][spot2] = length;
            graph[spot2][spot1] = length;
        }
        for(int mid=1; mid<=spotCount; mid++) {
            for(int start=1; start<=spotCount; start++) {
                for(int end=1; end<=spotCount; end++) {
                    if(graph[start][mid] == Integer.MAX_VALUE || graph[mid][end] == Integer.MAX_VALUE) continue;
                    graph[start][end] = Math.min(graph[start][end], graph[start][mid] + graph[mid][end]);
                }
            }
        }
        int ans = 0;
        for(int i=1; i<=spotCount; i++) {
            int possibleItems = itemsInSpot[i];
            for(int j=1; j<=spotCount; j++) {
                if(graph[i][j] <= range && j != i) {
                    possibleItems += itemsInSpot[j];
                }
            }
            ans = Math.max(ans, possibleItems);
        }
        System.out.println(ans);
    }
}
